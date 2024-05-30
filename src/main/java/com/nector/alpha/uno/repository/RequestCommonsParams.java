/**
 * 
 */
package com.nector.alpha.uno.repository;

import java.sql.Timestamp;

/**
 * 
 */
public class RequestCommonsParams {

	String createdBy = "SYSTEM";
	Timestamp createdTs;

	String updatedBy = "SYSTEM";
	Timestamp updatedTs;

	/**
	 * 
	 */
	public RequestCommonsParams() {
		super();
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
	 * @return the createdTs
	 */
	public Timestamp getCreatedTs() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * @param createdTs the createdTs to set
	 */
	public void setCreatedTs(Timestamp createdTs) {
		this.createdTs = createdTs;
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
	 * @return the updatedTs
	 */
	public Timestamp getUpdatedTs() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * @param updatedTs the updatedTs to set
	 */
	public void setUpdatedTs(Timestamp updatedTs) {
		this.updatedTs = updatedTs;
	}

}
