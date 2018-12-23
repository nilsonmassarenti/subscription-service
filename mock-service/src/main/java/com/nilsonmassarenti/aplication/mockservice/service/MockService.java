package com.nilsonmassarenti.aplication.mockservice.service;

import java.util.Random;

public final class MockService {

	public static Boolean randomHttpResponse(String service) {
		double min = 0;
		double max = 100;
		Random r = new Random();
		double randomValue = min + (max - min) * r.nextDouble();
		Boolean response = true;
		switch (service) {
		case "event":
			if (randomValue >= 90.00) {
				response = false;
			}
			break;
		case "email":
			if (randomValue >= 99.99) {
				response = false;
			}
			break;
		default:
			break;
		}
		return response;
	}
}
