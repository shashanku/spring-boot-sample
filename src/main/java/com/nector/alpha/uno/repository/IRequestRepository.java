/**
 * 
 */
package com.nector.alpha.uno.repository;

import java.io.IOException;

import com.nector.alpha.uno.entity.CommodityDetails;
import com.nector.alpha.uno.entity.TokenDetails;
import com.nector.alpha.uno.entity.Transaction;
import com.nector.alpha.uno.entity.UserDetails;

/**
 * @author shashank1.upadhyay
 *
 */
public interface IRequestRepository {
	public UserDetails saveUser(final UserDetails userDetails) throws IOException;

	public int approveUser(final String jsonBody) throws IOException;

	public CommodityDetails createCommodity(CommodityDetails createCommodity) throws IOException;

	public int updateCommodity(final String jsonBody) throws IOException;

	public TokenDetails issueToken(TokenDetails tokenDetails) throws IOException;

	public int deleteToken(final String jsonBody) throws IOException;

	public int updateExchangeRate(final String jsonBody) throws IOException;

	public int updateCommodityPoints(final String jsonBody) throws IOException;

	//public Transaction transact(Transaction txn) throws IOException;

	public int redeem(final String jsonBody) throws IOException;

	public int generateReport(final String jsonBody) throws IOException;

	public int queryToken(final String jsonBody) throws IOException;

	public int queryCommodity(final String jsonBody) throws IOException;

	public int queryUser(final String jsonBody) throws IOException;

	public int queryTxn(final String jsonBody) throws IOException;

	public int queryUserTxn(final String jsonBody) throws IOException;

//	/**
//	 * @param body
//	 * @return
//	 */
//	public BigInteger saveTvRequest(final String body);
//
//	/**
//	 * @param body
//	 * @param refNo
//	 * @return
//	 */
//	public BigInteger saveTvRequest(final String body, final String refNo);
//
//	/**
//	 * @param aesKey
//	 * @param aesIv
//	 * @param body
//	 * @param parentId
//	 * @return
//	 */
//	public BigInteger saveSvtRequest(final String aesKey, final String aesIv, final String body,
//			final BigInteger parentId);
//
//	/**
//	 * @param refNo
//	 * @param tvRefNo
//	 * @param svtRefNo
//	 * @param opCode
//	 * @return
//	 */
//	public BigInteger saveTvSvtMapping(final String refNo, final String tvRefNo, final String svtRefNo,
//			final Integer opCode);
//
//	/**
//	 * @param aesKey
//	 * @param aesIv
//	 * @param body
//	 * @param parentId
//	 * @param refNo
//	 * @return
//	 */
//	public BigInteger saveSvtRequest(final String aesKey, final String aesIv, final String body,
//			final BigInteger parentId, final String refNo);
//
//	/**
//	 * @param httpResponseCode
//	 * @param response
//	 * @param tvId
//	 */
//	public void updateTvRequest(final int httpResponseCode, final String response, final BigInteger tvId);
//
//	/**
//	 * @param httpResponseCode
//	 * @param response
//	 * @param tvRefNo
//	 */
//	public void updateTvRequest(int httpResponseCode, String response, String tvRefNo);
//
//	/**
//	 * @param httpResponseCode
//	 * @param response
//	 * @param svtId
//	 */
//	public void updateSvtRequest(final int httpResponseCode, final String response, final BigInteger svtId);
//
//	/**
//	 * @param httpResponseCode
//	 * @param response
//	 * @param svtRefNo
//	 */
//	public void updateSvtRequest(final int httpResponseCode, final String response, final String svtRefNo);
//
//	/**
//	 * @param customerNo
//	 * @return
//	 */
//	public Optional<String> getMobileForCustomer(final BigInteger customerNo);
//
//	/**
//	 * @param customerNo
//	 * @param mobile
//	 * @return
//	 */
//	public BigInteger setMobileForCustomer(final BigInteger customerNo, final BigInteger mobile);
//
//	/**
//	 * @return
//	 */
//	public Optional<List<TVOpRecord>> getTVMappingList();
//
//	/**
//	 * @return
//	 */
//	public Optional<List<SVTOpRecord>> getSVTMappingList();
//
//	/**
//	 * @param req
//	 * @return
//	 */
//	public Integer updateCustomerRec(TVValidateUserDetails req);
//
//	/**
//	 * @param req
//	 * @param refNo
//	 * @return
//	 */
//	public BigInteger addCutomerRecord(TVMobAppRegReq req, String refNo, MobileAppRegResp tvres);
//
//	/**
//	 * @param req
//	 * @return
//	 */
//	public Integer updateCustomerRecWithOTP(TVOTPValidateReq req);
//
//	/**
//	 * @param referenceNo
//	 * @return
//	 */
//	public Optional<PendingRefNoRec> getRecForPendingRefNo(String referenceNo);
//
//	/**
//	 * @param customerNo
//	 * @param referenceNo
//	 * @return
//	 */
//	public Optional<TVCustomerRecord> getCustomerRecord(String customerNo, String referenceNo);

}
