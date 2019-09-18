package com.example.zuul.filters;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

@Component
public class RouteFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("reporting from zuul route filter...");
		return null;
	}

	@Override
	public String filterType() {
		
		return "route";
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

}
