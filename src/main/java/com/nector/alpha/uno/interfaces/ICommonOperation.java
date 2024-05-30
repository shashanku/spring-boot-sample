/**
 * 
 */
package com.nector.alpha.uno.interfaces;

import java.io.IOException;
import java.util.Map;

import com.nector.alpha.uno.entity.TokenDetails;
import com.nector.alpha.uno.entity.Transaction;

/**
 * 
 */
public interface ICommonOperation {

	public int saveUser(final String jsonBody) throws IOException;

	public int approveUser(final String jsonBody) throws IOException;

	public int createCommodity(final String jsonBody) throws IOException;

	public int updateCommodity(final String jsonBody) throws IOException;

	public TokenDetails issueToken(TokenDetails tokenDetails) throws IOException;

	public int deleteToken(final String jsonBody) throws IOException;

	public int updateExchangeRate(final String jsonBody) throws IOException;

	public int updateCommodityPoints(final String jsonBody) throws IOException;

	public Transaction transact(Transaction txn, Map<String, String> allHeaders) throws IOException;

	public int redeem(final String jsonBody) throws IOException;

	public int generateReport(final String jsonBody) throws IOException;

	public int queryToken(final String jsonBody) throws IOException;

	public int queryCommodity(final String jsonBody) throws IOException;

	public int queryUser(final String jsonBody) throws IOException;

	public int queryTxn(final String jsonBody) throws IOException;

	public int queryUserTxn(final String jsonBody) throws IOException;

}
