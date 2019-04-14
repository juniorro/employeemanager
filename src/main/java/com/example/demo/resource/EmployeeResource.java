package com.example.demo.resource;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmployeeResource {

	@Autowired
	private EmployeeService employeeService;

	public EmployeeResource(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employeeList = employeeService.findAllEmployees();
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
		Employee employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable("name") String name) {
		List<Employee> employeeList = employeeService.findEmployeesByName(name);
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee) {
		employee.setUserCode(RandomStringUtils.randomAlphabetic(5));
		employeeService.AddEmployee(employee);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateAnEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAnEmployee(@PathVariable("id") Long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	} 


}
