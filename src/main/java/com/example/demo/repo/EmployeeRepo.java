package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
	@Query("SELECT e FROM Employee e WHERE e.id=:id")
	public Employee findEmployeeById(@Param("id") Long id);

}
