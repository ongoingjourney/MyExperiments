package com.san;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReadConfigTest {

	public static void main(String[] args) {
    	BeanFactory factory = new ClassPathXmlApplicationContext("resources/applicationContext.xml");
    	SimpleBean simpleBean = (SimpleBean)factory.getBean("simpleBean");
    	System.out.println(simpleBean.toString());
	}
}