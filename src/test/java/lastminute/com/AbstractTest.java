package lastminute.com;

import lastminute.com.provider.InputProvider;
import lastminute.com.provider.impl.FileProviderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class AbstractTest {

	protected static Logger log = LoggerFactory.getLogger(AbstractTest.class);

	protected String pathFile = "src/test/resources/input.txt";

	protected List<String> input;


	protected void init(){
		InputProvider inputProvider = new FileProviderImpl();
		input = inputProvider.readInput(pathFile);
	}

}
