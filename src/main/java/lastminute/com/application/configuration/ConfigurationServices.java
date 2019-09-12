package lastminute.com.application.configuration;

import lastminute.com.model.Cart;
import lastminute.com.model.Product;
import lastminute.com.service.CartService;
import lastminute.com.service.ProductService;
import lastminute.com.service.impl.CartServiceImpl;
import lastminute.com.service.impl.ProductServiceImpl;

import static lastminute.com.application.configuration.ConfigurationProvider.enrichProvider;
import static lastminute.com.application.configuration.ConfigurationProvider.parseProvider;
import static lastminute.com.application.configuration.ConfigurationProvider.taxesProvider;

public class ConfigurationServices {

	public static CartService<Cart, Product> cartService(){
		CartService<Cart, Product> cartService = new CartServiceImpl(taxesProvider());
		return cartService;
	}


	public static ProductService<Product>  productService(){
		ProductService<Product> productService = new ProductServiceImpl(parseProvider(),enrichProvider());
		return productService;
	}

}
