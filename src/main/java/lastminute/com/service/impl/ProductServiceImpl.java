package lastminute.com.service.impl;

import lastminute.com.model.Product;
import lastminute.com.provider.EnrichProvider;
import lastminute.com.provider.ParseProvider;
import lastminute.com.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService<Product> {


	private final ParseProvider<Product> parseProvider;
	private final EnrichProvider<Product> enrichProvider;

	public ProductServiceImpl(ParseProvider<Product> parseProvider, EnrichProvider<Product> enrichProvider) {
		this.parseProvider = parseProvider;
		this.enrichProvider = enrichProvider;
	}

	@Override
	public List<Product> getProducts(List<String> items) {

		List<Product> returnValue = new ArrayList<>();
		items.forEach((item)->{
			Product product = parseProvider.parse(item);
			enrichProvider.enrich(product);
			returnValue.add(product);
		});

		return returnValue;
	}
}
