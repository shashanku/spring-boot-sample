/**
 * 
 */
package com.nector.alpha.uno;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cpm.nector.alpha.uno.configs.MdcInterceptor;

/**
 * 
 */
@Component
//@AllArgsConstructor
public class WebMvcConfiguration implements WebMvcConfigurer {

	private final MdcInterceptor mdcInterceptor = new MdcInterceptor();

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(mdcInterceptor);
	}

}