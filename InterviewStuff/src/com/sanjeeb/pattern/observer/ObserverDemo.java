package com.sanjeeb.pattern.observer;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObserverDemo {
	public static void main(String[] args) {
		doWithSpring();
	}	
	
	public static void doWithSpring() {
		BeanFactory factory = new ClassPathXmlApplicationContext("META-INF/spring-pattern-observer.xml");
		Observable observable = (Observable) factory.getBean("stockUpdate");

		observable.update("ibm", new Float(34.3));
		observable.update("msft", new Float(39.3));
	}
}