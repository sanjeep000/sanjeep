package com.sanjeep.jms.Controller;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sanjeep.jms.Integration.ReservationRestClient;
import com.sanjeep.jms.model.Reservation;
import com.sanjeep.jms.model.ReservationupdateReservation;

@Controller
public class FlightCheckInController {
	
	@Autowired
	ReservationRestClient restClient;
	
	
	
	@RequestMapping("/showStartCheckIn")
	public String showStartCheckIn() {
		return "startCheckIn";
	}

	 
	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId") Long reservationId,ModelMap modelMap) {
		Reservation reservation = restClient.findReservation(reservationId);
		modelMap.addAttribute("reservation", reservation);
		return "displayReservationDetails";
	}
	@RequestMapping(value="/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId")Long reservationId, @RequestParam("numberOfBags")int numberOfBags) {
		ReservationupdateReservation request=new ReservationupdateReservation();
		request.setId(reservationId);
		request.setCheckedIn(true);
		request.setNumberOfBags(numberOfBags);
	     restClient.updateReservation(request);
		return "checkInConfirmation";
	}
}

 