package com.nector.alpha.uno.service;

import java.io.Console;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.http.util.TextUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.nector.alpha.uno.common.AppConstant;
import com.nector.alpha.uno.common.CacheManager;
import com.nector.alpha.uno.common.CommonResponse;
import com.nector.alpha.uno.entity.CommodityDetails;
import com.nector.alpha.uno.entity.EventDetails;
import com.nector.alpha.uno.entity.TenantDetails;
import com.nector.alpha.uno.entity.TokenCommodityRec;
import com.nector.alpha.uno.entity.TokenDetails;
import com.nector.alpha.uno.entity.UserDetails;
import com.nector.alpha.uno.interfaces.ICommonService;
import com.nector.alpha.uno.repository.RequestRepository;
import com.nector.alpha.uno.repository.TenantApiKeyRecord;
import com.nector.alpha.uno.req.SaveTxnVO;

@Service
public class CommonService implements ICommonService {
	private static final Logger LOG = LogManager.getLogger(CommonService.class);
	private static final Gson gson = new Gson();

	@Autowired
	private RequestRepository reqRepository;

	/**
	 * @param userDetails
	 * @return
	 * @throws IOException
	 */
	public UserDetails saveUser(UserDetails userDetails) throws IOException {
		return reqRepository.saveUser(userDetails);
	}

	/**
	 * @param tenantDetails
	 * @return
	 * @throws IOException
	 */
	public TenantDetails saveTenant(TenantDetails tenantDetails) throws IOException {
		return reqRepository.saveTenant(tenantDetails);
	}

	/**
	 * @throws IOException
	 */
	public void populateCache() throws IOException {

		LOG.info("Into populate cache method");

		Optional<List<TenantApiKeyRecord>> list = reqRepository.getApiKeyTenantIdMapping();
		Optional<List<EventDetails>> eventListOptional = reqRepository.getEventData();

		LOG.info("populate cache with api maps");
		if (!list.isPresent())
			LOG.error("No record present in db for tenant id");
		else {
			List<TenantApiKeyRecord> apiKeyTenatIdList = list.get();

			for (TenantApiKeyRecord tenantApiKeyRecord : apiKeyTenatIdList) {
				CacheManager.setTenantId(tenantApiKeyRecord.getApiKey(), tenantApiKeyRecord.getId());
			}

		}

		LOG.info("populate cache with event details");
		if (!eventListOptional.isPresent())
			LOG.error("No record present in db for event details");
		else {
			List<EventDetails> apiKeyTenatIdList = eventListOptional.get();

			for (EventDetails eventDetails : apiKeyTenatIdList) {
				CacheManager.setEvent(eventDetails.getEventName(), eventDetails);
			}

		}

	}

	/**
	 * @param txn
	 * @return
	 * @throws IOException
	 */
	public CommonResponse saveTransaction(SaveTxnVO txn) throws IOException {
		CommonResponse retval = new CommonResponse();

		// Get validity of token and point details
		TokenCommodityRec tokenInfo = reqRepository.getTokenDetails(txn.getTokenNo());
		LOG.info("Details for tokenNo: {} is {}", txn.getTokenNo(), tokenInfo.toString());

		if (tokenInfo.getTokenNo() == AppConstant.DEF_TOKEN)
			return new CommonResponse(0, "error", "Invalid token");

		Map<String, Long> res = reqRepository.saveUserTransaction(txn, tokenInfo);
		LOG.info("Txn details for tokenNo: {} are {}", txn.getTokenNo(), res.toString());

		List<String> conslidatedRes = new ArrayList<String>();
		for (Map.Entry<String, Long> entry : res.entrySet()) {
			conslidatedRes.add(entry.getValue().toString());
		}

		if (res.get(AppConstant.AUDIT_ID) == null || res.get(AppConstant.TXN_ID) == null)
			retval = new CommonResponse(-1, "error", String.join("|", conslidatedRes));
		else
			retval = new CommonResponse(0, "ok", String.join("|", conslidatedRes));

		LOG.info("final response -> tokenNo: {} are {}", txn.getTokenNo(), retval.toString());
		return retval;
	}

	/**
	 * @param eventDetails
	 * @return
	 */
	public EventDetails saveEvent(EventDetails eventDetails) {
		LOG.info("User request with event details: {}", eventDetails.toString());

		eventDetails = reqRepository.saveEvent(eventDetails);
		CacheManager.setEvent(eventDetails.getEventName(), eventDetails);

		return eventDetails;
	}

	/**
	 * @param tokenDetails
	 * @return
	 * @throws IOException
	 */
	public TokenDetails issueToken(TokenDetails tokenDetails, String user) throws IOException {
		LOG.info("User request with token details: {}", tokenDetails.toString());

		tokenDetails.setAudits(user, new Timestamp(System.currentTimeMillis()));
		return reqRepository.issueToken(tokenDetails);
	}

	public CommodityDetails saveCommodity(CommodityDetails commodityDetails, String user) throws IOException {
		LOG.info("User request with commodity details: {}", commodityDetails.toString());

		commodityDetails.setAudits(user, new Timestamp(System.currentTimeMillis()));
		return reqRepository.saveCommodity(commodityDetails);
	}
}