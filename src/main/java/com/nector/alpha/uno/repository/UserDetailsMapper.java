/**
 * 
 */
package com.nector.alpha.uno.repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nector.alpha.uno.entity.UserDetailsRec;

/**
 * 
 */
public class UserDetailsMapper implements RowMapper<UserDetailsRec> {
	@Override
	public UserDetailsRec mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDetailsRec retval = new UserDetailsRec();

		if (!rs.wasNull()) {// this is unnecessary, but was done... reason: rs.next was setting it to pos
							// 2... this results in missing of first record always..
			do {

				String name = rs.getString("name");
				String email = rs.getString("email");
				BigDecimal userId = rs.getBigDecimal("user_id");
				String contact = rs.getString("contact");
				String address = rs.getString("user_address");
				Integer approvalStatus = rs.getInt("is_approved");
				float totalPoints = rs.getFloat("total_points");

				String strApprovalStatus = approvalStatus == 1 ? "Approved" : "Pending Approval";

				retval = new UserDetailsRec(name, email, userId, contact, address, totalPoints, strApprovalStatus);
			} while (rs.next());
		}

		return retval;
	}
}