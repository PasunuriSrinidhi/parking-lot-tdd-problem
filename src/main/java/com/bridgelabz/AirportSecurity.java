package com.bridgelabz.observers;

public class AirportSecurity implements ParkingObservers {

	@Override
	public void update() {
		System.out.println("Airport Security: The Parking Lot is full. Redirecting security staff.");
	}

	@Override
	public String getStatus() {
		return "full";
	}

}
