package com.bridgelabz
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.bridgelabz.Car;
import com.bridgelabz.ParkingLot;
import com.bridgelabz.ParkingOwner;
import com.bridgelabz.ParkingObservers;
import com.bridgelabz.AirportSecurity;
import com.bridgelabz.ParkingAttendant;

class ParkingLotTest {
	ParkingLot parkingLot;
	ParkingObservers owner;
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
		owner= new ParkingOwner();// Create a parking owner
		airportSecurity = new AirportSecurity();
		parkingLot.addObservers(owner);// Add the owner to the list of observers
                parkingLot.addObservers(airportSecurity);// Add the airport security to the list of observers
		// Create two cars
		System.out.println();
		car1 = new Car("MH-12-1234", "BMW", "White");
		car2 = new Car("MH-12-1235", "Audi TT", "Goodwood Green Pearl");

		// Park the cars
		parkingLot.parkCar(car1);
		parkingLot.parkCar(car2);

	}

	/*
	 * @Description - tests the parkCar() method
	 * 
	 * @param - none
	 * 
	 * @return - none
	 */

	@Test
	void givenACar_AddToParkingLot_ReturnBoolean() {
		System.out.println("Test Park Cars");
		Car car3 = new Car("MH-12-1236", "Acura TLX Type S PMC Edition", "Gotham Gray");
		Car car4 = new Car("MH-12-1237", "Bentley’s Mulliner division", "Fine Brodgar Silver");
                parkingLot.parkCar(car3);
		parkingLot.parkCar(car4);
		assertEquals(3, parkingLot.getParkedCars().size());
		System.out.println();
	}

       @Test
	void givenACar_RemoveFromParkingLot_ReturnHome() {
		System.out.println("Test Unpark Cars");
		parkingLot.unparkCar("MH-12-1234");
                assertFalse(parkingLot.getParkedCars().contains(car1));
		assertTrue(parkingLot.getParkedCars().contains(car2));
		System.out.println();
}

	@Test
	void givenALot_CheckIfItIsFull_ReturnSign() {
		System.out.println("Test Notify Observers");
		Car car3 = new Car("MH-12-1236", "Acura TLX Type S PMC Edition", "Gotham Gray");
		Car car4 = new Car("MH-12-1237", "Bentley’s Mulliner division", "Fine Brodgar Silver");
		parkingLot.parkCar(car3);
		parkingLot.parkCar(car4);
                assertEquals("full", owner.getStatus());
		System.out.println();
		
	}
	@Test
	void givenALot_CheckIfItIsFull_ReturnRedirectOfSecurityStaff() {
		System.out.println("Test Airport Security");
		Car car3 = new Car("MH-12-1236", "Acura TLX Type S PMC Edition", "Gotham Gray");
		Car car4 = new Car("MH-12-1237", "Bentley’s Mulliner division", "Fine Brodgar Silver");
		parkingLot.parkCar(car3);
		parkingLot.parkCar(car4);
                assertEquals("full", airportSecurity.getStatus());
		System.out.println();
		}
@Test
	void givenALot_CheckIfItHasSpace_ReturnIfFullSignCanBeTaken() {
		System.out.println("Test Notify Observers");
		Car car3 = new Car("MH-12-1236", "Acura TLX Type S PMC Edition", "Gotham Gray");
		Car car4 = new Car("MH-12-1237", "Bentley’s Mulliner division", "Fine Brodgar Silver");

		parkingLot.parkCar(car3);
		parkingLot.parkCar(car4);

		assertEquals("full", owner.update(parkingLot.isFull()));
		assertEquals("full", airportSecurity.update(parkingLot.isFull()));

		System.out.println();

}
@Test
	void givenALot_ParkingAttendantToParkCars_ReturnMakeDecisionForParking() {
		System.out.println("Test Park Car by Attendant");
		Car car3 = new Car("MH-12-1236", "Acura TLX Type S PMC Edition", "Gotham Gray");
		Car car4 = new Car("MH-12-1237", "Bentley’s Mulliner division", "Fine Brodgar Silver");
		ParkingAttendant attendant = new ParkingAttendant();

		attendant.parkCar(parkingLot, car3);
		attendant.parkCar(parkingLot, car4);

		assertEquals(3, parkingLot.getParkedCars().size());
		System.out.println();
	}
@Test
	void givenALot_FindCar_ReturnDriverGoingHome() {
		System.out.println("Test Find Car");

		Car foundCar = parkingLot.findCar("MH-12-1234");
		assertNotNull(foundCar);
		assertEquals("BMW", foundCar.getBrand());
	}
}
