package com.bridgelabz;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

	private List<Car> parkedCars = new ArrayList<>();;
	int capacity;

	public ParkingLot(int capacity) {
		this.capacity = capacity;
	}

	public void parkCar(Car car) {
		parkedCars.add(car);
		System.out.println(car.getLicensePlate() + " has been parked.");

	}

	public List<Car> getParkedCars() {
		return parkedCars;
	}

	public void printParkedCars() {
		System.out.println("Parked cars: ");
		for (Car car : parkedCars) {
			System.out.println(car.getLicensePlate());
		}
	}
}
