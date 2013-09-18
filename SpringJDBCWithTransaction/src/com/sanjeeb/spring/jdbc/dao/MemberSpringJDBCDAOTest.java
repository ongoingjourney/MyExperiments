package com.sanjeeb.spring.jdbc.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sanjeeb.spring.jdbc.model.Member;

public class MemberSpringJDBCDAOTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertMember() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
                "resources/spring-config.xml");
		BeanFactory factory = (BeanFactory) context;
		MemberSpringJDBCDAO mDAO=(MemberSpringJDBCDAO) factory.getBean("memberDao");
		Member newMember = new Member("John","Doe","2121 FirstStreet","Doecity", "42345","jdoe@gmail.com","jondoe") ;
		int ret = mDAO.insertMember(newMember) ;
	}

}
