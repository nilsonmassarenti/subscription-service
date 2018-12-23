package com.nilsonmassarenti.aplication.subscription_service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class SubscriptionServiceInterceptor implements HandlerInterceptor {

	@Value("${subscription.http.auth-token-header-name}")
	private String tokenName;

	@Value("${subscription.http.http.auth-token}")
	private String tokenSecurity;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	    if (request.getServletPath() != null && request.getServletPath().contains("/api/")) {
	    	if (request.getHeader(tokenName) == null || !request.getHeader(tokenName).equals(tokenSecurity)) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return false;
			}
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {

	}
}
