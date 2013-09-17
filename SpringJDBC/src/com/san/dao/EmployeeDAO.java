package com.san.dao;

import com.san.model.Employee;

public interface EmployeeDAO {
	public void saveEmployee(Employee e);
	public void updateEmployee(Employee e);
	public Employee getEmployee(int i);
}