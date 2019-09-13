package lastminute.com.application.configuration;

import lastminute.com.dictionary.InMemoryDictionary;
import lastminute.com.model.Product;
import lastminute.com.provider.DictionaryProvider;
import lastminute.com.provider.EnrichProvider;
import lastminute.com.provider.InputProvider;
import lastminute.com.provider.ParseProvider;
import lastminute.com.provider.TaxesProvider;
import lastminute.com.provider.impl.FileProviderImpl;
import lastminute.com.provider.impl.GenreEnrichProvider;
import lastminute.com.provider.impl.SimpleDictionaryProviderImpl;
import lastminute.com.provider.impl.SimpleParserProviderImpl;
import lastminute.com.provider.impl.SimpleTaxesProvider;
import lastminute.com.taxes.SimpleHandlerTaxes;
/*
*
* The istances of all providers used by application
*
* */
public class ConfigurationProvider {


	public static ParseProvider<Product> parseProvider(){
		ParseProvider<Product> parseProvider = new SimpleParserProviderImpl();
		return parseProvider;
	}

	public static EnrichProvider<Product> enrichProvider(){
		EnrichProvider<Product> enrichProvider = new GenreEnrichProvider(dictionaryProvider());
		return enrichProvider;
	}

	public static DictionaryProvider dictionaryProvider(){
		DictionaryProvider dictionaryProvider = new SimpleDictionaryProviderImpl(new InMemoryDictionary());
		return dictionaryProvider;
	}

	public static InputProvider inputProvider(){
		InputProvider provider = new FileProviderImpl();
		return provider;
	}

	public static TaxesProvider<SimpleHandlerTaxes> taxesProvider(){
		TaxesProvider<SimpleHandlerTaxes> taxesProvider = new SimpleTaxesProvider();
		return taxesProvider;
	}

}
