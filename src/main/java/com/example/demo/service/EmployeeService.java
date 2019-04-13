package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {

	void AddEmployee(Employee employee);

	List<Employee>findAllEmployees();

	Employee findEmployeeById(Long id);

	List<Employee>findEmployeesByName(String name);

	void updateEmployee(Employee employee);

	void deleteEmployee(Long id);

}
