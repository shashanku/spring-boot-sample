/**
 * 
 */
package com.nector.alpha.uno.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import com.google.gson.annotations.SerializedName;

public class Transaction {

	@SerializedName("id")
	private Long id;

	@SerializedName("from_user_id")
	private String fromUserId;

	@SerializedName("to_user_id")
	private String toUserId;

	@SerializedName("token_no")
	private BigInteger tokenNo;

	@SerializedName("points_accrued")
	private Float pointsAccrued;

	@SerializedName("total_points")
	private Float totalPoints;

	@SerializedName("event_type")
	private String eventType;

	@SerializedName("event_name")
	private String eventName;

	@SerializedName("commodity_code")
	private String commodityCode;

	@SerializedName("remarks")
	private String remarks;

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
	public Transaction() {
	}

	/**
	 * @param id
	 * @param fromUserId
	 * @param toUserId
	 * @param tokenNo
	 * @param pointsAccrued
	 * @param totalPoints
	 * @param eventType
	 * @param eventName
	 * @param commodityCode
	 * @param remarks
	 * @param createdBy
	 * @param createdTimestamp
	 * @param updatedBy
	 * @param updatedTimestamp
	 */
	public Transaction(Long id, String fromUserId, String toUserId, BigInteger tokenNo, Float pointsAccrued,
			Float totalPoints, String eventType, String eventName, String commodityCode, String remarks,
			String createdBy, Timestamp createdTimestamp, String updatedBy, Timestamp updatedTimestamp) {
		super();
		this.id = id;
		this.fromUserId = fromUserId;
		this.toUserId = toUserId;
		this.tokenNo = tokenNo;
		this.pointsAccrued = pointsAccrued;
		this.totalPoints = totalPoints;
		this.eventType = eventType;
		this.eventName = eventName;
		this.commodityCode = commodityCode;
		this.remarks = remarks;
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
	 * @return the fromUserId
	 */
	public String getFromUserId() {
		return fromUserId;
	}

	/**
	 * @param fromUserId the fromUserId to set
	 */
	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}

	/**
	 * @return the toUserId
	 */
	public String getToUserId() {
		return toUserId;
	}

	/**
	 * @param toUserId the toUserId to set
	 */
	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
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
	 * @return the pointsAccrued
	 */
	public Float getPointsAccrued() {
		return pointsAccrued;
	}

	/**
	 * @param pointsAccrued the pointsAccrued to set
	 */
	public void setPointsAccrued(Float pointsAccrued) {
		this.pointsAccrued = pointsAccrued;
	}

	/**
	 * @return the totalPoints
	 */
	public Float getTotalPoints() {
		return totalPoints;
	}

	/**
	 * @param totalPoints the totalPoints to set
	 */
	public void setTotalPoints(Float totalPoints) {
		this.totalPoints = totalPoints;
	}

	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * @param eventType the eventType to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
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
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", fromUserId=" + fromUserId + ", toUserId=" + toUserId + ", tokenNo="
				+ tokenNo + ", pointsAccrued=" + pointsAccrued + ", totalPoints=" + totalPoints + ", eventType="
				+ eventType + ", eventName=" + eventName + ", commodityCode=" + commodityCode + ", remarks=" + remarks
				+ ", createdBy=" + createdBy + ", createdTimestamp=" + createdTimestamp + ", updatedBy=" + updatedBy
				+ ", updatedTimestamp=" + updatedTimestamp + "]";
	}

}