package com.sanjeeb.spring.webservice.application;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sanjeeb.spring.webservice.model.Entity;
import com.sanjeeb.spring.webservice.persistence.DictionaryDao;

public class TestApp {
	public static void main(String[] args) {
		BeanFactory context = new ClassPathXmlApplicationContext("resources/applicationContext.xml");
		DictionaryDao dictionaryDao = (DictionaryDao)context.getBean("dictionaryDao");
		Entity testWord = new Entity(){{setWord("glass"); setDefinition("small cylindrical container for drinking water");}};
		dictionaryDao.addDefinition(testWord);
		dictionaryDao.getDefinition(testWord);
	}
}
