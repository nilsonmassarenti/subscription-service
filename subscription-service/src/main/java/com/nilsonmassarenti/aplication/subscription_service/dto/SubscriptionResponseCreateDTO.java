package com.nilsonmassarenti.aplication.subscription_service.dto;

import lombok.Getter;
import lombok.Setter;

public class SubscriptionResponseCreateDTO {
	@Getter @Setter
	private Long id;

	public SubscriptionResponseCreateDTO(Long id) {
		super();
		this.id = id;
	}
	
}
