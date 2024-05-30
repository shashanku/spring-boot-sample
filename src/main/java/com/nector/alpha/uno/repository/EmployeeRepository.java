/**
 * 
 */
package com.nector.alpha.uno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nector.alpha.uno.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}