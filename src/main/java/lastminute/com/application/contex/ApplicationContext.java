package lastminute.com.application.contex;

import lastminute.com.model.Cart;
import lastminute.com.model.Product;
import lastminute.com.parser.configurations.ItemConfigurations;
import lastminute.com.provider.InputProvider;
import lastminute.com.service.CartService;
import lastminute.com.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static lastminute.com.application.configuration.ConfigurationProvider.inputProvider;
import static lastminute.com.application.configuration.ConfigurationServices.cartService;
import static lastminute.com.application.configuration.ConfigurationServices.productService;
import static lastminute.com.parser.configurations.ItemConfigurations.OUTPUT_PATTERN;
import static lastminute.com.parser.configurations.ItemConfigurations.PRODUCT_PATTERN;
import static lastminute.com.parser.configurations.ItemConfigurations.SALES_TAXES_PATTERN;
import static lastminute.com.parser.configurations.ItemConfigurations.TOTAL_PATTERN;

public class ApplicationContext implements Context {

	private static Logger log = LoggerFactory.getLogger(ApplicationContext.class);

	private static ApplicationContext applicationContext;

	private final InputProvider inputProvider;

	private final CartService<Cart, Product> cartService;

	private final ProductService<Product> productService;


	private ApplicationContext() {
		this.inputProvider = inputProvider();
		this.cartService = cartService();
		this.productService = productService();
	}

	public static ApplicationContext istance() {
		if (applicationContext == null)
			applicationContext = new ApplicationContext();
		return applicationContext;
	}

	public String getOutput(String filename) {

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("\n");
		stringBuffer.append("OUTPUT \n\n");

		formatCarts(filename, stringBuffer);

		return stringBuffer.toString();
	}

	private void formatCarts(String filename, StringBuffer stringBuffer) {

		List<String> orders = inputProvider.readInput(filename);
		int itemCount = 1;
		for (String order : orders) {
			List<String> products = Arrays.asList(order.split(ItemConfigurations.DELIMITER));

			List<Product> productList = productService.getProducts(products);

			Cart cart = cartService.getCart(productList);

			prepareOutput(cart, stringBuffer, itemCount);
			itemCount++;
			log.debug("{}", cart);
		}
	}

	private void prepareOutput(Cart cart, StringBuffer stringBuffer, int itemCount) {
		stringBuffer.append(String.format(OUTPUT_PATTERN, itemCount));
		for (Product product : cart.getProducs()) {

			final String productFormatted = String.format(Locale.US, PRODUCT_PATTERN, product.getQuantity(),
					product.getTitle(), product.getPrice());
			stringBuffer.append(productFormatted);
		}

		stringBuffer.append(String.format(Locale.US, SALES_TAXES_PATTERN, cart.getSalesTaxes()));
		stringBuffer.append(String.format(Locale.US, TOTAL_PATTERN, cart.getTotal()));
		stringBuffer.append("\n");
	}


}
