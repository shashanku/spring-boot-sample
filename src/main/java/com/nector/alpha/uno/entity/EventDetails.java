/**
 * 
 */
package com.nector.alpha.uno.entity;

import java.sql.Timestamp;
import com.google.gson.annotations.SerializedName;

public class EventDetails {

	@SerializedName("id")
	private Long id;

	@SerializedName("event_name")
	private String eventName;

	@SerializedName("event_type")
	private String eventType;

	@SerializedName("is_loggable")
	private Boolean isLoggable;

	@SerializedName("status")
	private String status;

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
	public EventDetails() {
	}

	/**
	 * @param id
	 * @param eventName
	 * @param eventType
	 * @param isLoggable
	 * @param status
	 * @param createdBy
	 * @param createdTimestamp
	 * @param updatedBy
	 * @param updatedTimestamp
	 */
	public EventDetails(Long id, String eventName, String eventType, Boolean isLoggable, String status,
			String createdBy, Timestamp createdTimestamp, String updatedBy, Timestamp updatedTimestamp) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.eventType = eventType;
		this.isLoggable = isLoggable;
		this.status = status;
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
	 * @return the isLoggable
	 */
	public Boolean getIsLoggable() {
		return isLoggable;
	}

	/**
	 * @param isLoggable the isLoggable to set
	 */
	public void setIsLoggable(Boolean isLoggable) {
		this.isLoggable = isLoggable;
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
		return "EventDetails [id=" + id + ", eventName=" + eventName + ", eventType=" + eventType + ", isLoggable="
				+ isLoggable + ", status=" + status + ", createdBy=" + createdBy + ", createdTimestamp="
				+ createdTimestamp + ", updatedBy=" + updatedBy + ", updatedTimestamp=" + updatedTimestamp + "]";
	}

}