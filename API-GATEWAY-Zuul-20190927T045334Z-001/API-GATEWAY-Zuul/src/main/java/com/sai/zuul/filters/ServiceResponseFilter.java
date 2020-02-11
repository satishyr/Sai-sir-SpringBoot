package com.sai.zuul.filters;

import javax.servlet.http.HttpServletResponse;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class ServiceResponseFilter extends ZuulFilter{
	
	int count=1;
	
	public ServiceResponseFilter() {
		System.out.println("In ServiceResponseFilter()...!");
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext requestContext=RequestContext.getCurrentContext();
		HttpServletResponse servletResponse = requestContext.getResponse();
		servletResponse.setHeader("auth-v1", "auth-ok");
		servletResponse.setHeader("request-count",Integer.toString(count));
		count++;
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 10;
	}

}
