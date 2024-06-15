package com.nector.alpha.uno.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.nector.alpha.uno.entity.EventDetails;

/**
 * @author shash
 *
 */

public class CacheManager {
	private static final Logger LOG = LogManager.getLogger(CacheManager.class);

	private Map<String, Boolean> isOperationOTPEnabled = new HashMap<>();
	private Map<String, Class> operationClassResponseMap = new HashMap<>();
	private Boolean isCachePopulated = false;

	private static Map<String, Integer> apiKeyTenantIdMap = new HashMap<String, Integer>();
	private static Map<String, EventDetails> eventMap = new HashMap<String, EventDetails>();

	@Value("${otp.expiration.ms}")
	private Long xx;

	/**
	 * 
	 */
	private CacheManager() {
	}

	/**
	 * 
	 */
	private static class SingletonHolder {
		private static final CacheManager INSTANCE = new CacheManager();
	}

	/**
	 * @return
	 */
	public static CacheManager getInstance() {
		return SingletonHolder.INSTANCE;
	}

	/**
	 * @param apiKey
	 * @return
	 */
	public static Integer getTenantId(String apiKey) {
		return apiKeyTenantIdMap.get(apiKey);
	}

	/**
	 * @param apiKey
	 * @param tenantId
	 */
	public static void setTenantId(String apiKey, Integer tenantId) {
		LOG.debug("apiKey: {}, tenantId: {}", apiKey, tenantId);

		apiKeyTenantIdMap.put(apiKey, tenantId);
	}

	/**
	 * @param apiKey
	 * @return
	 */
	public static EventDetails getEvent(String eventName) {
		return eventMap.get(eventName);
	}

	/**
	 * @param apiKey
	 * @param tenantId
	 */
	public static void setEvent(String eventName, EventDetails eventDetails) {
		LOG.debug("apiKey: {}, tenantId: {}", eventName, eventDetails);

		eventMap.put(eventName, eventDetails);
	}

}
