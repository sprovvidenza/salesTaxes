package lastminute.com.provider;

import lastminute.com.taxes.Taxes;

public interface TaxesProvider<T extends Taxes> {

	Float calculate(T taxes);
}
