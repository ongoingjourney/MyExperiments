package com.sanjeeb.spring.webservice.persistence;

import java.util.Map;

public interface DictionaryHelper {
	public Map<String, String> getAllWords();
	public String getDefinition(String word);
	public void addDefinition(String word, String meaning);
	public void deleteDefinition(String word);
}
