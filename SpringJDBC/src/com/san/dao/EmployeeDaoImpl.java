package com.san.dao;

import javax.swing.tree.TreePath;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.san.model.Employee;

public class EmployeeDaoImpl implements EmployeeDAO {
	private JdbcTemplate jdbcTemplate;
	
	private final String employee_select = "SELECT * FROM employee WHERE empId = ?";
	private final String employee_insert = "INSERT INTO employee(employeeName, employeeDept, emailId) VALUES (?, ? , ? )";
	private final String employee_update = "UPDATE employee set employeeName=?, employeeDept=?, emailId = ? WHERE ";
	
	@Override
	public void saveEmployee(Employee e) {
		this.jdbcTemplate.update(this.employee_insert, new Object[]{e.getEmployeeName(), e.getEmployeeDept(), e.getEmpId()});
	}

	@Override
	public void updateEmployee(Employee e) {
		this.jdbcTemplate.update(this.employee_update, new Object[]{e.getEmployeeName(), e.getEmployeeDept(), e.getEmpId(),new Integer(e.getEmpId())});
	}

	@Override
	public Employee getEmployee(int empId) {
		return null;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
