package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
	
	public void AddEmployee(Employee employee);
	
	public List<Employee>findAllEmployees();
	
	public Employee findAnEmployeeById(Long id);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(Long id);

}
