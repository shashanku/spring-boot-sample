/**
 * 
 */
package com.nector.alpha.uno.entity;

import java.sql.Timestamp;
import com.google.gson.annotations.SerializedName;

public class AuditLog {

	@SerializedName("id")
	private Long id;

	@SerializedName("event_name")
	private String eventName;

	@SerializedName("event_type")
	private String eventType;

	@SerializedName("transaction_id")
	private String transactionId;

	@SerializedName("remarks")
	private String remarks;

	@SerializedName("user_id")
	private String userId;

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
	public AuditLog() {
	}

	/**
	 * @param id
	 * @param eventName
	 * @param eventType
	 * @param transactionId
	 * @param remarks
	 * @param userId
	 * @param createdBy
	 * @param createdTimestamp
	 * @param updatedBy
	 * @param updatedTimestamp
	 */
	public AuditLog(Long id, String eventName, String eventType, String transactionId, String remarks, String userId,
			String createdBy, Timestamp createdTimestamp, String updatedBy, Timestamp updatedTimestamp) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.eventType = eventType;
		this.transactionId = transactionId;
		this.remarks = remarks;
		this.userId = userId;
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
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
		return "AuditLog [id=" + id + ", eventName=" + eventName + ", eventType=" + eventType + ", transactionId="
				+ transactionId + ", remarks=" + remarks + ", userId=" + userId + ", createdBy=" + createdBy
				+ ", createdTimestamp=" + createdTimestamp + ", updatedBy=" + updatedBy + ", updatedTimestamp="
				+ updatedTimestamp + "]";
	}

}