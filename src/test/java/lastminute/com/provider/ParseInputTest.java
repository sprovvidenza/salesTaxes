package lastminute.com.provider;

import lastminute.com.AbstractTest;
import lastminute.com.dictionary.InMemoryDictionary;
import lastminute.com.model.Genre;
import lastminute.com.model.Product;
import lastminute.com.model.builder.ProductBuilder;
import lastminute.com.parser.configurations.ItemConfigurations;
import lastminute.com.provider.impl.GenreEnrichProvider;
import lastminute.com.provider.impl.SimpleDictionaryProviderImpl;
import lastminute.com.provider.impl.SimpleParserProviderImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParseInputTest extends AbstractTest {

	private ParseProvider<Product> parser;
	private Product productExpected;
	private Product productEnrichedExpected;
	private EnrichProvider<Product> enrichProvider;


	@Before
	public void init(){
		super.init();
		DictionaryProvider dictionaryProvider = new SimpleDictionaryProviderImpl(new InMemoryDictionary());
		enrichProvider = new GenreEnrichProvider(dictionaryProvider);

		parser = new SimpleParserProviderImpl();

		productExpected = new ProductBuilder()
				.genre(null)
				.title("book")
				.imported(false)
				.price(12.49f)
				.quantity(1)
				.build();

		productEnrichedExpected = new ProductBuilder()
				.genre(Genre.BOOKS)
				.title("book")
				.imported(false)
				.price(12.49f)
				.quantity(1)
				.build();
	}

	@Test
	public void parseSingleProduct(){

		String item = input.get(0).split(ItemConfigurations.DELIMITER)[0];

		Product product = parser.parse(item);

		Assert.assertEquals(productExpected, product);

	}

	@Test
	public void genreEnrichSingleProduct(){
		String item = input.get(0).split(ItemConfigurations.DELIMITER)[0];

		Product product = parser.parse(item);

		enrichProvider.enrich(product);

		Assert.assertEquals(productEnrichedExpected,product);

	}


}
