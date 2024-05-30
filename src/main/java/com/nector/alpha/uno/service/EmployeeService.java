/**
 * 
 */
package com.nector.alpha.uno.service;

import java.util.List;

import com.nector.alpha.uno.entity.Employee;
import com.nector.alpha.uno.entity.UserDetails;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	UserDetails saveUser(UserDetails userDetails);

	List<Employee> fetchAllEmployees();

	Employee getEmployeeById(Long id);

	Employee updateEmployeeById(Long id, Employee employee);

	String deleteDepartmentById(Long id);
}