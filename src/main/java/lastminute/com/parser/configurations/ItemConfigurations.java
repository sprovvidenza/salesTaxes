package lastminute.com.parser.configurations;

/*
*
*
* Generic global configurations for the Application
*
* */
public class ItemConfigurations {


	//parsing input configurations
	public static String DELIMITER = ";";

	public static String SKIP_IN = "Input";

	public static String SPLIT_TOKEN = " at ";

	public static String IMPORTED = "imported";

	public static String EMPTY = " ";


	//Output patterns
	public static String SALES_TAXES_PATTERN = "Sales Taxes: %.2f \n";

	public static String TOTAL_PATTERN = "Total: %.2f \n";

	public static String PRODUCT_PATTERN = "%s %s: %.2f \n";

	public static String OUTPUT_PATTERN = "Output %s: \n";


	//Taxes percent
	public static Integer IMPORTED_PERCENT = 5;
	public static Integer GENERIC_PERCENT = 10;

}
