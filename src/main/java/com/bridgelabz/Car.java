package com.bridgelabz;
public class Car {

	private String licensePlate;
	private String brand;
	private String color;

	public Car(String licensePlate, String brand, String color) {
		this.licensePlate = licensePlate;
		this.brand = brand;
		this.color = color;
	}

	public String getLicensePlate() {
		return licensePlate;
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
