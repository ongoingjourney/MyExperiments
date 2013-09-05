package com.sanjeeb.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {
	public static void main(String[] args) {
//		ApplicationContext appContext = new ClassPathXmlApplicationContext("META-INF/spring-context.xml");
//		BeanFactory factory = appContext;
//		
		BeanFactory factory = new ClassPathXmlApplicationContext("META-INF/spring-context.xml");
		
		Zoo zoo = (Zoo) factory.getBean("zoo");
		zoo.testSound();
	}
}