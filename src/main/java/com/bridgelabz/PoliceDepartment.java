package com.bridgelabz;
import java.util.ArrayList;
import java.util.List;

public class PoliceDepartment {
	private ParkingAttendant parkingAttendant;

	public PoliceDepartment(ParkingAttendant parkingAttendant) {
		this.parkingAttendant = parkingAttendant;
	}

	public List<String> getLocationOfParkedColorCars(String color) {
		return parkingAttendant.getLocationOfParkedCarsbyColor(color);
	}

	public List<String> getLocationOfParkedColorAndBrandCars(String color, String brand) {
		List<String> result = new ArrayList<>();
		List<String> locations = parkingAttendant.getLocationOfParkedCarsbyBrandaColor(color, brand);
		String name= parkingAttendant.parkingAttendantName;
		for (String location : locations) {
			result.add(name + " " + location);
		}
		return result;

	}

public List<String> getLocationOfParkedBrandCars(String brand) {
        return parkingAttendant.getLocationOfParkedCarsByBrand(brand);
    }
public List<String> getCarsParkedLast30Minutes() {
        return parkingAttendant.carsParkedLast30Minutes();
    }

}
