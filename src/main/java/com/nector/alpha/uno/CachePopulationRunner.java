/**
 * 
 */
package com.nector.alpha.uno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.nector.alpha.uno.service.CommonService;

/**
 * 
 */
@Component
public class CachePopulationRunner implements ApplicationRunner {

	@Autowired
	private CommonService commonService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		commonService.populateCache();
	}
}
