/**
 * 
 */
package com.nector.alpha.uno.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * 
 */
public class UserDetailsRec {

	// name, email, user_id, contact, address, total_points

	String name;
	String email;
	BigDecimal userId;
	String contact;
	String address;
	Float totalPoints;
	String approvalStatus;

	/**
	 * 
	 */
	public UserDetailsRec() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param email
	 * @param userId
	 * @param contact
	 * @param address
	 * @param totalPoints
	 * @param approvalStatus
	 */
	public UserDetailsRec(String name, String email, BigDecimal userId, String contact, String address,
			Float totalPoints, String approvalStatus) {
		super();
		this.name = name;
		this.email = email;
		this.userId = userId;
		this.contact = contact;
		this.address = address;
		this.totalPoints = totalPoints;
		this.approvalStatus = approvalStatus;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the userId
	 */
	public BigDecimal getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(BigDecimal userId) {
		this.userId = userId;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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
	 * @return the approvalStatus
	 */
	public String getApprovalStatus() {
		return approvalStatus;
	}

	/**
	 * @param approvalStatus the approvalStatus to set
	 */
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	@Override
	public String toString() {
		return "UserDetailsRec [name=" + name + ", email=" + email + ", userId=" + userId + ", contact=" + contact
				+ ", address=" + address + ", totalPoints=" + totalPoints + ", approvalStatus=" + approvalStatus + "]";
	}

}
