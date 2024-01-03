package com.bridgelabz;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.bridgelabz.Driver;
import com.bridgelabz.CarType;
import com.bridgelabz.Car;
import com.bridgelabz.ParkingAttendant;
import com.bridgelabz.ParkingLot;
import com.bridgelabz.AirportSecurity;
import com.bridgelabz.ParkingOwner;
import com.bridgelabz.ParkingObservers;

/*
 * @Description - Test cases for ParkingLot class
 * 
 * @Properties - parkingLot - object of ParkingLot class
 * 				manager - object of ParkingOwner class
 * 				car - object of Car class

 * 
 */
class ParkingLotTest {
	ParkingLot parkingLot;
	ParkingOwner owner;
	ParkingObservers airportSecurity;
	Car car1;
	Car car2;

	/*
	 * @Description - sets up the objects for testing
	 * 
	 * @param - none
	 * 
	 * @return - none
	 */
	@BeforeEach
	void setUp() throws Exception {
		parkingLot = new ParkingLot(3);// Create a parking lot with capacity 3

		// Create two cars
		System.out.println();
		car1 = new Car("WB-12-1234", "BMW", "White", CarType.SMALL);
		car2 = new Car("WB-12-1235", "Audi TT", "Goodwood Green Pearl", CarType.SMALL);

		// Park the cars
		parkingLot.parkCar(car1, Driver.Handicapped);
		parkingLot.parkCar(car2, Driver.Non_HandiCapped);

	}

	// tests the parkCar() method
	
	@Test
	void  givenACar_AddToParkingLot_ReturnBoolean() {
		System.out.println("Test Park Cars");
		Car car3 = new Car("WB-12-1236", "Acura TLX Type S PMC Edition", "Gotham Gray", CarType.SMALL);
		Car car4 = new Car("WB-12-1237", "Bentley’s Mulliner division", "Fine Brodgar Silver", CarType.SMALL);

		parkingLot.parkCar(car3, Driver.Handicapped);
		parkingLot.parkCar(car4, Driver.Non_HandiCapped);
		assertEquals(3, parkingLot.getParkedCars().size());
		System.out.println();
	}

	 //tests the unparkCar() method
	
	@Test
	void givenACar_RemoveFromParkingLot_ReturnHome() {
		System.out.println("Test Unpark Cars");
		parkingLot.unparkCar("WB-12-1234");

		assertFalse(parkingLot.getParkedCars().contains(car1));
		assertTrue(parkingLot.getParkedCars().contains(car2));
		System.out.println();
	}

	// tests the notifyObservers() method
	 
	@Test
	void givenALot_CheckIfItIsFull_ReturnSign() {
		owner = new ParkingOwner();
		airportSecurity = new AirportSecurity();
		
		parkingLot.addObservers(owner);
		parkingLot.addObservers(airportSecurity);
		
		System.out.println("Test Notify Observers");
		Car car3 = new Car("WB-12-1236", "Acura TLX Type S PMC Edition", "Gotham Gray", CarType.SMALL);
		Car car4 = new Car("WB-12-1237", "Bentley’s Mulliner division", "Fine Brodgar Silver", CarType.SMALL);

		parkingLot.parkCar(car3, Driver.Handicapped);
		parkingLot.parkCar(car4, Driver.Non_HandiCapped);

		assertEquals("full", owner.update(parkingLot.isFull()));
		assertEquals("full",airportSecurity.update(parkingLot.isFull()));

		System.out.println();

	}

	// tests the parkCar() method by attendant
	
	@Test
	void givenALot_ParkingAttendantToParkCars_ReturnMakeDecisionForParking() {
		System.out.println("Test Park Car by Attendant");
		Car car3 = new Car("WB-12-1236", "Acura TLX Type S PMC Edition", "Gotham Gray", CarType.SMALL);
		Car car4 = new Car("WB-12-1237", "Bentley’s Mulliner division", "Fine Brodgar Silver", CarType.MEDIUM);
		ParkingAttendant attendant = new ParkingAttendant();

		attendant.parkCar(parkingLot, car3, Driver.Handicapped);
		attendant.parkCar(parkingLot, car4, Driver.Non_HandiCapped);

		assertEquals(3, parkingLot.getParkedCars().size());
		System.out.println();
	}

	// tests the findCar() method using license plate
	 
	@Test
	void givenALot_FindCar_ReturnDriverGoingHome() {
		System.out.println("Test Find Car");

		Car foundCar = parkingLot.findCar("WB-12-1234");
		assertNotNull(foundCar);
		assertEquals("BMW", foundCar.getBrand());
	}

	// tests the chargeParking() method
	
	@Test
	void givenALot_CalculateTime_ReturnCharge() {
		owner = new ParkingOwner();
		parkingLot.addObservers(owner);
		System.out.println("Test Charge Parking");

		parkingLot.parkCar(car2, Driver.Non_HandiCapped);
		parkingLot.unparkCar("WB-12-1235");

		assertEquals(20, owner.chargeParking(car2));
		System.out.println();

	}

@Test
    void givenALot_DirectCars_ReturnEvenDistribution() {
	    System.out.println("Test even distribution");
        // Create parking lots
        ParkingLot lot1 = new ParkingLot(5);
        ParkingLot lot2 = new ParkingLot(5);

        // Create a list of parking lots
        ParkingAttendant parkingAttendant = new ParkingAttendant(lot1, lot2);

        // Park 10 cars (5 in each lot)
        for (int i = 0; i < 10; i++) {
            parkingAttendant.directCar();
        }

        // Check if each parking lot has an even distribution
        assertTrue(Math.abs(lot1.getOccupiedSpots() - lot2.getOccupiedSpots()) <= 1,
                "Parking lots do not have an even distribution");
    }

    @Test
    void givenALot_AttendantToParkCar_ReturnParkInNearestFreeSpace() {
        // Create parking lots
        ParkingLot lot1 = new ParkingLot(5);
        ParkingLot lot2 = new ParkingLot(5);

        // Create a list of parking lots
        ParkingAttendant parkingAttendant = new ParkingAttendant(lot1, lot2);

        // Park 5 cars in lot1
        for (int i = 0; i < 5; i++) {
            parkingAttendant.directCarToNearestSpot();
        }

        // Create a handicap driver and park their car
        parkingAttendant.directCarToNearestSpot();

        // Ensure the handicap driver's car is parked in the lot with the nearest available spot
        assertEquals(1, lot2.getOccupiedSpots(), "Handicap driver's car should be parked in the nearest available spot.");
    }
}
