package com.getarrays.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getarrays.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
	Optional<Employee> findEmployeeById(Long id);

	List<Employee> findEmployeeByNameContaining(String name);

}
