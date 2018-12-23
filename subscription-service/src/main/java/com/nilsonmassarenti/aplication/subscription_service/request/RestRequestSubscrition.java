package com.nilsonmassarenti.aplication.subscription_service.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nilsonmassarenti.aplication.subscription_service.model.Subscription;

@Component
public class RestRequestSubscrition {

	@Autowired
	private RestRequest restRequest;

	@Value("${adidas.server.service.event.link}")
	private String adidasEventLink;

	@Value("${adidas.server.service.email.link}")
	private String adidasEmailLink;

	@Value("${adidas.server.service.wait}")
	private Integer failWait;
	
	@Value("${adidas.server.service.attempts}")
	private Integer attempts;
	
	public void sendSubscriptionToEmailAndEventServices(Subscription subscription) {
		createThreadToSubscription(adidasEmailLink, subscription);
		createThreadToSubscription(adidasEventLink, subscription);
	}
	
	private void createThreadToSubscription(String url, Subscription subscription) {
		Thread thread = new Thread(new Runnable() {
			Integer tAttempts = attempts;
			@Override
			public void run() {
				
				Integer attempt = 0;
				System.out.println("Processing - " + url + " - attempt: " + attempt);
				while (restRequest.postSubscription(subscription, url) == false || attempt == tAttempts) {
					attempt++;
					System.out.println("Processing - " + url + " - attempt: " + attempt);
					try {
						Thread.sleep(failWait);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Processed - " + url + " - attempt: " + attempt);
			}
		});
		thread.start();
	}
}
