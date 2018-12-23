package com.nilsonmassarenti.aplication.subscription_service.request;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.nilsonmassarenti.aplication.subscription_service.model.Subscription;

@Component
public class RestRequest {

	public Boolean postSubscription(Subscription subscription, String url) {
		Gson gson = new Gson();
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpEntity = new HttpEntity<>(gson.toJson(subscription), httpHeaders);

		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
			if (response.getStatusCode().is2xxSuccessful()) {
				return true;
			} else {
				return false;
			}
		} catch (RestClientException e) {
			if (e instanceof HttpStatusCodeException) {
				String errorResponse = ((HttpStatusCodeException) e).getResponseBodyAsString();
				System.err.println(errorResponse);
			}
			return false;
		}
	}
	
}
