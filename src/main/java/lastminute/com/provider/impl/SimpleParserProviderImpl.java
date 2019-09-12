package lastminute.com.provider.impl;


import lastminute.com.model.Product;
import lastminute.com.model.builder.ProductBuilder;
import lastminute.com.provider.ParseProvider;

import static lastminute.com.parser.configurations.ItemConfigurations.*;

public class SimpleParserProviderImpl implements ParseProvider<Product> {


	@Override
	public Product parse(String input) {
		ProductBuilder builder = new ProductBuilder();

		String[] productElement = input.split(SPLIT_TOKEN);
		String product = extractProductTitle(productElement);

		builder.quantity(extractQuantity(productElement));
		builder.imported(extractImported(product));
		builder.title(product.trim());
		builder.price(extractPrice(productElement));

		return builder.build();
	}


	private int extractQuantity(String[] productElement){
		int quantityPosition = productElement[0].indexOf(EMPTY);
		String quantity = productElement[0].substring(0, quantityPosition);

		return Integer.parseInt(quantity);
	}

	private String extractProductTitle(String[] productElement){

		int quantityPosition = productElement[0].indexOf(EMPTY);
		return  productElement[0].substring(quantityPosition);
	}

	private Float extractPrice(String[] productElement){
		return Float.parseFloat(productElement[1]);
	}

	private boolean extractImported(String product){
		if (product.contains(IMPORTED)) return true;
		return false;
	}


}