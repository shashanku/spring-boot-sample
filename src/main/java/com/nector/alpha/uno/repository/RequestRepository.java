/**
 * 
 */
package com.nector.alpha.uno.repository;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

import com.nector.alpha.uno.common.AppConstant;
import com.nector.alpha.uno.common.AppConstant.USER_EVENTS;
import com.nector.alpha.uno.common.CacheManager;
import com.nector.alpha.uno.entity.CommodityDetails;
import com.nector.alpha.uno.entity.Employee;
import com.nector.alpha.uno.entity.EventDetails;
import com.nector.alpha.uno.entity.TenantDetails;
import com.nector.alpha.uno.entity.TokenDetails;
import com.nector.alpha.uno.entity.Transaction;
import com.nector.alpha.uno.entity.UserDetails;

/**
 * @author shashank1.upadhyay
 *
 */
//https://github.com/KumarVariable/springboot-hikari-jdbc-mysql/blob/master/src/main/java/com/mysql/springboot/repository/impl/EmployeeRepositoryImpl.java
@Repository
public class RequestRepository extends RequestCommonsParams implements IRequestRepository {

	private static final Logger LOG = LoggerFactory.getLogger(RequestRepository.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

//	 private final JdbcTemplate jdbcTemplate;

	@Autowired
	TransactionTemplate transactionTemplate;

	/**
	 * 
	 */
	public RequestRepository() {
		super();
	}

	@Override
	public UserDetails saveUser(UserDetails userDetails) throws IOException {

		LOG.info("Request recieved for inserting user details for details:{}", userDetails.toString());

		BigInteger retval = new BigInteger("-1");
		KeyHolder keyHolder = new GeneratedKeyHolder();

		try {

			// ``,``,``,``,``,``,``,``,``,``,``,``,``) VALUES (?,?,?,?,?,?,?,?,?,?,?

			jdbcTemplate.update(connection -> {
				PreparedStatement ps = connection.prepareStatement(AppConstant.INSERT_USER_REQUEST,
						PreparedStatement.RETURN_GENERATED_KEYS);

				ps.setString(1, userDetails.getEmail());// email
				ps.setString(2, userDetails.getContact());// contact
				ps.setString(3, userDetails.getUserId()); // user_id
				ps.setString(4, userDetails.getUserType());// user_type
				ps.setBoolean(5, userDetails.getIsApproved());// is_approved
				ps.setString(6, userDetails.getStatus());// status
				ps.setFloat(7, userDetails.getExchangeRate());// exchange_rate
				ps.setFloat(8, userDetails.getTotalPoints()); // total_points
				ps.setBoolean(9, userDetails.getIsApplyExchangeRate());// is_apply_exchange_rate
				ps.setString(10, userDetails.getCreatedBy());// created_by
				ps.setTimestamp(11, userDetails.getCreatedTimestamp());// created_timestamp
				ps.setString(12, userDetails.getUpdatedBy());// updated_by
				ps.setTimestamp(13, userDetails.getUpdatedTimestamp());// updated_timestamp

				return ps;
			}, keyHolder);

			retval = (java.math.BigInteger) keyHolder.getKey();

		} catch (Exception e) {
			LOG.error("Into exception while inserting user details req with message:{}", e.getMessage());
		}

		userDetails.setId(retval.longValue());
		LOG.info("Request processed for inserting customer mobile number for TV with generated Id:{} with  details:{}",
				retval.longValue(), userDetails.toString());
		return userDetails;

	}

	@Override
	public int approveUser(String jsonBody) throws IOException {

		Optional<Employee> resp = jdbcTemplate
				.query("select * from emp.employee where employee_id = ?", new EmployeeRecMapper(), 1).stream()
				.findFirst();

		if (!resp.isPresent())
			System.out.println("Mobile number not associated with customer. Contact admin");

		Employee mobile = resp.get();

		System.out.println(mobile.toString());

		return 1;
	}

	@Override
	public CommodityDetails createCommodity(CommodityDetails commodityDetails) throws IOException {

		LOG.info("Request recieved for inserting commodityDetails details for details:{}", commodityDetails.toString());

		BigInteger retval = new BigInteger("-1");
		KeyHolder keyHolder = new GeneratedKeyHolder();

		try {

			// ``,``,``,``,``,``,``,``,``,``,``,``,``) VALUES (?,?,?,?,?,?,?,?,?,?,?

			jdbcTemplate.update(connection -> {
				PreparedStatement ps = connection.prepareStatement(AppConstant.INSERT_USER_REQUEST,
						PreparedStatement.RETURN_GENERATED_KEYS);

				ps.setString(1, commodityDetails.getCommodityCode());// code
				ps.setString(2, commodityDetails.getCommodityType());// type
				ps.setString(3, commodityDetails.getDescription()); // description
				ps.setFloat(4, commodityDetails.getPointsGenerated());// points

				ps.setString(5, commodityDetails.getCreatedBy());// created_by
				ps.setTimestamp(6, commodityDetails.getCreatedTimestamp());// created_timestamp
				ps.setString(7, commodityDetails.getUpdatedBy());// updated_by
				ps.setTimestamp(8, commodityDetails.getUpdatedTimestamp());// updated_timestamp

				return ps;
			}, keyHolder);

			retval = (java.math.BigInteger) keyHolder.getKey();

		} catch (Exception e) {
			LOG.error("Into exception while inserting commodityDetails details req with message:{}", e.getMessage());
		}

		commodityDetails.setId(retval.longValue());
		LOG.info("Request processed for inserting commodityDetails details with generated Id:{} with  details:{}",
				retval.longValue(), commodityDetails.toString());
		return commodityDetails;

	}

	@Override
	public int updateCommodity(String jsonBody) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TokenDetails issueToken(TokenDetails tokenDetails) throws IOException {

		LOG.info("Request recieved for inserting tokenDetails details for details:{}", tokenDetails.toString());

		BigInteger retval = new BigInteger("-1");
		KeyHolder keyHolder = new GeneratedKeyHolder();

		try {

			// ``,``,``,``,``,``,``,``,``,``,``,``,``) VALUES (?,?,?,?,?,?,?,?,?,?,?

			jdbcTemplate.update(connection -> {
				PreparedStatement ps = connection.prepareStatement(AppConstant.INSERT_USER_REQUEST,
						PreparedStatement.RETURN_GENERATED_KEYS);

				int i = 1;

				ps.setBigDecimal(i++, new BigDecimal(tokenDetails.getTokenNo()));// token no
				ps.setString(i++, tokenDetails.getCommodityCode());// commodity code
				ps.setString(i++, tokenDetails.getStatus()); // status
				ps.setBoolean(i++, tokenDetails.getIsRedeemed());// is_redeemed
				ps.setString(i++, tokenDetails.getBillNo());// bill no

				Long isValidTill = System.currentTimeMillis() + (365 * 24 * 60 * 60 * 1000L);
				ps.setLong(i++, isValidTill);// is_valid_till

				ps.setString(i++, tokenDetails.getCreatedBy());// created_by
				ps.setTimestamp(i++, tokenDetails.getCreatedTimestamp());// created_timestamp
				ps.setString(i++, tokenDetails.getUpdatedBy());// updated_by
				ps.setTimestamp(i++, tokenDetails.getUpdatedTimestamp());// updated_timestamp

				return ps;
			}, keyHolder);

			retval = (java.math.BigInteger) keyHolder.getKey();

		} catch (Exception e) {
			LOG.error("Into exception while inserting tokenDetails details req with message:{}", e.getMessage());
		}

		tokenDetails.setId(retval.longValue());
		LOG.info("Request processed for inserting tokenDetails details with generated Id:{} with  details:{}",
				retval.longValue(), tokenDetails.toString());
		return tokenDetails;

	}

	@Override
	public int deleteToken(String jsonBody) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateExchangeRate(String jsonBody) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCommodityPoints(String jsonBody) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Transaction transact(Transaction txn) throws IOException {

		LOG.info("Request recieved for inserting Transaction details for details:{}", txn.toString());

		transactionTemplate.execute(status -> {
			try {
				jdbcTemplate.update(
						"INSERT INTO transactions (from_user_id,to_user_id,token_no,points_accrued,total_points,event_type,event_name,commodity_code,remarks,created_by,created_timestamp,updated_by,updated_timestamp) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)",
						txn.getFromUserId(), txn.getToUserId(), txn.getTokenNo(), txn.getPointsAccrued(),
						txn.getTotalPoints(), txn.getEventType(), txn.getEventName(), txn.getCommodityCode(),
						txn.getRemarks(), getCreatedBy(), getCreatedTs(), getUpdatedBy(), getUpdatedTs());

				int txnId = getLastInsertedId();
				String eventName = USER_EVENTS.TRANSACT.name();
				String eventType = CacheManager.getEvent(eventName).getEventType();

				txn.setId(txnId * 1L);

				jdbcTemplate.update(
						"INSERT INTO natraj.audit_log (event_name,event_type,transaction_id,remarks,user_id,created_by,created_timestamp,updated_by,updated_timestamp) VALUES (?,?,?,?,?,?,?,?,?)",
						eventName, eventType, txnId, txn.getRemarks(), txn.getFromUserId(), getCreatedBy(),
						getCreatedTs(), getUpdatedBy(), getUpdatedTs());

				return txn;
			} catch (Exception e) {
				status.setRollbackOnly();
				return txn;
			}
		});

//		BigInteger retval = new BigInteger("-1");
//		KeyHolder keyHolder = new GeneratedKeyHolder();
//
//		try {
//
//			// ``,``,``,``,``,``,``,``,``,``,``,``,``) VALUES (?,?,?,?,?,?,?,?,?,?,?
//
//			jdbcTemplate.update(connection -> {
//				PreparedStatement ps = connection.prepareStatement(AppConstant.INSERT_USER_REQUEST,
//						PreparedStatement.RETURN_GENERATED_KEYS);
//
//				int i = 1;
//
//				ps.setString(i++, txn.getFromUserId());// from_user_id
//				ps.setString(i++, txn.getToUserId());// to_user_id
//				ps.setBigDecimal(i++, new BigDecimal(txn.getTokenNo())); // token_no
//				ps.setFloat(i++, txn.getPointsAccrued());// points_accrued
//				ps.setFloat(i++, txn.getTotalPoints());// total_points
//
//				ps.setString(i++, txn.getEventType());// event_type
//				ps.setString(i++, txn.getEventName());// event_name
//				ps.setString(i++, txn.getCommodityCode());// commodity_code
//				ps.setString(i++, txn.getRemarks());// remarks
//
//				ps.setString(i++, txn.getCreatedBy());// created_by
//				ps.setTimestamp(i++, txn.getCreatedTimestamp());// created_timestamp
//				ps.setString(i++, txn.getUpdatedBy());// updated_by
//				ps.setTimestamp(i++, txn.getUpdatedTimestamp());// updated_timestamp
//
//				return ps;
//			}, keyHolder);
//
//			retval = (java.math.BigInteger) keyHolder.getKey();
//
//		} catch (Exception e) {
//			LOG.error("Into exception while inserting Transaction details req with message:{}", e.getMessage());
//		}
//
//		txn.setId(retval.longValue());
//		LOG.info("Request processed for inserting Transaction details with generated Id:{} with  details:{}",
//				retval.longValue(), txn.toString());
		return txn;

	}

	@Override
	public int redeem(String jsonBody) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int generateReport(String jsonBody) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int queryToken(String jsonBody) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int queryCommodity(String jsonBody) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int queryUser(String jsonBody) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int queryTxn(String jsonBody) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int queryUserTxn(String jsonBody) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @return
	 */
	public Optional<List<TenantApiKeyRecord>> getApiKeyTenantIdMapping() {
		return jdbcTemplate.query(AppConstant.SELECT_TENANT_APIKEY_MAPPING, new TenantAPIKeyMapper()).stream()
				.findFirst();
	}

	/**
	 * @return
	 */
	public Optional<List<EventDetails>> getEventData() {
		return jdbcTemplate.query(AppConstant.SELECT_EVENTS_DETAILS, new EventDetailsMapper()).stream().findFirst();
	}

	/**
	 * @param tenantDetails
	 * @return
	 */
	public TenantDetails saveTenant(TenantDetails tenantDetails) {

		LOG.info("Request recieved for inserting tenantDetails details for details:{}", tenantDetails.toString());

		BigInteger retval = new BigInteger("-1");
		KeyHolder keyHolder = new GeneratedKeyHolder();

		try {

			// ``,``,``,``,``,``,``,``,``,``,``,``,``) VALUES (?,?,?,?,?,?,?,?,?,?,?

			jdbcTemplate.update(connection -> {
				PreparedStatement ps = connection.prepareStatement(AppConstant.INSERT_USER_REQUEST,
						PreparedStatement.RETURN_GENERATED_KEYS);

				int i = 1;
				ps.setString(i++, tenantDetails.getName());
				ps.setString(i++, tenantDetails.getAddress());
				ps.setString(i++, tenantDetails.getApiKey());

				ps.setString(i++, tenantDetails.getCreatedBy());
				ps.setTimestamp(i++, tenantDetails.getCreatedTimestamp());
				ps.setString(i++, tenantDetails.getUpdatedBy());
				ps.setTimestamp(i++, tenantDetails.getUpdatedTimestamp());

				return ps;
			}, keyHolder);

			retval = (java.math.BigInteger) keyHolder.getKey();

		} catch (Exception e) {
			LOG.error("Into exception while inserting tenantDetails details req with message:{}", e.getMessage());
		}

		tenantDetails.setId(retval.longValue());
		LOG.info("Request processed for inserting tenantDetails details with generated Id:{} with  details:{}",
				retval.longValue(), tenantDetails.toString());
		return tenantDetails;

	}

	private int getLastInsertedId() {
		return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
	}

	/**
	 * @param eventDetails
	 * @return
	 */
	public EventDetails saveEvent(EventDetails eventDetails) {

		LOG.info("Request recieved for inserting eventDetails details for details:{}", eventDetails.toString());

		BigInteger retval = new BigInteger("-1");
		KeyHolder keyHolder = new GeneratedKeyHolder();

		try {

			jdbcTemplate.update(connection -> {
				PreparedStatement ps = connection.prepareStatement(AppConstant.INSERT_EVENT_REQUEST,
						PreparedStatement.RETURN_GENERATED_KEYS);

				int i = 1;
				ps.setString(i++, eventDetails.getEventName());
				ps.setString(i++, eventDetails.getEventType());
				ps.setBoolean(i++, eventDetails.getIsLoggable());
				ps.setString(i++, eventDetails.getStatus());

				ps.setString(i++, eventDetails.getCreatedBy());
				ps.setTimestamp(i++, eventDetails.getCreatedTimestamp());
				ps.setString(i++, eventDetails.getUpdatedBy());
				ps.setTimestamp(i++, eventDetails.getUpdatedTimestamp());

				return ps;
			}, keyHolder);

			retval = (java.math.BigInteger) keyHolder.getKey();

		} catch (Exception e) {
			LOG.error("Into exception while inserting eventDetails req with message:{}", e.getMessage());
		}

		eventDetails.setId(retval.longValue());
		LOG.info("Request processed for inserting eventDetails with generated Id:{} with  details:{}",
				retval.longValue(), eventDetails.toString());
		return eventDetails;

	}

}
