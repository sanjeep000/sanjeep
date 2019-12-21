package com.sanjeep.jms.Integration;

import com.sanjeep.jms.model.Reservation;
import com.sanjeep.jms.model.ReservationupdateReservation;

public interface ReservationRestClient {

	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationupdateReservation request);
	
}
