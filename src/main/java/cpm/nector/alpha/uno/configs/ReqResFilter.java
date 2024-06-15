/**
 * 
 */
package cpm.nector.alpha.uno.configs;

import java.io.IOException;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Order;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.nector.alpha.uno.common.AppConstant;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 
 */
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Component
//@WebFilter(filterName = "RequestCachingFilter", urlPatterns = "/*")
public class ReqResFilter implements Filter {
	private static final Logger LOG = LogManager.getLogger(ReqResFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOG.debug("###### Initiating custom filter");

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
//		MDC.put("requestId", UUID.randomUUID().toString());

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletRequest response = (HttpServletRequest) servletResponse;

		LOG.debug("Method call {}", request.getMethod());
		chain.doFilter(servletRequest, servletResponse);

		LOG.debug("Response recieved with output {}", response.getContentType());

	}

	@Override
	public void destroy() {

//		MDC.remove("requestId");
		LOG.debug("###### Destroy custom filter");
	}

}
