/**
 * 
 */
package com.nector.alpha.uno.repository;

import java.sql.Timestamp;

//t.id, t.created_timestamp, t.token_no, t.points_accrued, t.commodity_code
public class TxnDTO {

	private Long id;
	private Float points;
	private Long tokenNo;
	String commodityCode;
	private Timestamp txnDate;

	/**
	 * 
	 */
	public TxnDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param points
	 * @param tokenNo
	 * @param commodityCode
	 * @param txnDate
	 */
	public TxnDTO(Long id, Float points, Long tokenNo, String commodityCode, Timestamp txnDate) {
		super();
		this.id = id;
		this.points = points;
		this.tokenNo = tokenNo;
		this.commodityCode = commodityCode;
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
	 * @return the tokenNo
	 */
	public Long getTokenNo() {
		return tokenNo;
	}

	/**
	 * @param tokenNo the tokenNo to set
	 */
	public void setTokenNo(Long tokenNo) {
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

	@Override
	public String toString() {
		return "TxnDTO [id=" + id + ", points=" + points + ", tokenNo=" + tokenNo + ", commodityCode=" + commodityCode
				+ ", txnDate=" + txnDate + "]";
	}

}