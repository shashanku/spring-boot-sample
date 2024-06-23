package com.nector.alpha.uno.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.nector.alpha.uno.entity.ApprovalDetailsReq;
import com.nector.alpha.uno.entity.CommodityDetails;
import com.nector.alpha.uno.entity.EventDetails;
import com.nector.alpha.uno.entity.TenantDetails;
import com.nector.alpha.uno.entity.TokenDetails;
import com.nector.alpha.uno.entity.UserDetails;
import com.nector.alpha.uno.req.SaveTxnVO;
import com.nector.alpha.uno.service.CommonService;

/**
 * @author shashank https://www.sohamkamani.com/java/spring-rest-http-server/
 *
 */
@RestController
@Controller("commonController")
@RequestMapping("/natraj/v1")
public class CommonController {
	private static final Logger LOG = LogManager.getLogger(CommonController.class);
	private static final Gson gson = new Gson();

	@Autowired
	CommonService commonService;

	@GetMapping("/simple-request")
	public String simpleRequest() {
		return "ok";
	}

	@GetMapping("/echo")
	// We can pass the name of the url param we want as an argument to the
	// RequestParam annotation.
	// The value will be stored in the annotated variable
	public String echo(@RequestParam(name = "text") String echoText) {
		// The response will be "Echo: " followed by the param that was passed in

		LOG.debug("Request Recieved");
		return "Echo: " + echoText;
	}

	@GetMapping("/echo/{text}")
	// The PathVariable annotation assigns the text form the actual request to the
	// `echoText`
	// argument
	public String echoPath(@PathVariable(name = "text") String echoText) {
		return "Echo in path: " + echoText;
	}

	@PostMapping("/user/create")
	public UserDetails saveUser(@RequestBody UserDetails userDetails, @RequestHeader Map<String, String> allHeaders)
			throws IOException {
// https://www.bezkoder.com/spring-boot-login-example-mysql/
		String apiKey = allHeaders.get(ApplicationHeaders.X_API_KEY);
		LOG.info("Request recieved with APIKEY", apiKey);

		userDetails.setAudits("SYSTEM", new Timestamp(System.currentTimeMillis()));
		LOG.info("User input: {}", userDetails.toString());

		return commonService.saveUser(userDetails);
	}

	/**
	 * @param tenantDetails
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/tenant/create")
	public TenantDetails saveUser(@RequestBody TenantDetails tenantDetails) throws IOException {

		LOG.info("User input: {}", tenantDetails.toString());

		tenantDetails.setAudits("SYSTEM", new Timestamp(System.currentTimeMillis()));
		LOG.info("User input: {}", tenantDetails.toString());

		return commonService.saveTenant(tenantDetails);
	}

	/**
	 * @param tenantDetails
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/commodity/create")
	public CommodityDetails saveCommodity(@RequestBody CommodityDetails commodityDetails) throws IOException {

		LOG.info("User input: {}", commodityDetails.toString());
		return commonService.saveCommodity(commodityDetails, "SYSTEM");
	}

	/**
	 * @param tenantDetails
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/token/create")
	public TokenDetails saveTokem(@RequestBody TokenDetails tokenDetails) throws IOException {

		LOG.info("User input: {}", tokenDetails.toString());

		return commonService.issueToken(tokenDetails, "SYSTEM");
	}

	/**
	 * @param eventDetails
	 * @return
	 */
	@PostMapping("/event/create")
	public EventDetails saveEvent(@RequestBody EventDetails eventDetails, @RequestHeader Map<String, String> allHeaders)
			throws IOException {

		return commonService.saveEvent(eventDetails);
	}

	/**
	 * @param eventDetails
	 * @return
	 */
	@PostMapping("/txn/create")
	public Object saveTransaction(@RequestBody SaveTxnVO userTxn, @RequestHeader Map<String, String> allHeaders)
			throws IOException {
		String apiKey = allHeaders.get(ApplicationHeaders.X_API_KEY);
		LOG.info("Request recieved with APIKEY", apiKey);

		return commonService.saveTransaction(userTxn);
	}

	/**
	 * @param eventDetails
	 * @return
	 */
	@PostMapping("/txn/list")
	public Object listTransaction(@RequestBody ApprovalDetailsReq approvalDetails,
			@RequestHeader Map<String, String> allHeaders) throws IOException {

		String apiKey = allHeaders.get(ApplicationHeaders.X_API_KEY);
		LOG.info("Request recieved with APIKEY: {} with User input: {}", apiKey, approvalDetails.toString());

		return commonService.queryUserTransactions(approvalDetails);
	}

	@PostMapping("/login")
	public UserDetails login(@RequestBody UserDetails userDetails, @RequestHeader Map<String, String> allHeaders)
			throws IOException {

		String apiKey = allHeaders.get(ApplicationHeaders.X_API_KEY);
		LOG.info("Request recieved with APIKEY", apiKey);

		userDetails.setAudits("SYSTEM", new Timestamp(System.currentTimeMillis()));
		LOG.info("User input: {}", userDetails.toString());

		return commonService.saveUser(userDetails);
	}

	/**
	 * @param eventDetails
	 * @return
	 */
	@PostMapping("/user/approvals")
	public Object pendingApprovals(@RequestBody ApprovalDetailsReq approvalDetails,
			@RequestHeader Map<String, String> allHeaders) throws IOException {
		String apiKey = allHeaders.get(ApplicationHeaders.X_API_KEY);
		LOG.info("Request recieved with APIKEY", apiKey);

		return commonService.getPendingApprovals(approvalDetails);
	}

	@GetMapping("/report/admin")
	public String adminReport(@RequestParam(name = "userId") String echoText) {
		LOG.debug("Request Recieved");
		return "Echo: " + echoText;
	}

}
