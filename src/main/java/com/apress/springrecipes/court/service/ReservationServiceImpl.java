package com.apress.springrecipes.court.service;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.apress.springrecipes.court.domain.Player;
import com.apress.springrecipes.court.domain.Reservation;
import com.apress.springrecipes.court.domain.SportType;

public class ReservationServiceImpl implements ReservationService 
{
	public static final SportType TENNIS = new SportType(1, "Tennis");
	public static final SportType SOCCER = new SportType(2, "Soccer");
	
	private List<Reservation> reservations;
	
	public ReservationServiceImpl()
	{
		reservations = new ArrayList<Reservation>();
		reservations.add(new Reservation("Tennis #1", new GregorianCalendar(2008, 0, 14).getTime(), 16, new Player("Roger", "N/A"), TENNIS));
		reservations.add(new Reservation("Tennis #2", new GregorianCalendar(2008, 0, 14).getTime(), 20, new Player("James", "N/A"), TENNIS));
	}
	
	@Override
	public List<Reservation> query(String courtName) 
	{
		List<Reservation> result = new ArrayList<Reservation>();
		for (Reservation reservation : reservations)
		{
			if (reservation.getCourtName().equals(courtName))
			{
				result.add(reservation);
			}
		}
		
		return result;
	}
}