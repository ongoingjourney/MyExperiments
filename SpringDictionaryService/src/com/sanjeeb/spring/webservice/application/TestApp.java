package com.sanjeeb.spring.webservice.application;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sanjeeb.spring.webservice.model.Entity;
import com.sanjeeb.spring.webservice.persistence.DictionaryDao;
import com.sanjeeb.spring.webservice.persistence.DictionaryHelper;

public class TestApp {
	public static void main(String[] args) {
		BeanFactory context = new ClassPathXmlApplicationContext("resources/applicationContext.xml");
		DictionaryHelper dictionaryHelper = (DictionaryHelper)context.getBean("dictionaryHelper");
		Entity testWord = new Entity(){{setWord("glass"); setDefinition("small cylindrical container for drinking water");}};
		//dictionaryHelper.addDefinition("computer", "aMachine");
		//dictionaryHelper.getDefinition("computer");
		System.out.println(dictionaryHelper.getAllWords());
	}
}
