package com.nector.alpha.uno;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cpm.nector.alpha.uno.configs.ReqResFilter;

@Configuration
public class UnoConfig {
	private final ReqResFilter reqResFilter = new ReqResFilter();

//	@Bean
//	public FilterRegistrationBean<ReqResFilter> filterRequestBean() {
//		FilterRegistrationBean<ReqResFilter> reqResBean = new FilterRegistrationBean<ReqResFilter>();
//
//		reqResBean.setFilter(reqResFilter);
//		reqResBean.addUrlPatterns("/nopattern/*");
//		reqResBean.setOrder(2);
//
//		return reqResBean;
//
//	}

}
