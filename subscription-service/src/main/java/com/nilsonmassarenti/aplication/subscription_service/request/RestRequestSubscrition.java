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
		Thread tEvent = new Thread(new Runnable() {

			@Override
			public void run() {
				Integer attempt = 0;
				while (restRequest.postSubscription(subscription, adidasEventLink) == false || attempt == 10) {
					attempt++;
					try {
						Thread.sleep(failWait);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		tEvent.start();

		Thread tEmail = new Thread(new Runnable() {

			@Override
			public void run() {
				Integer attempt = 0;
				while (restRequest.postSubscription(subscription, adidasEmailLink) == false || attempt == 10) {
					attempt++;
					try {
						Thread.sleep(failWait);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		tEmail.start();
	}
}
