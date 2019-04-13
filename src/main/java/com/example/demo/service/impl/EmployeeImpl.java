package com.example.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.service.EmployeeService;

@Service
@Transactional
public class EmployeeImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public void AddEmployee(Employee employee) {
		employeeRepo.save(employee);

	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee findEmployeeById(Long id) {
		return employeeRepo.findEmployeeById(id);
	}

	@Override
	public List<Employee> findEmployeesByName(String name) {
		return employeeRepo.findEmployeeByNameContaining(name);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepo.save(employee);

	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);

	}

}
