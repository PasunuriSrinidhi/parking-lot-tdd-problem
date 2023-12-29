package com.bridgelabz;
import java.time.LocalTime;
public class Car {

	private String licensePlate;
	private String brand;
	private String color;
	private LocalTime parktime;
	private LocalTime unparktime;

	public Car(String licensePlate, String brand, String color) {
		this.licensePlate = licensePlate;
		this.brand = brand;
		this.color = color;
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

}
