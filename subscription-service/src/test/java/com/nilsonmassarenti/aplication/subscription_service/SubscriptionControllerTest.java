package com.nilsonmassarenti.aplication.subscription_service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;
import com.nilsonmassarenti.aplication.subscription_service.controller.SubscriptionController;
import com.nilsonmassarenti.aplication.subscription_service.dto.SubscriptionCreateDTO;

public class SubscriptionControllerTest extends SubscriptionServiceApplicationTests {

	private MockMvc mockMvc;
	
	@Autowired
	private SubscriptionController subscriptionController;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(subscriptionController).build();
	}
	
	@Test
	public void testPOSTSubscriptionController() throws Exception {
		SubscriptionCreateDTO subscriptionCreateDTO = new SubscriptionCreateDTO();
		subscriptionCreateDTO.setEmail("nilsonmassarenti@gmail.com");
		subscriptionCreateDTO.setConsent(true);
		subscriptionCreateDTO.setNewsletterId("abcbcbabababcbabcabca");
		subscriptionCreateDTO.setFirstName("Nilson");
		subscriptionCreateDTO.setGender("male");
		Gson gson = new Gson();
		//this.mockMvc.perform(MockMvcRequestBuilders.post("/v1/subscriptions").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(subscriptionCreateDTO))).andExpect(MockMvcResultMatchers.status().isOk());
	}
}
