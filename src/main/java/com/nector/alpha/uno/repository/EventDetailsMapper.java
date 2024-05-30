/**
 * 
 */
package com.nector.alpha.uno.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.nector.alpha.uno.entity.EventDetails;

/**
 * 
 */
public class EventDetailsMapper implements RowMapper<List<EventDetails>> {
	@Override
	public List<EventDetails> mapRow(ResultSet rs, int rowNum) throws SQLException {
		List<EventDetails> retval = new ArrayList<>();

		if (!rs.wasNull()) {// this is unnecessary, but was done... reason: rs.next was setting it to pos
							// 2... this results in missing of first record always..
			do {
				EventDetails rec = new EventDetails();
				String status = rs.getString("status");
				if (status.equals("D"))
					continue;

				rec.setId(rs.getInt("id") * 1L);
				rec.setEventName(rs.getString("event_name"));
				rec.setEventType(rs.getString("event_type"));
				rec.setIsLoggable(rs.getBoolean("is_loggable"));
				rec.setStatus(status);

				retval.add(rec);
			} while (rs.next());
		}

		return retval;
	}
}