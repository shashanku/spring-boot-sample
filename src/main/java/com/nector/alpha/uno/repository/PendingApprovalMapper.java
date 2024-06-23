/**
 * 
 */
package com.nector.alpha.uno.repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.nector.alpha.uno.entity.PendingApprovalRec;

/**
 * 
 */
public class PendingApprovalMapper implements RowMapper<List<PendingApprovalRec>> {
	@Override
	public List<PendingApprovalRec> mapRow(ResultSet rs, int rowNum) throws SQLException {
		List<PendingApprovalRec> retval = new ArrayList<>();

		if (!rs.wasNull()) {// this is unnecessary, but was done... reason: rs.next was setting it to pos
							// 2... this results in missing of first record always..
			do {

				String name = rs.getString("name");
				String email = rs.getString("email");
				BigDecimal userId = rs.getBigDecimal("user_id");
				String contact = rs.getString("contact");
				String address = rs.getString("user_address");
				float totalPoints = rs.getFloat("total_points");

				PendingApprovalRec rec = new PendingApprovalRec(name, email, userId, contact, address, totalPoints);
				retval.add(rec);
			} while (rs.next());
		}

		return retval;
	}
}