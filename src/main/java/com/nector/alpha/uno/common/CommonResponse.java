/**
 * 
 */
package com.nector.alpha.uno.common;

import com.google.gson.annotations.SerializedName;

/**
 * 
 */
public class CommonResponse {
	@SerializedName("status_code")
	private Integer statusCode;

	@SerializedName("error_code")
	private String errorCode;

	@SerializedName("message")
	private String message;

	/**
	 * 
	 */
	public CommonResponse() {
		super();
	}

	/**
	 * @param statusCode
	 * @param errorCode
	 * @param message
	 */
	public CommonResponse(Integer statusCode, String errorCode, String message) {
		super();
		this.statusCode = statusCode;
		this.errorCode = errorCode;
		this.message = message;
	}

	/**
	 * @return the statusCode
	 */
	public Integer getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CommonResponse [statusCode=" + statusCode + ", errorCode=" + errorCode + ", message=" + message + "]";
	}

}
