package lastminute.com.provider.impl;

import lastminute.com.model.Genre;
import lastminute.com.model.Product;
import lastminute.com.provider.DictionaryProvider;
import lastminute.com.provider.EnrichProvider;

public class GenreEnrichProvider implements EnrichProvider<Product> {

	private DictionaryProvider provider;

	public GenreEnrichProvider(DictionaryProvider provider) {
		this.provider = provider;
	}

	@Override
	public void enrich(Product type) {
		Genre genre = provider.search(type.getTitle());
		type.setGenre(genre);
	}
}
