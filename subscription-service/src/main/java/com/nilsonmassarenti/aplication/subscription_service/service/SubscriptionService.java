package com.nilsonmassarenti.aplication.subscription_service.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilsonmassarenti.aplication.subscription_service.dto.SubscriptionCreateDTO;
import com.nilsonmassarenti.aplication.subscription_service.model.ErrorMessage;
import com.nilsonmassarenti.aplication.subscription_service.model.Subscription;
import com.nilsonmassarenti.aplication.subscription_service.repository.SubscriptionRepository;
import com.nilsonmassarenti.aplication.subscription_service.request.RestRequestSubscrition;

@Service
public class SubscriptionService {
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Autowired RestRequestSubscrition restRequestSubscrition;
	
	public Subscription create(Subscription subscription) {
		if (subscriptionRepository.findByEmailAndNewsletterId(subscription.getEmail(), subscription.getNewsletterId()) == null) {
			subscription = subscriptionRepository.save(subscription);	
		}
		if (subscription != null && subscription.getId() != null) {
			Subscription subscriptionToSave = subscription;
			Thread tSaveRest = new Thread(new Runnable() {

				@Override
				public void run() {
					restRequestSubscrition.sendSubscriptionToEmailAndEventServices(subscriptionToSave);
				}
			});
			tSaveRest.start(); 
		}
		return subscription;
	}
	
	public Subscription convertSubscriptionCreateDTOToSubscriptionEntity(SubscriptionCreateDTO subscriptionCreateDTO) {
		Subscription subscription = new Subscription();
		subscription.setEmail(subscriptionCreateDTO.getEmail());
		subscription.setFirstName(subscriptionCreateDTO.getFirstName());
		subscription.setGender(subscriptionCreateDTO.getGender());
		subscription.setDateOfBith(subscription.getDateOfBith());
		subscription.setConsent(subscriptionCreateDTO.getConsent());
		subscription.setNewsletterId(subscriptionCreateDTO.getNewsletterId());		
		subscription.setSubscribeAt(LocalDateTime.now());
		return subscription;
	}
}
