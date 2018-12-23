package com.nilsonmassarenti.aplication.subscription_service.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Subscription {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	private Long id;
	@Getter @Setter 
	private String email;
	@Getter @Setter
	private String firstName;
	@Getter @Setter
	private String gender;
	@Getter @Setter
	private String dateOfBith;
	@Getter @Setter
	private Boolean consent;
	@Getter @Setter
	private String newsletterId;
	@Getter @Setter
	private LocalDateTime subscribeAt;
	@Getter @Setter
	private LocalDateTime unsubscribeAt;
}
