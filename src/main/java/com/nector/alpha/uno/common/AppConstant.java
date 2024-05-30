/**
 * 
 */
package com.nector.alpha.uno.common;

/**
 * @author shash
 *         https://www.javacodegeeks.com/2016/03/springboot-working-jdbctemplate.html
 *
 */
public class AppConstant {

	public static final String FOLDER_PATH = "FOLDER_PATH";
	public static final String DEF_RES = "-1";
	public static final String NA = "NA";
	public static final String CSV = ",";
	public static final String DOUBLE_QUOTES = "\"";
	public static final String EMPTY = "";

	public static final String DEFAULT_OTP = "0000";


	

	public static enum USER_EVENTS {
		CREATE_USER, APPROVE_USER, CREATE_COMMODITY, UPDATE_COMMODITY, ISSUE_TOKEN, DELETE_TOKEN, UPDATE_EXCHANGE_RATE,
		UPDATE_COMMODITY_POINTS, TRANSACT, REDEEM, GENERATE_REPORT, QUERY_TOKEN, QUERY_COMMODITY, QUERY_USER,
		QUERY_TRANSACTION, QUERY_USER_TRANSACTION,
	}

	/*
	 * DB Queries
	 * 
	 */

	public static final String SELECT_TENANT_APIKEY_MAPPING = " select id,name, address, api_key from natraj.tenant_details";
	public static final String SELECT_EVENTS_DETAILS = " select * from natraj.event_details";

	public static final String SELECT_PENDING_REF_QUERY = " select customer_id, mobile, 'MOB_APP_REG' as operation  from tv_schema.customer_contacts where is_otp_authorized = 0 and reference_no=?";
	public static final String SELECT_CUSTOMER_INFO_QUERY = "select * from tv_schema.customer_contacts where customer_id = ? and mobile = ? ";

	public static final String SELECT_TV_MAPPING = " select * from tv_schema.sttm_tv_operation_mapping ";
	public static final String SELECT_SVT_MAPPING = " select * from tv_schema.sttm_svt_proc_code_mapping ";

	public static final String ERROR_EXPIRED_OTP = "OTP expired, please try again with new transaction";
	public static final String ERROR_UNSUPPORTED_OP = "Operation not supported.";
	public static final String ERROR_INACTIVE_OP = "Operation not active. Contact admin.";
	public static final String ERROR_MISSING_OTP = "Mobile number not associated with customer. Contact admin";
	public static final String ERROR_INVALID_CUSTOMER = "Customer details not present for given id. Proceed with registration first.";
	public static final String ERROR_CUSTOMER_DATA = "Force password change. Proceed with generation of new password.";
	public static final String ERROR_CUSTOMER_PASS = "Invalid customer password";

	public static final String SEP_HASH = "#";

	// entries for SACCO handling
	public static final String X_SACCO_ID = "x-sacco-id";
	public static final String X_ACTION_CODE = "x-action-code";
	public static final String INSERT_USER_REQUEST = "INSERT INTO `natraj`.`user_details` (`email`,`contact`,`user_id`,`user_type`,`is_approved`,`status`,`exchange_rate`,`total_points`,`is_apply_exchange_rate`,`created_by`,`created_timestamp`,`updated_by`,`updated_timestamp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String INSERT_EVENT_REQUEST = "INSERT INTO `natraj`.`event_details` (`event_name`,`event_type`,`is_loggable`,`status`,`created_by`,`created_timestamp`,`updated_by`,`updated_timestamp`) VALUES (?,?,?,?,?,?,?,?)";
}
