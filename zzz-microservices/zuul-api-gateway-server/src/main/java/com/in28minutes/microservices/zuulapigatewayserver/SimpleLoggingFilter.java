package com.in28minutes.microservices.zuulapigatewayserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class SimpleLoggingFilter extends ZuulFilter {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();

		log.info("{} {} {}", 
				context, 
				context.getRequest().getRequestURL(), 
				context.getZuulRequestHeaders());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
