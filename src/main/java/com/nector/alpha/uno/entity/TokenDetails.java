/**
 * 
 */
package com.nector.alpha.uno.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import com.google.gson.annotations.SerializedName;

public class TokenDetails {

	@SerializedName("id")
	private Long id;

	@SerializedName("token_no")
	private BigInteger tokenNo;

	@SerializedName("commodity_code")
	private String commodityCode;

	@SerializedName("status")
	private String status;

	@SerializedName("is_redeemed")
	private Boolean isRedeemed;

	@SerializedName("bill_no")
	private String billNo;

	@SerializedName("is_valid_till")
	private Long isValidTill;

	@SerializedName("created_by")
	private String createdBy;

	@SerializedName("created_timestamp")
	private Timestamp createdTimestamp;

	@SerializedName("updated_by")
	private String updatedBy;

	@SerializedName("updated_timestamp")
	private Timestamp updatedTimestamp;

	/**
	 * 
	 */
	public TokenDetails() {
	}

	/**
	 * @param id
	 * @param tokenNo
	 * @param commodityCode
	 * @param status
	 * @param isRedeemed
	 * @param billNo
	 * @param isValidTill
	 * @param createdBy
	 * @param createdTimestamp
	 * @param updatedBy
	 * @param updatedTimestamp
	 */
	public TokenDetails(Long id, BigInteger tokenNo, String commodityCode, String status, Boolean isRedeemed,
			String billNo, Long isValidTill, String createdBy, Timestamp createdTimestamp, String updatedBy,
			Timestamp updatedTimestamp) {
		super();
		this.id = id;
		this.tokenNo = tokenNo;
		this.commodityCode = commodityCode;
		this.status = status;
		this.isRedeemed = isRedeemed;
		this.billNo = billNo;
		this.isValidTill = isValidTill;
		this.createdBy = createdBy;
		this.createdTimestamp = createdTimestamp;
		this.updatedBy = updatedBy;
		this.updatedTimestamp = updatedTimestamp;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the tokenNo
	 */
	public BigInteger getTokenNo() {
		return tokenNo;
	}

	/**
	 * @param tokenNo the tokenNo to set
	 */
	public void setTokenNo(BigInteger tokenNo) {
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the isRedeemed
	 */
	public Boolean getIsRedeemed() {
		return isRedeemed;
	}

	/**
	 * @param isRedeemed the isRedeemed to set
	 */
	public void setIsRedeemed(Boolean isRedeemed) {
		this.isRedeemed = isRedeemed;
	}

	/**
	 * @return the billNo
	 */
	public String getBillNo() {
		return billNo;
	}

	/**
	 * @param billNo the billNo to set
	 */
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	/**
	 * @return the isValidTill
	 */
	public Long getIsValidTill() {
		return isValidTill;
	}

	/**
	 * @param isValidTill the isValidTill to set
	 */
	public void setIsValidTill(Long isValidTill) {
		this.isValidTill = isValidTill;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdTimestamp
	 */
	public Timestamp getCreatedTimestamp() {
		return createdTimestamp;
	}

	/**
	 * @param createdTimestamp the createdTimestamp to set
	 */
	public void setCreatedTimestamp(Timestamp createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the updatedTimestamp
	 */
	public Timestamp getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	/**
	 * @param updatedTimestamp the updatedTimestamp to set
	 */
	public void setUpdatedTimestamp(Timestamp updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	/**
	 * @param user
	 * @param ts
	 */
	public void setAudits(String user, Timestamp ts) {
		this.createdBy = "SYSTEM";
		this.updatedBy = "SYSTEM";

		this.createdTimestamp = ts;
		this.updatedTimestamp = ts;

	}

	@Override
	public String toString() {
		return "TokenDetails [id=" + id + ", tokenNo=" + tokenNo + ", commodityCode=" + commodityCode + ", status="
				+ status + ", isRedeemed=" + isRedeemed + ", billNo=" + billNo + ", isValidTill=" + isValidTill
				+ ", createdBy=" + createdBy + ", createdTimestamp=" + createdTimestamp + ", updatedBy=" + updatedBy
				+ ", updatedTimestamp=" + updatedTimestamp + "]";
	}

}