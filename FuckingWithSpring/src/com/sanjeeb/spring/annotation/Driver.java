package com.sanjeeb.spring.annotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/spring-annotation.xml");
		VisitorGuide visitorGuide = (VisitorGuide)beanFactory.getBean("visitorGuide");
		System.out.println(visitorGuide.getCurrentCityGuide());
	}
}