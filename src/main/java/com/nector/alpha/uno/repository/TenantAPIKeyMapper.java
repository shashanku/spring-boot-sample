/**
 * 
 */
package com.nector.alpha.uno.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

/**
 * 
 */
public class TenantAPIKeyMapper implements RowMapper<List<TenantApiKeyRecord>> {
	@Override
	public List<TenantApiKeyRecord> mapRow(ResultSet rs, int rowNum) throws SQLException {
		List<TenantApiKeyRecord> retval = new ArrayList<>();

		if (!rs.wasNull()) {// this is unnecessary, but was done... reason: rs.next was setting it to pos
							// 2... this results in missing of first record always..
			do {
				TenantApiKeyRecord rec = new TenantApiKeyRecord();
				rec.setId(rs.getInt("id"));
				rec.setName(rs.getString("name"));
				rec.setAddress(rs.getString("address"));
				rec.setApiKey(rs.getString("api_key"));

				retval.add(rec);
			} while (rs.next());
		}

		return retval;
	}
}