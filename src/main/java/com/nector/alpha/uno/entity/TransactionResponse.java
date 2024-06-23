/**
 * 
 */
package com.nector.alpha.uno.entity;

import java.sql.Timestamp;

import com.google.gson.annotations.SerializedName;

public class TransactionResponse {

	@SerializedName("id")
	private Long id;

	@SerializedName("points")
	private Float points;

	@SerializedName("transaction_timestamp")
	private Timestamp txnDate;

	/**
	 * 
	 */
	public TransactionResponse() {
	}

	/**
	 * @param id
	 * @param points
	 * @param txnDate
	 */
	public TransactionResponse(Long id, Float points, Timestamp txnDate) {
		super();
		this.id = id;
		this.points = points;
		this.txnDate = txnDate;
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
	 * @return the points
	 */
	public Float getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(Float points) {
		this.points = points;
	}

	/**
	 * @return the txnDate
	 */
	public Timestamp getTxnDate() {
		return txnDate;
	}

	/**
	 * @param txnDate the txnDate to set
	 */
	public void setTxnDate(Timestamp txnDate) {
		this.txnDate = txnDate;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "TransactionResponse [id=" + id + ", points=" + points + ", txnDate=" + txnDate + "]";
	}

}