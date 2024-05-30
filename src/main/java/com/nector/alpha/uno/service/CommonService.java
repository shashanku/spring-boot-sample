package com.nector.alpha.uno.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.nector.alpha.uno.common.CacheManager;
import com.nector.alpha.uno.entity.EventDetails;
import com.nector.alpha.uno.entity.TenantDetails;
import com.nector.alpha.uno.entity.TokenDetails;
import com.nector.alpha.uno.entity.Transaction;
import com.nector.alpha.uno.entity.UserDetails;
import com.nector.alpha.uno.interfaces.ICommonService;
import com.nector.alpha.uno.repository.RequestRepository;
import com.nector.alpha.uno.repository.TenantApiKeyRecord;

import jakarta.persistence.Cache;

@Service
public class CommonService implements ICommonService {
	private static final Logger LOG = LoggerFactory.getLogger(CommonService.class);
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
	public Transaction saveTransaction(Transaction txn) throws IOException {
		return reqRepository.transact(txn);
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
	public TokenDetails issueToken(TokenDetails tokenDetails) throws IOException {
		LOG.info("User request with token details: {}", tokenDetails.toString());
		return reqRepository.issueToken(tokenDetails);
	}
}