package com.nector.alpha.uno.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.nector.alpha.uno.common.ApplicationHeaders;
import com.nector.alpha.uno.entity.EventDetails;
import com.nector.alpha.uno.entity.TenantDetails;
import com.nector.alpha.uno.entity.TokenDetails;
import com.nector.alpha.uno.entity.Transaction;
import com.nector.alpha.uno.entity.UserDetails;
import com.nector.alpha.uno.interfaces.ICommonOperation;
import com.nector.alpha.uno.service.CommonService;

/**
 * @author shashank https://www.sohamkamani.com/java/spring-rest-http-server/
 *
 */
@RestController
@Controller("commonController")
@RequestMapping("/natraj/v1")
public class CommonController implements ICommonOperation {
	private static final Logger LOG = LoggerFactory.getLogger(CommonController.class);
	private static final Gson gson = new Gson();

	@Autowired
	CommonService commonService;

	@GetMapping("/simple-request")
	public String simpleRequest() {
		// In this case, we return the plain text response "ok"
		return "ok";
	}

	@GetMapping("/echo")
	// We can pass the name of the url param we want as an argument to the
	// RequestParam annotation.
	// The value will be stored in the annotated variable
	public String echo(@RequestParam(name = "text") String echoText) {
		// The response will be "Echo: " followed by the param that was passed in
		return "Echo: " + echoText;
	}

	@GetMapping("/echo/{text}")
	// The PathVariable annotation assigns the text form the actual request to the
	// `echoText`
	// argument
	public String echoPath(@PathVariable(name = "text") String echoText) {
		return "Echo in path: " + echoText;
	}

	@PostMapping("/save-user")
	public UserDetails saveUser(@RequestBody UserDetails userDetails, @RequestHeader Map<String, String> allHeaders)
			throws IOException {

		String apiKey = allHeaders.get(ApplicationHeaders.X_API_KEY);
		LOG.info("Request recieved with APIKEY", apiKey);

		LOG.info("User input: {}", userDetails.toString());
		userDetails.setCreatedBy("SYSTEM");
		userDetails.setUpdatedBy("SYSTEM");

		userDetails.setCreatedTimestamp(new Timestamp(System.currentTimeMillis()));
		userDetails.setUpdatedTimestamp(new Timestamp(System.currentTimeMillis()));

		return commonService.saveUser(userDetails);
	}

	/**
	 * @param tenantDetails
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/save-tenant")
	public TenantDetails saveUser(@RequestBody TenantDetails tenantDetails) throws IOException {

		LOG.info("User input: {}", tenantDetails.toString());
		tenantDetails.setCreatedBy("SYSTEM");
		tenantDetails.setUpdatedBy("SYSTEM");

		tenantDetails.setCreatedTimestamp(new Timestamp(System.currentTimeMillis()));
		tenantDetails.setUpdatedTimestamp(new Timestamp(System.currentTimeMillis()));

		return commonService.saveTenant(tenantDetails);
	}

	@Override
	public int approveUser(String jsonBody) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createCommodity(String jsonBody) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCommodity(String jsonBody) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@PostMapping("/save-transaction")
	@Override
	public TokenDetails issueToken(@RequestBody TokenDetails tokenDetails) throws IOException {
		return commonService.issueToken(tokenDetails);
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
	 *
	 */
	@PostMapping("/save-transaction")
	@Override
	public Transaction transact(@RequestBody Transaction txn, @RequestHeader Map<String, String> allHeaders)
			throws IOException {
		LOG.info("User input: {}", txn.toString());

		return commonService.saveTransaction(txn);
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

	@Override
	public int saveUser(String jsonBody) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @param eventDetails
	 * @return
	 */
	@PostMapping("/save-event")
	public EventDetails saveEvent(@RequestBody EventDetails eventDetails, @RequestHeader Map<String, String> allHeaders)
			throws IOException {

		return commonService.saveEvent(eventDetails);
	}

}
