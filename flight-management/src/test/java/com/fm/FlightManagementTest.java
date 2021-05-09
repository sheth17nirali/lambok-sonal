package com.fm;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.fm.model.Flight;
import com.fm.model.Passenger;

//JUnit testing

public class FlightManagementTest {

	@Test
	public void testViptoEconomyFlight() {
		Flight flight = new Flight();
		flight.setId("3");
		flight.setFlightType("economy");

		// adding VIP to economy flight
		Passenger passenger = new Passenger("Pavi", true);
		flight.addPassenger(passenger);

		List<Passenger> passengersList = flight.getPassengers();
		assertEquals(1, passengersList.size());

		// Remove VIP from Economy Flight
		flight.removePassenger(passenger);
		assertEquals(1, passengersList.size());
	}

	@Test
	public void testViptoBusinessFlight() {
		Flight flight = new Flight();
		flight.setId("4");
		flight.setFlightType("business");

		// adding VIP to business flight
		Passenger passenger = new Passenger("Thara", true);
		flight.addPassenger(passenger);

		List<Passenger> passengersList = flight.getPassengers();
		assertEquals(1, passengersList.size());

		// removing VIP from business flight
		flight.removePassenger(passenger);
		assertEquals(1, passengersList.size());
	}

	@Test
	public void testAddNonViptoEconomyFlight() {
		Flight flight = new Flight();
		flight.setId("5");
		flight.setFlightType("economy");

		// adding Non VIP to economy flight
		Passenger passenger = new Passenger("John", false);
		flight.addPassenger(passenger);

		List<Passenger> passengersList = flight.getPassengers();
		assertEquals(1, passengersList.size());

		// removing Non VIP from economy flight
		flight.removePassenger(passenger);
		assertEquals(0, passengersList.size());
	}

	@Test
	public void testAddNonViptoBusinessFlight() {
		Flight flight = new Flight();
		flight.setId("6");
		flight.setFlightType("business");

		// adding Non VIP to business flight
		Passenger passenger = new Passenger("Rebeaca", false);
		flight.addPassenger(passenger);

		List<Passenger> passengersList = flight.getPassengers();
		assertEquals(0, passengersList.size());

		// removing Non VIP from economy flight
		flight.removePassenger(passenger);
		assertEquals(0, passengersList.size());
	}

	@Test
	public void setterGetterTest() {
		String x = "Something";
		Flight flight = new Flight();

		flight.setFlightType(x);
		assertEquals(x, flight.getFlightType());

		flight.setId(x);
		assertEquals(x, flight.getId());

		Passenger passenger = new Passenger(x, false);
		assertEquals(x, passenger.getName());
		assertEquals(false, passenger.isVip());

		passenger.setName("new");
		assertEquals("new", passenger.getName());
		passenger.setVip(true);
		assertEquals(true, passenger.isVip());
		
		//run main
		String[] args= {};
		Application.main(args);
	}
	
}