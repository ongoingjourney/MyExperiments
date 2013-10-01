package com.sanjeeb.spring.webservice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sanjeeb.spring.webservice.persistence.DictionaryHelper;

@Controller
@RequestMapping("/*")
public class DictionaryController {
	
	@Autowired
	DictionaryHelper dictionaryHelper;
	
	@RequestMapping(value="/getWord/{word}", method=RequestMethod.GET)
	public @ResponseBody String getWord(@PathVariable("word") String word) {
		return dictionaryHelper.getDefinition(word);
	}
	
	@RequestMapping(value="/putWord/{word}/{meaning}", method=RequestMethod.GET)
	public @ResponseBody void putWord(@PathVariable("word") String word, @PathVariable("meaning") String meaning) {
		dictionaryHelper.addDefinition(word, meaning);
	}
	
	@RequestMapping(value="/getAllWords", method=RequestMethod.GET)
	public @ResponseBody String putWord() {
		Map<String, String> words = dictionaryHelper.getAllWords();
		StringBuilder builder = new StringBuilder("Here are the available definitons.<br/>");
		for(String key : words.keySet()) {
			builder.append(key).append(" : ").append(words.get(key)).append("<br/>");
		}
		return builder.toString();
	}
}