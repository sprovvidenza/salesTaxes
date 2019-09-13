package lastminute.com.service.impl;

import lastminute.com.model.Cart;
import lastminute.com.model.Product;
import lastminute.com.model.builder.CartBuilder;
import lastminute.com.provider.TaxesProvider;
import lastminute.com.service.CartService;
import lastminute.com.taxes.SimpleHandlerTaxes;

import java.util.List;
/*
*
* Service that use @lastminute.com.provider.TaxesProvider to return the order (@lastminute.com.model.Cart)
* with total and salesTaxes populated correctly
*
* */
public class CartServiceImpl implements CartService<Cart, Product> {

	private final TaxesProvider<SimpleHandlerTaxes> taxesProvider;

	public CartServiceImpl(TaxesProvider<SimpleHandlerTaxes> taxesProvider) {
		this.taxesProvider = taxesProvider;
	}

	@Override
	public Cart getCart(List<Product> products) {
		Float total = 0f;
		Float totalTaxes = 0f;

		for (Product item : products) {
			SimpleHandlerTaxes simpleHandlerTaxes = new SimpleHandlerTaxes(item.getImported(),
					item.getGenre(),
					item.getPrice());
			Float taxes = taxesProvider.calculate(simpleHandlerTaxes);
			item.setPrice(item.getPrice()+taxes);
			total += item.getPrice();
			totalTaxes += taxes;
		}

		CartBuilder cartBuilder = new CartBuilder();
		cartBuilder.products(products);
		cartBuilder.total(total);
		cartBuilder.salesTaxes(totalTaxes);
		return cartBuilder.build();
	}
}
