package com.bridgelabz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bridgelabz.ParkingObservers;

/*
 * @Description - ParkingLot class to park and unpark cars and notify observers about parking lot status
 * 
 * @Properties - capacity - capacity of the parking lot
 * 				parkedCars - list of cars parked in the parking lot
 * 				observers - list of observers
 * 
 * @Methods - isFull() - checks if the parking lot is full
 * 			 parkCar() - parks the car in the parking lot
 * 			 unparkCar() - unparks the car from the parking lot
 * 			 addObservers() - adds observers to the list of observers
 * 			 removeObservers() - removes observers from the list of observers
 * 			 notifyObservers() - notifies observers about parking lot status
 * 			 getParkedCars() - returns the list of parked cars
 * 			 printParkedCars() - prints the list of parked cars
 * 
 */


public class ParkingLot {

	private List<Car> parkedCars = new ArrayList<>();
	private List<ParkingObservers> observers = new ArrayList<>();
	int capacity;

	/*
	 * @Description - Constructor to initialize the capacity of the parking lot
	 * 
	 * @param - capacity - capacity of the parking lot
	 * 
	 * @return - none
	 */
	public ParkingLot(int capacity) {
		this.capacity = capacity;
	}

	/*
	 * @Description - checks if the parking lot is full
	 * 
	 * @param - none
	 * 
	 * @return - true if the parking lot is full, false otherwise
	 */
	public boolean isFull() {
		return parkedCars.size() == capacity;
	}

	/*
	 * @Description - parks the car in the parking lot
	 * 
	 * @param - car - car to be parked
	 * 
	 * @return - none
	 */
	public void parkCar(Car car) {
		if (!isFull()) {
			parkedCars.add(car);
			System.out.println(car.getLicensePlate() + " has been parked.");
		} else {

			System.out.println("Parking lot is full. Cannot park " + car.getLicensePlate() + ".");
			notifyObservers(isFull());
		}
	}

	/*
	 * @Description - unparks the car from the parking lot
	 * 
	 * @param - licensePlate - license plate of the car to be unparked
	 * 
	 * @return - none
	 */
	public void unparkCar(String licensePlate) {
		Iterator<Car> iterator = parkedCars.iterator();
		while (iterator.hasNext()) {
			Car car = iterator.next();
			if (car.getLicensePlate().equals(licensePlate)) {
				iterator.remove();
				System.out.println(car.getLicensePlate() + " has been unparked.");
				notifyObservers(isFull());
				return;
			}
		}
		System.out.println("Car with license plate " + licensePlate + " not found in the parking lot.");
	}

	/*
	 * @Description - adds observers to the list of observers
	 * 
	 * @param - ob - observer to be added
	 * 
	 * @return - none
	 */
	public void addObservers(ParkingObservers ob) {
		observers.add(ob);
	}

	/*
	 * @Description - removes observers from the list of observers
	 * 
	 * @param - ob - observer to be removed
	 * 
	 * @return - none
	 */
	public void removeObservers(ParkingObservers ob) {
		observers.remove(ob);
	}

	/*
	 * @Description - notifies observers about parking lot status
	 * 
	 * @param - none
	 * 
	 * @return - none
	 */
	public void notifyObservers(boolean isFull) {
		for (ParkingObservers ob : observers)
			ob.update(isFull);
	}

	/*
	 * @Description - returns the list of parked cars
	 * 
	 * @param - none
	 * 
	 * @return - list of parked cars
	 */
	public List<Car> getParkedCars() {
		return parkedCars;
	}

	/*
	 * @Description - prints the list of parked cars
	 * 
	 * @param - none
	 * 
	 * @return - none
	 */
	public void printParkedCars() {
		System.out.println();
		System.out.println("Parked cars: ");
		for (Car car : parkedCars) {
			System.out.println(car.getLicensePlate());
		}
	}
}
