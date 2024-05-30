package com.nector.alpha.uno.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nector.alpha.uno.entity.Employee;

public class EmployeeRecMapper implements RowMapper<Employee> {
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee rec = new Employee();

		if (!rs.wasNull()) { // this is unnecessary, but was done... reason: rs.next was setting it to pos
								// 2... this results in missing of first record always..

			// `name`,`type`,`address`,`pin`,`email`,`reg_id`,`act_code`

			Long id = rs.getLong("employee_id");
			String name = rs.getString("employee_name");
			float salary = rs.getFloat("employee_salary");

			rec = new Employee(id, name, salary);

		}

		return rec;
	}
}