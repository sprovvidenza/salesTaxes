package lastminute.com.provider.impl;


import lastminute.com.model.Product;
import lastminute.com.model.builder.ProductBuilder;
import lastminute.com.provider.ParseProvider;

import static lastminute.com.parser.configurations.ItemConfigurations.*;

public class SimpleParserProviderImpl implements ParseProvider<Product> {


	@Override
	public Product parse(String input) {

		ProductBuilder builder = new ProductBuilder();
		String token = input;

		String[] split = token.split(SPLIT_TOKEN);


		String nonPrice = split[0];
		int quantityPosition = nonPrice.indexOf(EMPTY);

		String quantity = nonPrice.substring(0, quantityPosition);
		builder.quantity(Integer.parseInt(quantity));

		String product = nonPrice.substring(quantityPosition);

		if (product.contains(IMPORTED))
			builder.imported(true);

		builder.title(product.trim());

		String price = split[1];
		builder.price(Float.parseFloat(price));


		return builder.build();
	}


}