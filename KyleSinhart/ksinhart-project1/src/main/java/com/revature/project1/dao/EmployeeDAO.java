package com.revature.project1.dao;

import java.util.List;

import com.revature.project1.beans.*;

public interface EmployeeDAO {
	
	public Employee createEmployee(Employee e);
	
	public Employee getEmployee(String email);
	
	public Employee getEmployee(int id);
	
	public Employee updateEmployee(String hometown, int phone,Employee e);
	
	public List<Employee> getEmployeeList();
	
	public void deleteEmployee(Employee e);
	
	
	
}
