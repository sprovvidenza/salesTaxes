package lastminute.com.model;

import java.util.List;
import java.util.Objects;

public class Cart {

	private List<Product> producs;

	private Float salesTaxes;

	private Float total;

	public Cart(List<Product> producs, Float salesTaxes, Float total) {
		this.producs = producs;
		this.salesTaxes = salesTaxes;
		this.total = total;
	}

	public List<Product> getProducs() {
		return producs;
	}

	public void setProducs(List<Product> producs) {
		this.producs = producs;
	}

	public Float getSalesTaxes() {
		return salesTaxes;
	}

	public void setSalesTaxes(Float salesTaxes) {
		this.salesTaxes = salesTaxes;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Cart cart = (Cart) o;
		return Objects.equals(getProducs(), cart.getProducs()) &&
				Objects.equals(getSalesTaxes(), cart.getSalesTaxes()) &&
				Objects.equals(getTotal(), cart.getTotal());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getProducs(), getSalesTaxes(), getTotal());
	}

	@Override
	public String toString() {
		return "Cart{" +
				"producs=" + producs +
				", salesTaxes=" + salesTaxes +
				", total=" + total +
				'}';
	}
}
