package lastminute.com.provider.impl;

import lastminute.com.model.Genre;
import lastminute.com.provider.TaxesProvider;
import lastminute.com.taxes.SimpleHandlerTaxes;

import static lastminute.com.parser.configurations.ItemConfigurations.GENERIC_PERCENT;
import static lastminute.com.parser.configurations.ItemConfigurations.IMPORTED_PERCENT;

public class SimpleTaxesProvider implements TaxesProvider<SimpleHandlerTaxes> {

	@Override
	public Float calculate(SimpleHandlerTaxes taxes) {

		int applyTaxes = 0;

		Genre genre = taxes.getGenre();

		if(taxes.getImported())
			applyTaxes += IMPORTED_PERCENT;

		if(genre.isGeneric())
			applyTaxes += GENERIC_PERCENT;

		float tax = (taxes.getPrice() * (applyTaxes) / 100.0f);

		tax = (float) (Math.ceil(tax * 20) / 20);

		return tax;
	}
}
