package com.san.app;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.san.dao.EmployeeDAO;
import com.san.model.Employee;

public class TestSpringJDBC {
	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("resources/jdbc.xml");
		EmployeeDAO employeeDao = (EmployeeDAO)factory.getBean("employeeDao");
		
		Employee e = new Employee();
		e.setEmployeeName("Downy");
		e.setEmailId("downy@dept.com");
		e.setEmployeeDept("downyDept");
		employeeDao.saveEmployee(e);
		
		//Employee emp = employeeDao.getEmployee();
		
	}
}
