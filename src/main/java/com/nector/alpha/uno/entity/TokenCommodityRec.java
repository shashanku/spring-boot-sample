/**
 * 
 */
package com.nector.alpha.uno.entity;

/**
 * @implNote Check for query select td.token_no, td.commodity_code,
 *           cd.commodity_type, cd.points_generated,cd.description from
 *           natraj.token_details td, natraj.commodity_details cd where
 *           cd.commodity_code = td.commodity_code and cd.status = 1 and
 *           td.is_redeemed = 0 and td.status = 'A' and td.token_no = 45345;
 */
public class TokenCommodityRec {

	private Long tokenNo;// ` int NOT NULL,
	private String commodityCode;// ` varchar(45) DEFAULT NULL,
	private String commodityType;// ` varchar(45) DEFAULT NULL,
	private Float pointsGen;// ` varchar(45) DEFAULT NULL,
	private String description;// ` varchar(45) DEFAULT NULL,

	/**
	 * 
	 */
	public TokenCommodityRec() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param tokenNo
	 * @param commodityCode
	 * @param commodityType
	 * @param pointsGenreated
	 * @param description
	 */
	public TokenCommodityRec(Long tokenNo, String commodityCode, String commodityType, Float pointsGen,
			String description) {
		super();
		this.tokenNo = tokenNo;
		this.commodityCode = commodityCode;
		this.commodityType = commodityType;
		this.pointsGen = pointsGen;
		this.description = description;
	}

	/**
	 * @return the tokenNo
	 */
	public Long getTokenNo() {
		return tokenNo;
	}

	/**
	 * @param tokenNo the tokenNo to set
	 */
	public void setTokenNo(Long tokenNo) {
		this.tokenNo = tokenNo;
	}

	/**
	 * @return the commodityCode
	 */
	public String getCommodityCode() {
		return commodityCode;
	}

	/**
	 * @param commodityCode the commodityCode to set
	 */
	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}

	/**
	 * @return the commodityType
	 */
	public String getCommodityType() {
		return commodityType;
	}

	/**
	 * @param commodityType the commodityType to set
	 */
	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}

	/**
	 * @return the pointsGen
	 */
	public Float getPointsGen() {
		return pointsGen;
	}

	/**
	 * @param pointsGen the pointsGen to set
	 */
	public void setPointsGen(Float pointsGen) {
		this.pointsGen = pointsGen;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TokenCommodityRec [tokenNo=" + tokenNo + ", commodityCode=" + commodityCode + ", commodityType="
				+ commodityType + ", pointsGen=" + pointsGen + ", description=" + description + "]";
	}

}