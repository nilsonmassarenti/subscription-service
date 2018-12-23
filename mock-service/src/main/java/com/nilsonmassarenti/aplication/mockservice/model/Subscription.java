package com.nilsonmassarenti.aplication.mockservice.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


public class Subscription {

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
}
