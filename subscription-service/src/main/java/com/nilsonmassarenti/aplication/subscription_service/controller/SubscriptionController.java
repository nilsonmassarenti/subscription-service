package com.nilsonmassarenti.aplication.subscription_service.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nilsonmassarenti.aplication.subscription_service.dto.SubscriptionCreateDTO;
import com.nilsonmassarenti.aplication.subscription_service.dto.SubscriptionResponseCreateDTO;
import com.nilsonmassarenti.aplication.subscription_service.model.Subscription;
import com.nilsonmassarenti.aplication.subscription_service.service.SubscriptionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("v1/subscriptions")
@Api(value = "v1/subscriptions", tags = {"Subscription"})
public class SubscriptionController {
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@ApiOperation(value = "Create subscription",
			notes = "Create subscription for campaign",
			response = SubscriptionResponseCreateDTO.class
	)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Subscription created"),
			@ApiResponse(code = 400, message = "Object not valid"),
			@ApiResponse(code = 409, message = "Subscription already created before to that email and campaign"),
			@ApiResponse(code = 500, message = "Internal server error")
			
	})
	@PostMapping
	public ResponseEntity<?> createSubscription(@Valid @RequestBody SubscriptionCreateDTO subscriptionCreateDTO){
		Subscription subscription = this.subscriptionService.convertSubscriptionCreateDTOToSubscriptionEntity(subscriptionCreateDTO);
		subscription = this.subscriptionService.create(subscription);
		if (subscription != null && subscription.getId() != null) {
			return new ResponseEntity<SubscriptionResponseCreateDTO>(new SubscriptionResponseCreateDTO(subscription.getId()), HttpStatus.OK);
		} else if (subscription ==  null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
}
