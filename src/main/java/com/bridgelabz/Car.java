package com.bridgelabz;
import java.time.LocalTime;

public class Car {

	private String licensePlate;
	private String brand;
	private String color;
	private LocalTime parktime;
	private LocalTime unparktime;
	private CarType size;

	public Car(String licensePlate, String brand, String color,CarType size) {
		this.licensePlate = licensePlate;
		this.brand = brand;
		this.color = color;
		this.size= size;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public LocalTime getParkTime() {
		return parktime;
	}

	public LocalTime getUnparkTime() {
		return unparktime;
	}

	public void setParktime(LocalTime parktime) {
		this.parktime = parktime;
	}

	public void setUnparktime(LocalTime unparktime) {
		this.unparktime = unparktime;
	}

	public String getBrand() {
		return brand;
	}

	public String getColor() {
		return color;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setColor(String color) {
		this.color = color;
	}

       public CarType getSize() {
		return size;
	}

	public void setSize(CarType size) {
		this.size = size;
	}
}
