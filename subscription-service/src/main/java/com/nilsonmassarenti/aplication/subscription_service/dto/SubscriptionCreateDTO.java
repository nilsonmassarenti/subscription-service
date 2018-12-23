package com.nilsonmassarenti.aplication.subscription_service.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

public class SubscriptionCreateDTO {
	
	@NotBlank
	@Email
	@Getter @Setter 
	private String email;
	@Getter @Setter
	private String firstName;
	@Getter @Setter
	private String gender;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull @Past
	@Getter @Setter
	private Date dateOfBirth;
	@NotNull
	@Getter @Setter
	private Boolean consent;
	@NotBlank
	@Getter @Setter
	private String newsletterId;
	

}
