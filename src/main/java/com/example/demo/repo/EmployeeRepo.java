package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
	Employee findEmployeeById(Long id);

	List<Employee> findEmployeeByNameContaining(String name);

}
