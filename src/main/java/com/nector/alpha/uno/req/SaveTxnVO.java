/**
 * 
 */
package com.nector.alpha.uno.req;

import java.math.BigInteger;
import java.sql.Timestamp;

import com.google.gson.annotations.SerializedName;

/**
 * 
 */
public class SaveTxnVO {

	@SerializedName("from_user_id")
	private String fromUserId;

	@SerializedName("token_no")
	private BigInteger tokenNo;

	@SerializedName("event_type")
	private String eventType;

	@SerializedName("event_name")
	private String eventName;

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
	public SaveTxnVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param fromUserId
	 * @param tokenNo
	 * @param eventType
	 * @param eventName
	 * @param remarks
	 * @param createdBy
	 * @param createdTimestamp
	 * @param updatedBy
	 * @param updatedTimestamp
	 */
	public SaveTxnVO(String fromUserId, BigInteger tokenNo, String eventType, String eventName, String remarks,
			String createdBy, Timestamp createdTimestamp, String updatedBy, Timestamp updatedTimestamp) {
		super();
		this.fromUserId = fromUserId;
		this.tokenNo = tokenNo;
		this.eventType = eventType;
		this.eventName = eventName;
		this.remarks = remarks;
		this.createdBy = createdBy;
		this.createdTimestamp = createdTimestamp;
		this.updatedBy = updatedBy;
		this.updatedTimestamp = updatedTimestamp;
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
		return "SaveTxnVO [fromUserId=" + fromUserId + ", tokenNo=" + tokenNo + ", eventType=" + eventType
				+ ", eventName=" + eventName + ", remarks=" + remarks + ", createdBy=" + createdBy
				+ ", createdTimestamp=" + createdTimestamp + ", updatedBy=" + updatedBy + ", updatedTimestamp="
				+ updatedTimestamp + "]";
	}

}
