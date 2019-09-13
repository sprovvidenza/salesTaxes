package lastminute.com.provider.impl;

import lastminute.com.dictionary.Dictionary;
import lastminute.com.model.Genre;
import lastminute.com.provider.DictionaryProvider;

import java.util.StringTokenizer;

/*
*
* Provider that return from an dictionary the correct genre or if it is not recognized return a default generic genre
*
* */
public class SimpleDictionaryProviderImpl implements DictionaryProvider {

	private Dictionary dictionary;

	public SimpleDictionaryProviderImpl(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	@Override
	public Genre search(String input) {
		StringTokenizer stringTokenizer = new StringTokenizer(input);
		Genre genre = Genre.GENERIC;
		while (stringTokenizer.hasMoreTokens()){
			String word = stringTokenizer.nextToken();
			Genre innerGenre = dictionary.getGenre(word);
			if(innerGenre.isNotGeneric())
				genre = innerGenre;
		}
		return genre;
	}


}
