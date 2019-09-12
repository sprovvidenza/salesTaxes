package lastminute.com.provider;

import lastminute.com.AbstractTest;
import lastminute.com.provider.InputProvider;
import lastminute.com.provider.impl.FileProviderImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ReadFileTest extends AbstractTest {

	private InputProvider inputProvider;

	@Before
	public void init(){
		inputProvider = new FileProviderImpl();
	}

	@Test
	public void readFile(){

		List<String> items = inputProvider.readInput(pathFile);

		log.debug("items : {}",items);

		Assert.assertFalse(items.isEmpty());
	}


	@Test
	public void readErrorFile(){

		List<String> items = inputProvider.readInput("input-error.txt");

		log.debug("items : {}",items);

		Assert.assertTrue(items.isEmpty());
	}
}
