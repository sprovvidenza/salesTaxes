package lastminute.com.model;



import java.util.Objects;

public class Product {
	private int quantity;
	private Genre genre;
	private String title;
	private Float price;
	private Boolean imported;

	public Product(int quantity, Genre genre, String title, Float price, Boolean imported) {
		this.quantity = quantity;
		this.genre = genre;
		this.title = title;
		this.price = price;
		this.imported = imported;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Boolean getImported() {
		return imported;
	}

	public void setImported(Boolean imported) {
		this.imported = imported;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return getQuantity() == product.getQuantity() &&
				Objects.equals(getGenre(), product.getGenre()) &&
				Objects.equals(getTitle(), product.getTitle()) &&
				Objects.equals(getPrice(), product.getPrice()) &&
				Objects.equals(getImported(), product.getImported());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getQuantity(), getGenre(), getTitle(), getPrice(), getImported());
	}

	@Override
	public String toString() {
		return "Product{" +
				"quantity=" + quantity +
				", genre=" + genre +
				", title='" + title + '\'' +
				", price=" + price +
				", imported=" + imported +
				'}';
	}
}
