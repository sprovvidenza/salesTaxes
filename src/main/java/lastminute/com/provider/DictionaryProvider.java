package lastminute.com.provider;

import lastminute.com.model.Genre;

public interface DictionaryProvider {

	Genre search(String input);
}
