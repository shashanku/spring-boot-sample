/**
 * 
 */
package com.nector.alpha.uno.repository;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.nector.alpha.uno.entity.PendingApprovalRec;
import com.nector.alpha.uno.entity.TenantDetails;
import com.nector.alpha.uno.entity.TokenCommodityRec;
import com.nector.alpha.uno.entity.TokenDetails;
import com.nector.alpha.uno.entity.UserDetails;
import com.nector.alpha.uno.entity.UserDetailsRec;
import com.nector.alpha.uno.req.SaveTxnVO;

import jakarta.transaction.Transactional;

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

	/**
	 * query: INSERT INTO `natraj`.`commodity_details`
	 * (`commodity_code`,`commodity_type`,`description`,`points_generated`,`status`,`created_by`,`created_timestamp`,`updated_by`,`updated_timestamp`)
	 * VALUES (?,?,?,?,?,?,?,?,?);
	 * 
	 * @param commodityDetails
	 * @return
	 * @throws IOException
	 */
	public CommodityDetails saveCommodity(CommodityDetails commodityDetails) throws IOException {

		LOG.info("Request recieved for inserting commodityDetails for details:{}", commodityDetails.toString());

		BigInteger retval = new BigInteger("-1");
		KeyHolder keyHolder = new GeneratedKeyHolder();

		try {

			// ``,``,``,``,``,``,``,``,``,``,``,``,``) VALUES (?,?,?,?,?,?,?,?,?,?,?

			jdbcTemplate.update(connection -> {
				PreparedStatement ps = connection.prepareStatement(AppConstant.INSERT_COMMODITY_REQUEST,
						PreparedStatement.RETURN_GENERATED_KEYS);

				int i = 1;
				ps.setString(i++, commodityDetails.getCommodityCode());// commodity_code
				ps.setString(i++, commodityDetails.getCommodityType());// commodity_type
				ps.setString(i++, commodityDetails.getDescription()); // description
				ps.setFloat(i++, commodityDetails.getPointsGenerated());// points_generated
				ps.setInt(i++, commodityDetails.getStatus());// status

				ps.setString(i++, commodityDetails.getCreatedBy());// created_by
				ps.setTimestamp(i++, commodityDetails.getCreatedTimestamp());// created_timestamp
				ps.setString(i++, commodityDetails.getUpdatedBy());// updated_by
				ps.setTimestamp(i++, commodityDetails.getUpdatedTimestamp());// updated_timestamp

				return ps;
			}, keyHolder);

			retval = (java.math.BigInteger) keyHolder.getKey();

		} catch (Exception e) {
			LOG.error("Into exception while inserting user details req with message:{}", e.getMessage());
		}

		commodityDetails.setId(retval.longValue());
		LOG.info("Request processed for inserting commodity details for generated Id:{} with  commodity:{}",
				retval.longValue(), commodityDetails.toString());
		return commodityDetails;

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

				int i = 1;
				ps.setString(i++, commodityDetails.getCommodityCode());// code
				ps.setString(i++, commodityDetails.getCommodityType());// type
				ps.setString(i++, commodityDetails.getDescription()); // description
				ps.setFloat(i++, commodityDetails.getPointsGenerated());// points

				ps.setString(i++, commodityDetails.getCreatedBy());// created_by
				ps.setTimestamp(i++, commodityDetails.getCreatedTimestamp());// created_timestamp
				ps.setString(i++, commodityDetails.getUpdatedBy());// updated_by
				ps.setTimestamp(i++, commodityDetails.getUpdatedTimestamp());// updated_timestamp

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

	/**
	 * @apiNote: execute query: INSERT INTO `natraj`.`token_details`
	 *           (`token_no`,`commodity_code`,`status`,`is_redeemed`,`bill_no`,`is_valid_till`,`created_by`,`created_timestamp`,`updated_by`,`updated_timestamp`)
	 *           VALUES (?,?,?,?,?,?,?,?,?,?);
	 * 
	 */
	@Override
	public TokenDetails issueToken(TokenDetails tokenDetails) throws IOException {

		LOG.info("Request recieved for inserting tokenDetails details for details:{}", tokenDetails.toString());

		BigInteger retval = new BigInteger("-1");
		KeyHolder keyHolder = new GeneratedKeyHolder();

		try {

			// ``,``,``,``,``,``,``,``,``,``,``,``,``) VALUES (?,?,?,?,?,?,?,?,?,?,?

			jdbcTemplate.update(connection -> {
				PreparedStatement ps = connection.prepareStatement(AppConstant.INSERT_TOKEN_REQUEST,
						PreparedStatement.RETURN_GENERATED_KEYS);

				int i = 1;

				ps.setBigDecimal(i++, new BigDecimal(tokenDetails.getTokenNo()));// token no

				ps.setString(i++, tokenDetails.getStatus()); // status
				ps.setBoolean(i++, tokenDetails.getIsRedeemed());// is_redeemed
				ps.setString(i++, tokenDetails.getBillNo());// bill no

				Long isValidTill = System.currentTimeMillis() + (365 * 24 * 60 * 60 * 1000L);
				ps.setLong(i++, isValidTill);// is_valid_till

				ps.setString(i++, tokenDetails.getCreatedBy());// created_by
				ps.setTimestamp(i++, tokenDetails.getCreatedTimestamp());// created_timestamp
				ps.setString(i++, tokenDetails.getUpdatedBy());// updated_by
				ps.setTimestamp(i++, tokenDetails.getUpdatedTimestamp());// updated_timestamp

				ps.setString(i++, tokenDetails.getCommodityCode());// commodity code

				return ps;
			}, keyHolder);

			retval = (java.math.BigInteger) keyHolder.getKey();

		} catch (Exception e) {
			LOG.error("Into exception while inserting tokenDetails details req with message:{}", e.getMessage());
		}

		if (retval == null)
			tokenDetails.setId(-1 * 1L);
		else
			tokenDetails.setId(retval.longValue());
		LOG.info("Request processed for inserting tokenDetails details with generated Id:{} with  details:{}",
				tokenDetails.getId(), tokenDetails.toString());
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

	/**
	 * @param txn
	 * @param token
	 * @return
	 * @throws IOException
	 */
	public Map<String, Long> transact(SaveTxnVO txn, TokenCommodityRec token) throws IOException {

		LOG.info("Request recieved for inserting Transaction details for details:{}", txn.toString());

		Map<String, Long> retval = new HashMap<>();
		transactionTemplate.execute(status -> {
			try {
				Long txnId = AppConstant.DEF_TOKEN;
				KeyHolder keyHolder = new GeneratedKeyHolder();

				jdbcTemplate.update(connection -> {
					PreparedStatement ps = connection.prepareStatement(AppConstant.INSERT_TRANSACTION,
							PreparedStatement.RETURN_GENERATED_KEYS);

					int i = 1;
					ps.setString(i++, txn.getFromUserId());
					ps.setString(i++, "SYSTEM");
					ps.setLong(i++, txn.getTokenNo().longValue());
					ps.setFloat(i++, token.getPointsGen());
					ps.setInt(i++, -1);
					ps.setString(i++, txn.getEventType());
					ps.setString(i++, txn.getEventName());
					ps.setString(i++, token.getCommodityCode());
					ps.setString(i++, txn.getRemarks());

					ps.setString(i++, getCreatedBy());
					ps.setTimestamp(i++, getCreatedTs());
					ps.setString(i++, getUpdatedBy());
					ps.setTimestamp(i++, getUpdatedTs());

					return ps;
				}, keyHolder);

				txnId = (Long) keyHolder.getKey();
				retval.put(AppConstant.TXN_ID, txnId);

//				jdbcTemplate.update(
//						"INSERT INTO transactions (from_user_id,to_user_id,token_no,points_accrued,total_points,event_type,event_name,commodity_code,remarks,created_by,created_timestamp,updated_by,updated_timestamp) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)",
//						txn.getFromUserId(), "SYSTEM", txn.getTokenNo(), token.getPointsGen(), -1, txn.getEventType(),
//						txn.getEventName(), token.getCommodityCode(), txn.getRemarks(), getCreatedBy(), getCreatedTs(),
//						getUpdatedBy(), getUpdatedTs());
//
//				int txnId = getLastInsertedId();
				String eventName = USER_EVENTS.TRANSACT.name();
				String eventType = CacheManager.getEvent(eventName).getEventType();

				// txn.setId(txnId * 1L);

//				jdbcTemplate.update(
//						"INSERT INTO natraj.audit_log (event_name,event_type,transaction_id,remarks,user_id,created_by,created_timestamp,updated_by,updated_timestamp) VALUES (?,?,?,?,?,?,?,?,?)",
//						eventName, eventType, txnId, txn.getRemarks(), txn.getFromUserId(), getCreatedBy(),
//						getCreatedTs(), getUpdatedBy(), getUpdatedTs());
				final Long txnAudit = txnId;
				Long auditId = AppConstant.DEF_TOKEN;
				jdbcTemplate.update(connection -> {
					PreparedStatement ps = connection.prepareStatement(AppConstant.INSET_AUDIT_LOG,
							PreparedStatement.RETURN_GENERATED_KEYS);

					int i = 1;
					ps.setString(i++, eventName);
					ps.setString(i++, eventType);
					ps.setLong(i++, txnAudit);
					ps.setString(i++, txn.getRemarks());
					ps.setString(i++, txn.getFromUserId());

					ps.setString(i++, getCreatedBy());
					ps.setTimestamp(i++, getCreatedTs());
					ps.setString(i++, getUpdatedBy());
					ps.setTimestamp(i++, getUpdatedTs());

					return ps;
				}, keyHolder);

				auditId = (Long) keyHolder.getKey();

				retval.put(AppConstant.AUDIT_ID, auditId);
				return 1;
			} catch (Exception e) {
				status.setRollbackOnly();
				retval.put(AppConstant.ERROR_ID, AppConstant.DEF_TOKEN);
			}
			return 1;
		});

		return retval;

	}

	@Override
	public int redeem(String jsonBody) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional
	public Map<String, Long> saveUserTransaction(SaveTxnVO txn, TokenCommodityRec tokens) {

		LOG.info("Save user transaction with txn: {}, token: {}", txn, tokens);
		Map<String, Long> retval = new HashMap<String, Long>();

		Long txnId = saveTransaction(txn, tokens);
		retval.put(AppConstant.TXN_ID, txnId);
		LOG.debug("Save user transaction with txn: {}, token: {}, txnId: {}", txn, tokens, txnId);

		Long auditLogId = saveAudit(txnId, txn);
		retval.put(AppConstant.AUDIT_ID, auditLogId);
		LOG.debug("Save user transaction with txn: {}, token: {}, txnId: {}, auditLogId: {}", txn, tokens, txnId,
				auditLogId);

		return retval;
	}

	/**
	 * @param eventName
	 * @param eventType
	 * @param txnAudit
	 * @param txn
	 * @return
	 */
	private Long saveAudit(Long txnAudit, SaveTxnVO txn) {

		Long txnId = AppConstant.DEF_TOKEN;
		KeyHolder keyHolder = new GeneratedKeyHolder();

		Long auditId = AppConstant.DEF_TOKEN;
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(AppConstant.INSET_AUDIT_LOG,
					PreparedStatement.RETURN_GENERATED_KEYS);

			int i = 1;
			ps.setString(i++, txn.getEventName());
			ps.setString(i++, txn.getEventType());
			ps.setLong(i++, txnAudit);
			ps.setString(i++, txn.getRemarks());
			ps.setString(i++, txn.getFromUserId());

			ps.setString(i++, getCreatedBy());
			ps.setTimestamp(i++, getCreatedTs());
			ps.setString(i++, getUpdatedBy());
			ps.setTimestamp(i++, getUpdatedTs());

			return ps;
		}, keyHolder);

		auditId = ((BigInteger) keyHolder.getKey()).longValue();

		return auditId;
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
	 * @param txn
	 * @param token
	 * @return
	 */
	private Long saveTransaction(SaveTxnVO txn, TokenCommodityRec token) {
		Long txnId = AppConstant.DEF_TOKEN;
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(AppConstant.INSERT_TRANSACTION,
					PreparedStatement.RETURN_GENERATED_KEYS);

			int i = 1;
			ps.setString(i++, txn.getFromUserId());
			ps.setString(i++, "SYSTEM");
			ps.setLong(i++, txn.getTokenNo().longValue());
			ps.setFloat(i++, token.getPointsGen());
			ps.setInt(i++, -1);
			ps.setString(i++, txn.getEventType());
			ps.setString(i++, txn.getEventName());
			ps.setString(i++, token.getCommodityCode());
			ps.setString(i++, txn.getRemarks());

			ps.setString(i++, getCreatedBy());
			ps.setTimestamp(i++, getCreatedTs());
			ps.setString(i++, getUpdatedBy());
			ps.setTimestamp(i++, getUpdatedTs());

			return ps;
		}, keyHolder);

		txnId = ((BigInteger) keyHolder.getKey()).longValue();

		return txnId;
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

	/**
	 * @implSpec: execute query: select td.token_no, td.commodity_code,
	 *            cd.commodity_type, cd.points_generated,cd.description from
	 *            natraj.token_details td, natraj.commodity_details cd where
	 *            cd.commodity_code = td.commodity_code and cd.status = 1 and
	 *            td.is_redeemed = 0 and td.status = 'A' and td.token_no = ?
	 * @param tokenNo
	 * @return
	 */
	public TokenCommodityRec getTokenDetails(BigInteger tokenNo) {

		TokenCommodityRec retval = new TokenCommodityRec();
		Optional<TokenCommodityRec> resp = jdbcTemplate
				.query(AppConstant.GET_TOKEN_DETAILS, new TokenRecMapper(), tokenNo).stream().findFirst();

		if (!resp.isPresent())
			retval.setTokenNo(AppConstant.DEF_TOKEN);
		else
			retval = resp.get();

		LOG.info("For tokenNo:{}, details are {}", tokenNo, retval.toString());
		return retval;
	}

	/**
	 * @implSpec: execute query: select name, email, user_id, contact, address,
	 *            total_points from natraj.user_details where is_approved = 0 and
	 *            reports_to = ? and tenant_id = ?
	 * 
	 * @param userId
	 * @param tenantId
	 * @return
	 */
	public List<PendingApprovalRec> getApprovalDetails(BigInteger userId, String tenantId) {

		List<PendingApprovalRec> retval = new ArrayList<PendingApprovalRec>();
		Optional<List<PendingApprovalRec>> resp = jdbcTemplate
				.query(AppConstant.GET_PENDING_APPROVALS, new PendingApprovalMapper(), userId, tenantId).stream()
				.findFirst();

		if (resp.isPresent())
			retval = resp.get();

		LOG.info("For userId:{}, tenantId: {}, pending approvals are {}", userId, tenantId, retval.toString());
		return retval;
	}

	/**
	 * @implSpec: execute query: select name, email, user_id, contact, user_address,
	 *            total_points, is_approved from natraj.user_details where user_id=?
	 *            and tenant_id=?
	 * 
	 * @param userId
	 * @param tenantId
	 * @return
	 */
	public UserDetailsRec getUserDetails(BigInteger userId, String tenantId) {
		LOG.info("Query user with userId: {}, tenant:{}", userId, tenantId);

		UserDetailsRec retval = new UserDetailsRec();
		Optional<UserDetailsRec> resp = jdbcTemplate
				.query(AppConstant.GET_USER_DETAILS, new UserDetailsMapper(), userId, tenantId).stream().findFirst();

		if (resp.isPresent())
			retval = resp.get();
		else {
			LOG.error("Query user with userId: {}, tenant:{} with NO RECORD FOUND", userId, tenantId);
			return null;
		}

		LOG.info("For getUserDetails userId:{}, tenantId: {}, user details are {}", userId, tenantId,
				retval.toString());
		return retval;
	}

	/**
	 * @implSpec: execute query: select t.id, t.created_timestamp, t.token_no,
	 *            t.points_accrued, t.commodity_code from natraj.transactions t
	 *            where t.event_name = 'SAVE_TRANSACTION' and from_user_id = ?;
	 * 
	 * @param userId
	 * @param tenantId
	 * @return
	 */
	public List<TxnDTO> getTransactionListForUserUserDetails(BigInteger userId, String tenantId) {
		LOG.info("Query user with userId: {}, tenant:{}", userId, tenantId);

		List<TxnDTO> retval = new ArrayList<TxnDTO>();
		Optional<List<TxnDTO>> resp = jdbcTemplate.query(AppConstant.GET_TXN_FOR_USER, new TxnDetailsMapper(), userId)
				.stream().findFirst();

		if (resp.isPresent())
			retval = resp.get();

		LOG.info("For getUserDetails userId:{}, tenantId: {}, user details are {}", userId, tenantId,
				retval.toString());
		return retval;
	}

}
