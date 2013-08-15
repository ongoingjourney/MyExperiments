package com.sanjeeb.aop.driver;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sanjeeb.aop.application.Customer;
import com.sanjeeb.aop.concern.CafeOwner;

public class Driver {
	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("META-INF/SpringConfigFile.xml");
		
		Customer customer = (Customer)factory.getBean("customerProxy");
		CafeOwner cafeOwner = (CafeOwner)factory.getBean("cafeOwner");
		
		customer.browse();
		//cafeOwner.prepareBill();
	}
}
