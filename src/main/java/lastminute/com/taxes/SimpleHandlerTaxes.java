package lastminute.com.taxes;

import lastminute.com.model.Genre;

public class SimpleHandlerTaxes implements Taxes{
	private Boolean imported;
	private Genre genre;
	private Float price;

	public SimpleHandlerTaxes(Boolean imported, Genre genre, Float price) {
		this.imported = imported;
		this.genre = genre;
		this.price = price;
	}

	public Boolean getImported() {
		return imported;
	}

	public Genre getGenre() {
		return genre;
	}

	public Float getPrice() {
		return price;
	}
}
