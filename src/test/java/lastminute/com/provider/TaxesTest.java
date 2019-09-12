package lastminute.com.provider;

import lastminute.com.model.Genre;
import lastminute.com.provider.impl.SimpleTaxesProvider;
import lastminute.com.taxes.SimpleHandlerTaxes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaxesTest {

	private TaxesProvider<SimpleHandlerTaxes> taxesProvider;

	@Before
	public void init(){

		taxesProvider = new SimpleTaxesProvider();
	}


	@Test
	public void testTaxeBookPrice(){

		SimpleHandlerTaxes simpleHandlerTaxes = new SimpleHandlerTaxes(false, Genre.BOOKS,12.49f);

		Float taxes = taxesProvider.calculate(simpleHandlerTaxes);

		Assert.assertEquals(12.49f, 12.49f+taxes, 0);
	}


	@Test
	public void testTaxeGenericPrice(){

		SimpleHandlerTaxes simpleHandlerTaxes = new SimpleHandlerTaxes(false, Genre.GENERIC,14.99f);

		Float taxes = taxesProvider.calculate(simpleHandlerTaxes);

		Assert.assertEquals(16.49f, 14.99f+taxes, 0);
	}


	@Test
	public void testTaxeMedicalImportedPrice(){

		SimpleHandlerTaxes simpleHandlerTaxes = new SimpleHandlerTaxes(true, Genre.GENERIC,47.50f);

		Float taxes = taxesProvider.calculate(simpleHandlerTaxes);

		Assert.assertEquals(54.65f, 47.50f+taxes, 0);
	}
}
