package lastminute.com.provider.impl;

import lastminute.com.provider.InputProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lastminute.com.parser.configurations.ItemConfigurations.SKIP_IN;


public class FileProviderImpl implements InputProvider {

	private static Logger log = LoggerFactory.getLogger(FileProviderImpl.class);

	@Override
	public List<String> readInput(String input) {
		try {
			Scanner scanner = new Scanner(new File(input));
			List<String> readAllLines = new ArrayList<>();
			StringBuffer stringBuffer = new StringBuffer();
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				if (line.startsWith(SKIP_IN)) continue;

				if (line.isEmpty()) {
					readAllLines.add(stringBuffer.toString());
					stringBuffer.delete(0, stringBuffer.length());
					continue;
				}
				stringBuffer.append(line);
				stringBuffer.append(";");

			}
			readAllLines.add(stringBuffer.toString());
			scanner.close();
			return readAllLines;
		} catch (IOException | NullPointerException e) {
			log.error(e.getMessage());
			return new ArrayList<>();
		}
	}
}
