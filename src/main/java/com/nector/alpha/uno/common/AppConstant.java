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

	// Login user and password for /user/login api
	public static final String LOGIN_USER = "sysadmin";// "prasanna";
	public static final String LOGIN_PWD = "P@#12u!8$";// "P@#12u!8$";

	public static final String SVT_REQUEST_URL = "https://uat.sarvatra.in:8443/bankeasygw/srvt/api/secure/20/request";
	public static final String SVT_IMPS_REQUEST_URL = "https://uat.sarvatra.in:8443/bankeasygw/srvt/api/secure/20/request";

	public static enum IMPS_PROC_CODE {
		// Constants with values
		BAL_INQ(111011), CANC_MMID(111002), CHK_TXN_STAT(111003), GEN_MMID(111001), LAST_5_TXN(111005),
		MINI_STMT(111012), NAME_P2A(111013), NAME_P2P(111013), P2A(111009), P2P(111004);

		// Instance variable
		private int procCode;

		// Constructor to initialize the instance variable
		IMPS_PROC_CODE(int procCode) {
			this.procCode = procCode;
		}

		public int getProcCode() {
			return this.procCode;
		}
	}

	// Generaic processCodes to be used while sending request to Sarvatra Payment
	// Gateway
	public static enum SVT_TXN_CODE {
		MOB_APP_REG, ACCT_LST, BAL_ENQ, TXN_LST_N, CHQ_BOOK_REQ, ACCT_STMT, ACCT_STMT_EMAIL, BENF_LST, REM_BENF,
		ADD_BENF, WB_FT, IB_FT, IN_CHQ_STATUS, OUT_CHQ_STATUS, UNCLR_IN_CHQ, UNCLR_OUT_CHQ, STOP_PMNT_REQ,
		REVOKE_STOP_PMNT, WB_SI, IB_SI, WB_SI_LST, IB_SI_LST, WB_SI_CANC, IB_SI_CANC, POS_PAY_INTR, CTS_CHQ_DEP,
		CUST_INFO, ACCT_OPEN_NEW_CUST, ACCT_OPEN_EXT_CUST, PROD_INFO, MINI
	}

	public static enum USER_EVENTS {
		CREATE_USER, APPROVE_USER, CREATE_COMMODITY, UPDATE_COMMODITY, ISSUE_TOKEN, DELETE_TOKEN, UPDATE_EXCHANGE_RATE,
		UPDATE_COMMODITY_POINTS, TRANSACT, REDEEM, GENERATE_REPORT, QUERY_TOKEN, QUERY_COMMODITY, QUERY_USER,
		QUERY_TRANSACTION, QUERY_USER_TRANSACTION,
	}

	/*
	 * DB Queries
	 * 
	 */
	public static final String INSERT_TV_REQUEST = " INSERT INTO `tv_schema`.`log_http_tv` (`tv_mobile_req`,`create_timestamp`, `req_id`) VALUES (?, ?, ?) ";
	public static final String UPDATE_TV_REQUEST = " UPDATE `tv_schema`.`log_http_tv` SET `tv_mobile_res` = ?, `update_timestamp` = ?, `http_status_code` = ? WHERE `id` = ?";
	public static final String UPDATE_TV_REQUEST_REF_NO = " UPDATE `tv_schema`.`log_http_tv` SET `tv_mobile_res` = ?, `update_timestamp` = ?, `http_status_code` = ? WHERE `req_id` = ?";

	public static final String TEST_STRING = "INSERT INTO `tv_schema`.`log_http_tv` (`http_status_code`, `req_id`) VALUES ( ?, ?)";
	public static final String INSERT_SVT_REQUEST = " INSERT INTO `log_http_svt` (`aes_key`,`aes_iv`,`svt_mobile_req`,`create_timestamp`,`req_id`,`parent_id`) VALUES (?,?,?,?,?,?)";
	public static final String INSERT_TV_SVT_MAPPING_REQUEST = " INSERT INTO `mptb_tv_svt_mapping` (`ref_no`,`tv_ref_no`,`svt_ref_no`,`op_code`,`create_timestamp`) VALUES (?,?,?,?,?)";

	public static final String INSERT_TV_CUST_REC = " INSERT INTO `tv_schema`.`customer_contacts` (`customer_id`,`mobile`,`reference_no`,`is_validated`,`create_timestamp`) VALUES (?,?,?,?,?)";

	public static final String INSERT_TV_CUST_REC2 = " INSERT INTO `tv_schema`.`customer_contacts` (`customer_id`,`mobile`,`reference_no`,`is_validated`,`create_timestamp`,`is_otp_authorized`,`is_first_login`,`is_forced_pwd_change`,`pwd`,`name`,`type`,`address`,`pin`,`email`,`reg_id`,`act_code`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String UPDATE_TV_CUST_REC = " UPDATE `tv_schema`.`customer_contacts` SET `is_validated` = ? WHERE `customer_id` = ? AND `reference_no` = ?";
	public static final String UPDATE_TV_CUST_OTP_REC = " UPDATE `tv_schema`.`customer_contacts` SET `is_otp_authorized` = ? WHERE `customer_id` = ? AND `reference_no` = ?";
	public static final String UPDATE_TV_CUST_PASS = " UPDATE `tv_schema`.`customer_contacts` SET `is_forced_pwd_change` = ? and `pwd` = ? WHERE `customer_id` = ? AND `reference_no` = ?";
	public static final String UPDATE_TV_CUST_LOGIN = " UPDATE `tv_schema`.`customer_contacts` SET `is_forced_pwd_change` = ? WHERE `customer_id` = ? AND `reference_no` = ?";
	public static final String UPDATE_TV_CUST_FORCE_LOGIN = " UPDATE `tv_schema`.`customer_contacts` SET `is_first_login` = ? , `is_forced_pwd_change` = ? , `pwd`=? WHERE `customer_id` = ? AND `mobile` = ?";

	public static final String UPDATE_SVT_REQUEST = " UPDATE `tv_schema`.`log_http_svt` SET `svt_mobile_res` = ?, `update_timestamp` = ?, `http_status_code` = ? WHERE `id` = ?";
	public static final String UPDATE_SVT_REQUEST_REF_NO = " UPDATE `tv_schema`.`log_http_svt` SET `svt_mobile_res` = ?, `update_timestamp` = ?, `http_status_code` = ? WHERE `req_id` = ?";

	public static final String INSERT_CUSTOFMER_MOBILE_REQ = " INSERT INTO `customer_contacts` (`customer_id`,`mobile`) VALUES (?,?)";

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

	// public static final String BASE_FOLDER_MOCKS = "./src/main/resources/mocks/";
	// public static final String RSA_FILE_BASE_LOC = "./";
	public static final String PEM_FOLDER_NAME = "pem";
	public static final String MOCKS_FOLDER_NAME = "mocks";
	public static final String RSA_FILE_NAME = "20-MOBAPP.channel.4.pem";

	public static final Boolean IS_MOCK = true;
	public static final String SEP_HASH = "#";

	// entries for SACCO handling
	public static final String X_SACCO_ID = "x-sacco-id";
	public static final String X_ACTION_CODE = "x-action-code";
	public static final String INSERT_USER_REQUEST = "INSERT INTO `natraj`.`user_details` (`email`,`contact`,`user_id`,`user_type`,`is_approved`,`status`,`exchange_rate`,`total_points`,`is_apply_exchange_rate`,`created_by`,`created_timestamp`,`updated_by`,`updated_timestamp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String INSERT_EVENT_REQUEST = "INSERT INTO `natraj`.`event_details` (`event_name`,`event_type`,`is_loggable`,`status`,`created_by`,`created_timestamp`,`updated_by`,`updated_timestamp`) VALUES (?,?,?,?,?,?,?,?)";
}
