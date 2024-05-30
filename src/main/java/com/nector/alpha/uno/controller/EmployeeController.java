/**
 * 
 */
package com.nector.alpha.uno.controller;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.nector.alpha.uno.entity.Employee;
import com.nector.alpha.uno.entity.UserDetails;
import com.nector.alpha.uno.service.EmployeeService;

/**
 * 
 */
@RestController
public class EmployeeController {
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
	private static final Gson gson = new Gson();

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employee) {

		return employeeService.saveEmployee(employee);
	}

	@PostMapping("/user")
	public UserDetails saveUser(@RequestBody UserDetails userDetails) {

		LOG.info("User input: {}", userDetails.toString());
		userDetails.setCreatedBy("SYSTEM");
		userDetails.setUpdatedBy("SYSTEM");

		userDetails.setCreatedTimestamp(new Timestamp(System.currentTimeMillis()));
		userDetails.setUpdatedTimestamp(new Timestamp(System.currentTimeMillis()));

		return employeeService.saveUser(userDetails);
	}

	@GetMapping("/employee")
	public List<Employee> getAllEmployees() {
		return employeeService.fetchAllEmployees();
	}

	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		return employeeService.getEmployeeById(id);
	}

	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
		return employeeService.updateEmployeeById(id, employee);
	}

	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable("id") Long id) {
		return employeeService.deleteDepartmentById(id);
	}
}