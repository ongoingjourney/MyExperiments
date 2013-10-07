package com.san.aop;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		BeanFactory factory = new ClassPathXmlApplicationContext("WEB-INF/ApplicationContext.xml");
		Rider rider = (Rider)factory.getBean("riderProxy");
		rider.ride();
	}
}