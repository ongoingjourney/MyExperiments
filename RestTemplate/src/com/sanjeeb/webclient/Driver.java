package com.sanjeeb.webclient;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestClientException;

public class Driver {
	
	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("resources/applicationConfig.xml");
		test(factory);
	}
	private static void test(BeanFactory factory ) {
		Listener listener = (Listener )factory.getBean("listener");
		String requestXmlString = String.format(listener.getJsonRequestFormat(), 15, "kyian");
		
		HttpHeaders httpHeaders = listener.getHttpHeaders();
		HttpEntity request = new HttpEntity(requestXmlString, httpHeaders);
		try {
			String response = listener.getRestTemplate().postForObject(listener.getUri(), request, String.class);
			System.out.println(response);
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}