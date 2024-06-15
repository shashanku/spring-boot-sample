/**
 * 
 */
package com.nector.alpha.uno.entity;

import java.sql.Timestamp;
import com.google.gson.annotations.SerializedName;

public class CommodityDetails {

	@SerializedName("id")
	private Long id;

	@SerializedName("commodity_code")
	private String commodityCode;

	@SerializedName("commodity_type")
	private String commodityType;

	@SerializedName("description")
	private String description;

	@SerializedName("points_generated")
	private Float pointsGenerated;

	@SerializedName("status")
	private Integer status;

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
	public CommodityDetails() {
	}

	/**
	 * @param id
	 * @param commodityCode
	 * @param commodityType
	 * @param description
	 * @param pointsGenerated
	 * @param status
	 * @param createdBy
	 * @param createdTimestamp
	 * @param updatedBy
	 * @param updatedTimestamp
	 */
	public CommodityDetails(Long id, String commodityCode, String commodityType, String description,
			Float pointsGenerated, Integer status, String createdBy, Timestamp createdTimestamp, String updatedBy,
			Timestamp updatedTimestamp) {
		super();
		this.id = id;
		this.commodityCode = commodityCode;
		this.commodityType = commodityType;
		this.description = description;
		this.pointsGenerated = pointsGenerated;
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
	 * @return the commodityType
	 */
	public String getCommodityType() {
		return commodityType;
	}

	/**
	 * @param commodityType the commodityType to set
	 */
	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the pointsGenerated
	 */
	public Float getPointsGenerated() {
		return pointsGenerated;
	}

	/**
	 * @param pointsGenerated the pointsGenerated to set
	 */
	public void setPointsGenerated(Float pointsGenerated) {
		this.pointsGenerated = pointsGenerated;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param user
	 * @param ts
	 */
	public void setAudits(String user, Timestamp ts) {
		this.createdBy = "SYSTEM";
		this.updatedBy = "SYSTEM";

		this.createdTimestamp = ts;
		this.updatedTimestamp = ts;

	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
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
		return "CommodityDetails [id=" + id + ", commodityCode=" + commodityCode + ", commodityType=" + commodityType
				+ ", description=" + description + ", pointsGenerated=" + pointsGenerated + ", status=" + status
				+ ", createdBy=" + createdBy + ", createdTimestamp=" + createdTimestamp + ", updatedBy=" + updatedBy
				+ ", updatedTimestamp=" + updatedTimestamp + "]";
	}

}