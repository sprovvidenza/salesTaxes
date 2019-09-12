package lastminute.com;

import lastminute.com.application.TaxesFileApplication;


public class App {
	public static void main(String[] args) {
		new TaxesFileApplication()
				.run(args[0]);
	}
}
