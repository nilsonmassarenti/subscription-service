package com.nilsonmassarenti.aplication.subscription_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class })
public class SubscriptionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionServiceApplication.class, args);
	}

}

