/**
 * 
 */
package com.nector.alpha.uno.entity;

import java.sql.Timestamp;
import com.google.gson.annotations.SerializedName;

public class ApprovalDetailsReq {

	@SerializedName("id")
	private Long id;

	@SerializedName("from_timestamp")
	private Timestamp fromTimestamp;

	/**
	 * 
	 */
	public ApprovalDetailsReq() {
	}

	/**
	 * @param id
	 * @param fromTimestamp
	 */
	public ApprovalDetailsReq(Long id, Timestamp fromTimestamp) {
		super();
		this.id = id;
		this.fromTimestamp = fromTimestamp;
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
	 * @return the fromTimestamp
	 */
	public Timestamp getFromTimestamp() {
		return fromTimestamp;
	}

	/**
	 * @param fromTimestamp the fromTimestamp to set
	 */
	public void setFromTimestamp(Timestamp fromTimestamp) {
		this.fromTimestamp = fromTimestamp;
	}

	@Override
	public String toString() {
		return "ApprovalDetailsReq [id=" + id + ", fromTimestamp=" + fromTimestamp + "]";
	}

}