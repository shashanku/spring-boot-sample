package com.nector.alpha.uno.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nector.alpha.uno.entity.TokenCommodityRec;

/**
 * @implNote Check for mapping: select td.token_no, td.commodity_code,
 *           cd.commodity_type, cd.points_generated,cd.description from
 *           natraj.token_details td, natraj.commodity_details cd where
 *           cd.commodity_code = td.commodity_code and cd.status = 1 and
 *           td.is_redeemed = 0 and td.status = 'A' and td.token_no = 45345;
 */
public class TokenRecMapper implements RowMapper<TokenCommodityRec> {
	@Override
	public TokenCommodityRec mapRow(ResultSet rs, int rowNum) throws SQLException {
		TokenCommodityRec rec = new TokenCommodityRec();

		if (!rs.wasNull()) { // this is unnecessary, but was done... reason: rs.next was setting it to pos
								// 2... this results in missing of first record always..

			// `name`,`type`,`address`,`pin`,`email`,`reg_id`,`act_code`

			Long tokenNo = rs.getLong("token_no");
			String commodityCode = rs.getString("commodity_code");
			String commodityType = rs.getString("commodity_type");
			float pointsGen = rs.getFloat("points_generated");
			String desc = rs.getString("description");

			rec = new TokenCommodityRec(tokenNo, commodityCode, commodityType, pointsGen, desc);

		}

		return rec;
	}
}