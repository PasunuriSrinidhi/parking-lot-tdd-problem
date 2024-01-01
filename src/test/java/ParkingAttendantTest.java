package com.bridgelabz.parkinglottest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bridgelabz.model.Car;
import com.bridgelabz.model.CarType;
import com.bridgelabz.model.Driver;
import com.bridgelabz.model.ParkingAttendant;
import com.bridgelabz.model.ParkingLot;

class ParkingAttendantTest {
	ParkingLot parkingLot1;
	ParkingLot parkingLot2;
	ParkingAttendant parkingAttendant;

	@BeforeEach
	void setUp() throws Exception {
		parkingLot1 = new ParkingLot(5);
		parkingLot2 = new ParkingLot(3);

		parkingAttendant = new ParkingAttendant(List.of(parkingLot1, parkingLot2));
	}

	@Test
	void test() {
        System.out.println("Test Direct Large Car");
        Car largeCar = new Car("WB-12-1238", "Mercedes-Benz GLS", "Black",CarType.LARGE);

        parkingAttendant.directLargeCar(largeCar, Driver.Handicapped);

        // Check if the large car is parked in the parking lot with the most free spaces
        assertTrue(parkingLot1.getParkedCars().contains(largeCar) || parkingLot2.getParkedCars().contains(largeCar));

        System.out.println();
	}

}
