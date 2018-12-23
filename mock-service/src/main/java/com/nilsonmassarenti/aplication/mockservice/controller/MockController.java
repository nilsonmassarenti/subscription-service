package com.nilsonmassarenti.aplication.mockservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nilsonmassarenti.aplication.mockservice.model.Subscription;
import com.nilsonmassarenti.aplication.mockservice.service.MockService;

@RestController
public class MockController {
	
	@PostMapping("v1/events/subscription")
	public ResponseEntity<?> saveEventSubscription(@RequestBody Subscription subscription){
		if (MockService.randomHttpResponse("event")) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("v1/emails/subscription")
	public ResponseEntity<?> saveEmailSubscription(@RequestBody Subscription subscription){
		if (MockService.randomHttpResponse("email")) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
