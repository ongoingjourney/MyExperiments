package com.sanjeeb.springwithannotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/springwithannotation.xml");
		VisitorGuide visitorGuide = (VisitorGuide)beanFactory.getBean("visitorGuide");
		System.out.println(visitorGuide.getCurrentCityGuide());
	}
}
