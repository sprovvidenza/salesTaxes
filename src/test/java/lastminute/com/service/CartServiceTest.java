package lastminute.com.service;

import lastminute.com.AbstractTest;
import lastminute.com.dictionary.InMemoryDictionary;
import lastminute.com.model.Cart;
import lastminute.com.model.Product;
import lastminute.com.parser.configurations.ItemConfigurations;
import lastminute.com.provider.DictionaryProvider;
import lastminute.com.provider.EnrichProvider;
import lastminute.com.provider.InputProvider;
import lastminute.com.provider.ParseProvider;
import lastminute.com.provider.TaxesProvider;
import lastminute.com.provider.impl.FileProviderImpl;
import lastminute.com.provider.impl.GenreEnrichProvider;
import lastminute.com.provider.impl.SimpleDictionaryProviderImpl;
import lastminute.com.provider.impl.SimpleParserProviderImpl;
import lastminute.com.provider.impl.SimpleTaxesProvider;
import lastminute.com.service.impl.CartServiceImpl;
import lastminute.com.service.impl.ProductServiceImpl;
import lastminute.com.taxes.SimpleHandlerTaxes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CartServiceTest extends AbstractTest {

	private CartService<Cart,Product> cartService;
	private ProductService<Product> productService;


	@Before
	public void init(){
		super.init();
		ParseProvider<Product> parseProvider = new SimpleParserProviderImpl();
		DictionaryProvider dictionaryProvider = new SimpleDictionaryProviderImpl(new InMemoryDictionary());
		EnrichProvider<Product> enrichProvider = new GenreEnrichProvider(dictionaryProvider);

		productService = new ProductServiceImpl(parseProvider,enrichProvider);

		TaxesProvider<SimpleHandlerTaxes> taxesProvider = new SimpleTaxesProvider();
		cartService = new CartServiceImpl(taxesProvider);
	}

	@Test
	public void testCart(){
		String[] splittedItem = input.get(0).split(ItemConfigurations.DELIMITER);
		List<Product> products = productService.getProducts(Arrays.asList(splittedItem));

		Cart cart = cartService.getCart(products);

		boolean result = cart.getSalesTaxes() == 1.50f && cart.getTotal() == 29.83F;

		Assert.assertTrue(result);
	}
}
