package com.bridgelabz;

public class AirportSecurity implements ParkingObservers {
        @Override
	public String update(boolean isFull) {
		if (isFull) {
			System.out.println("Airport Security: The Parking Lot is full. Redirecting security staff.");
			return "full";
		} else {
			System.out.println("Airport Security: The Parking Lot is not full. Security staff not required.");
			return "not full";
		}
	}

}
