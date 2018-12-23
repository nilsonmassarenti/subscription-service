package com.nilsonmassarenti.aplication.subscription_service.repository;

import org.springframework.data.repository.CrudRepository;

import com.nilsonmassarenti.aplication.subscription_service.model.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long>{
	
	Subscription findByEmailAndNewsletterId(String email, String newsletterId);
}
