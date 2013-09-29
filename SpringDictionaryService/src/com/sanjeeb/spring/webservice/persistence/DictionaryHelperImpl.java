package com.sanjeeb.spring.webservice.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Required;

import com.sanjeeb.spring.webservice.model.Entity;

public class DictionaryHelperImpl implements DictionaryHelper {
	DictionaryDao dictionaryDao;
	
	@Override
	public Map<String, String> getAllWords() {
		List<Entity> wordList = dictionaryDao.getAllWords();
		Map<String, String> words = new HashMap<>();
		for(Entity entity : wordList){
			words.put(entity.getWord(), entity.getDefinition());
		}
		return words;
	}

	@Override
	public String getDefinition(final String word) {
		return dictionaryDao.getDefinition(new Entity(){{setWord(word);}}).getDefinition();
	}

	@Override
	public void addDefinition(final String word, final String meaning) {
		dictionaryDao.addDefinition(new Entity(){{setWord(word);setDefinition(meaning);}});
	}

	@Override
	public void deleteDefinition(final String word) {
		dictionaryDao.deleteWord(new Entity(){{setWord(word);}});
	}
	
	public DictionaryDao getDictionaryDao() {
		return dictionaryDao;
	}

	@Required
	public void setDictionaryDao(DictionaryDao dictionaryDao) {
		this.dictionaryDao = dictionaryDao;
	}
}