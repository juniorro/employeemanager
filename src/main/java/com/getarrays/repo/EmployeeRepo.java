package com.getarrays.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getarrays.model.Employee;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
	Employee findEmployeeById(Long id);

	List<Employee> findEmployeeByNameContaining(String name);

}
