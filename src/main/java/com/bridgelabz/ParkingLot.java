package com.bridgelabz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParkingLot {

	private List<Car> parkedCars = new ArrayList<>();;
	int capacity;

	public ParkingLot(int capacity) {
		this.capacity = capacity;
	}

	public void parkCar(Car car) {
		if (parkedCars.size() < capacity) {
			parkedCars.add(car);
			System.out.println(car.getLicensePlate() + " has been parked.");
		} else {
			System.out.println("Parking lot is full. Cannot park " + car.getLicensePlate() + ".");
		}
	}

	public void unparkCar(String licensePlate) {
		Iterator<Car> iterator = parkedCars.iterator();
		while (iterator.hasNext()) {
			Car car = iterator.next();
			if (car.getLicensePlate().equals(licensePlate)) {
				iterator.remove();
				System.out.println(car.getLicensePlate() + " has been unparked.");
				return;
			}
		}
		System.out.println("Car with license plate " + licensePlate + " not found in the parking lot.");
	}

	public List<Car> getParkedCars() {
		return parkedCars;
	}

	public void printParkedCars() {
		System.out.println();
		System.out.println("Parked cars: ");
		for (Car car : parkedCars) {
			System.out.println(car.getLicensePlate());
		}
	}
}
