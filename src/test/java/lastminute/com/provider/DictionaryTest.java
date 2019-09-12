package lastminute.com.provider;

import lastminute.com.AbstractTest;
import lastminute.com.dictionary.InMemoryDictionary;
import lastminute.com.model.Genre;
import lastminute.com.provider.impl.SimpleDictionaryProviderImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DictionaryTest extends AbstractTest {

	public DictionaryProvider dictionaryProvider;

	@Before
	public void init() {
		InMemoryDictionary inMemoryDictionary = new InMemoryDictionary();
		dictionaryProvider = new SimpleDictionaryProviderImpl(inMemoryDictionary);
	}

	@Test
	public void testSearchBookGenre() {

		Genre book = dictionaryProvider.search("book");

		Assert.assertEquals(book, Genre.BOOKS);

	}

	@Test
	public void testSearchFoodGenre() {

		Genre food = dictionaryProvider.search("chocolate bar");

		Assert.assertEquals(food, Genre.FOOD);

	}

	@Test
	public void testSearchMedicalGenre() {

		Genre medical = dictionaryProvider.search("packet of headache pills");

		Assert.assertEquals(medical, Genre.MEDICAL);

	}


	@Test
	public void testSearchGenericGenre() {

		Genre generic = dictionaryProvider.search("music CD");

		Assert.assertEquals(generic, Genre.GENERIC);

	}
}
