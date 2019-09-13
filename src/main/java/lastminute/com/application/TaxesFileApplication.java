package lastminute.com.application;

import lastminute.com.application.contex.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
*
* Main application
*
* */
public class TaxesFileApplication {

	private static Logger log = LoggerFactory.getLogger(TaxesFileApplication.class);


	public void run(String filename){
		String output = ApplicationContext.istance().getOutput(filename);
		log.info("{}", output);
	}

}
