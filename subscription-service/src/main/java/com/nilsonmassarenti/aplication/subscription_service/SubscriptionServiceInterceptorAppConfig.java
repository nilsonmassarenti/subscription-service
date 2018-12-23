package com.nilsonmassarenti.aplication.subscription_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class SubscriptionServiceInterceptorAppConfig implements WebMvcConfigurer  {
	@Autowired
	SubscriptionServiceInterceptor subscriptionServiceInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(subscriptionServiceInterceptor);
	}
}
