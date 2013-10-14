package com.san.redis;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("resources/applicationContext.xml");
		CounterDao counterDao = (CounterDao)factory.getBean("counterDao");
		//System.out.println(counterDao.logSignInAttempt());
		counterDao.logSignInAttempt("asdf");
		counterDao.logSignInAttempt("asdf");
		counterDao.logSignInAttempt("asdf");
		counterDao.logSignInAttempt("asdf");
		counterDao.logSignInAttempt("asdf");
	}
}