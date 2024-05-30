/**
 * 
 */
package com.nector.alpha.uno.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;

	private String employeeName;

	private float employeeSalary;

	/**
	 * 
	 */
	public Employee() {
	}

	/**
	 * @param employeeId
	 * @param employeeName
	 * @param employeeSalary
	 */
	public Employee(Long employeeId, String employeeName, float employeeSalary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
	}

	/**
	 * @param employeeName
	 * @param employeeSalary
	 */
	public Employee(String employeeName, float employeeSalary) {
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
	}

	/**
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the employeeSalary
	 */
	public float getEmployeeSalary() {
		return employeeSalary;
	}

	/**
	 * @param employeeSalary the employeeSalary to set
	 */
	public void setEmployeeSalary(float employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeSalary="
				+ employeeSalary + "]";
	}

}