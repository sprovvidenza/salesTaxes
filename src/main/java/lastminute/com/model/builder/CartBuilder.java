package lastminute.com.model.builder;

import lastminute.com.model.Cart;
import lastminute.com.model.Product;

import java.util.List;

public class CartBuilder {

	private List<Product> producs;

	private Float salesTaxes;

	private Float total;

	public CartBuilder() {
	}

	public CartBuilder total(Float total){
		this.total = total;
		return this;
	}

	public CartBuilder salesTaxes(Float salesTaxes){
		this.salesTaxes = salesTaxes;
		return this;
	}

	public CartBuilder products(List<Product> products){
		this.producs = products;
		return this;
	}

	public Cart build(){
		return new Cart(this.producs,this.salesTaxes, this.total);
	}

	@Override
	public String toString() {
		return "CartBuilder{" +
				"producs=" + producs +
				", salesTaxes=" + salesTaxes +
				", total=" + total +
				'}';
	}
}
