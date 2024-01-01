package com.bridgelabz.model;

import java.util.List;

public class PoliceDepartment {
	private ParkingAttendant parkingAttendant;

	public PoliceDepartment(ParkingAttendant parkingAttendant) {
		this.parkingAttendant = parkingAttendant;
	}

	public List<String> getLocationOfParkedWhiteCars() {
		return parkingAttendant.getLocationOfParkedWhiteCars();
	}

}
