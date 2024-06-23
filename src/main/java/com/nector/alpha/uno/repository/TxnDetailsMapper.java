/**
 * 
 */
package com.nector.alpha.uno.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

/**
 * @implNote query: select t.id, t.created_timestamp, t.token_no,
 *           t.points_accrued, t.commodity_code from natraj.transactions t where
 *           t.event_name = 'SAVE_TRANSACTION' and from_user_id = 'alpha';
 * 
 * 
 */
public class TxnDetailsMapper implements RowMapper<List<TxnDTO>> {
	@Override
	public List<TxnDTO> mapRow(ResultSet rs, int rowNum) throws SQLException {
		List<TxnDTO> retval = new ArrayList<TxnDTO>();

		if (!rs.wasNull()) {// this is unnecessary, but was done... reason: rs.next was setting it to pos
							// 2... this results in missing of first record always..
			do {
//Long id, Float points, Long tokenNo, String commodityCode, Timestamp txnDate
				Long id = rs.getLong("id");
				float points = rs.getFloat("points_accrued");
				Long tokenNo = rs.getLong("token_no");
				String commodityCode = rs.getString("commodity_code");
				Timestamp txnDate = rs.getTimestamp("created_timestamp");

				TxnDTO rec = new TxnDTO(id, points, tokenNo, commodityCode, txnDate);
				retval.add(rec);
			} while (rs.next());
		}

		return retval;
	}
}