package lastminute.com.dictionary;

import lastminute.com.model.Genre;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class InMemoryDictionary implements Dictionary {

	private HashMap<String, Genre> dictionary;


	public InMemoryDictionary() {
		this.dictionary = new HashMap<>();
		new ElementDictionary().getElement().forEach((element)->{
			String[] elementSplit = element.split("\\|");
			String word = elementSplit[0];
			Genre genre = Genre.valueOf(elementSplit[1]);
			dictionary.put(word,genre);
		});

	}

	@Override
	public Genre getGenre(String word){
		if(dictionary.containsKey(word)){
			return dictionary.get(word);
		}
		return Genre.GENERIC;
	}


	public static class ElementDictionary{
		List<String> element;

		private ElementDictionary() {
			element = Arrays.asList(
					"book|BOOKS",
					"chocolate|FOOD",
					"chocolates|FOOD",
					"headache|MEDICAL",
					"pills|MEDICAL"
					);
		}

		public List<String> getElement(){
			return element;
		}
	}
}
