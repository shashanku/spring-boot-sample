/**
 * 
 */
package com.nector.alpha.uno.entity;

import java.sql.Timestamp;
import com.google.gson.annotations.SerializedName;

public class UserDetails {

	@SerializedName("id")
	private Long id;// ` int NOT NULL,

	private String email;// ` varchar(45) DEFAULT NULL,

	@SerializedName("contact")
	private String contact;// ` varchar(45) DEFAULT NULL,

	@SerializedName("user_id")
	private String userId;// ` varchar(45) DEFAULT NULL,

	@SerializedName("user_type")
	private String userType;// ` varchar(45) DEFAULT NULL,

	@SerializedName("is_approved")
	private Boolean isApproved = false;// ` tinyint DEFAULT NULL,

	@SerializedName("status")
	private String status;// ` varchar(45) DEFAULT NULL,

	@SerializedName("exchange_rate")
	private Float exchangeRate;// ` float DEFAULT NULL,

	@SerializedName("total_points")
	private Float totalPoints;// ` float DEFAULT NULL,

	@SerializedName("is_apply_exchange_rate")
	Boolean isApplyExchangeRate;// ` tinyint DEFAULT NULL,

	@SerializedName("created_by")
	private String createdBy;// ` varchar(45) DEFAULT NULL,

	@SerializedName("created_timestamp")
	private Timestamp createdTimestamp;// ` timestamp NULL DEFAULT NULL,

	@SerializedName("updated_by")
	private String updatedBy;// ` varchar(45) DEFAULT NULL,

	@SerializedName("updated_timestamp")
	private Timestamp updatedTimestamp;// ` timestamp NULL DEFAULT NULL,

	/**
	 * 
	 */
	public UserDetails() {
	}

	/**
	 * @param employeeId
	 * @param id
	 * @param email
	 * @param contact
	 * @param userId
	 * @param userType
	 * @param isApproved
	 * @param status
	 * @param exchangeRate
	 * @param totalPoints
	 * @param isApplyExchangeRate
	 * @param createdBby
	 * @param createdTimestamp
	 * @param updatedBy
	 * @param updatedTimestamp
	 */
	public UserDetails(Long id, String email, String contact, String userId, String userType, Boolean isApproved,
			String status, Float exchangeRate, Float totalPoints, Boolean isApplyExchangeRate, String createdBy,
			Timestamp createdTimestamp, String updatedBy, Timestamp updatedTimestamp) {
		super();
		this.id = id;
		this.email = email;
		this.contact = contact;
		this.userId = userId;
		this.userType = userType;
		this.isApproved = isApproved;
		this.status = status;
		this.exchangeRate = exchangeRate;
		this.totalPoints = totalPoints;
		this.isApplyExchangeRate = isApplyExchangeRate;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
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
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return the isApproved
	 */
	public Boolean getIsApproved() {
		return isApproved;
	}

	/**
	 * @param isApproved the isApproved to set
	 */
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
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
	 * @return the exchangeRate
	 */
	public Float getExchangeRate() {
		return exchangeRate;
	}

	/**
	 * @param exchangeRate the exchangeRate to set
	 */
	public void setExchangeRate(Float exchangeRate) {
		this.exchangeRate = exchangeRate;
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
	 * @return the isApplyExchangeRate
	 */
	public Boolean getIsApplyExchangeRate() {
		return isApplyExchangeRate;
	}

	/**
	 * @param isApplyExchangeRate the isApplyExchangeRate to set
	 */
	public void setIsApplyExchangeRate(Boolean isApplyExchangeRate) {
		this.isApplyExchangeRate = isApplyExchangeRate;
	}

	/**
	 * @return the createdBby
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBby the createdBby to set
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
		return "UserDetails [ id=" + id + ", email=" + email + ", contact=" + contact + ", userId=" + userId
				+ ", userType=" + userType + ", isApproved=" + isApproved + ", status=" + status + ", exchangeRate="
				+ exchangeRate + ", totalPoints=" + totalPoints + ", isApplyExchangeRate=" + isApplyExchangeRate
				+ ", createdBy=" + createdBy + ", createdTimestamp=" + createdTimestamp + ", updatedBy=" + updatedBy
				+ ", updatedTimestamp=" + updatedTimestamp + "]";
	}

}