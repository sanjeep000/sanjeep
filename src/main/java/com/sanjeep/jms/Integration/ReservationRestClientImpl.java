package com.sanjeep.jms.Integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sanjeep.jms.model.Reservation;
import com.sanjeep.jms.model.ReservationupdateReservation;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {
	
	private static final String HTTP_LOCAL = "http://localhost:8040/reservation/";
	
	

	@Override
	public Reservation findReservation(Long id) {
		RestTemplate restTemplate=new RestTemplate();
		   Reservation reservation = restTemplate.getForObject(HTTP_LOCAL+id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationupdateReservation request) {
		RestTemplate restTemplate=new RestTemplate();
		Reservation reservation = restTemplate.postForObject(HTTP_LOCAL, request, Reservation.class);
		return reservation;
		 
	
		

	
	}

}