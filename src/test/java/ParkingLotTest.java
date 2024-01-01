package com.bridgelabz.parkinglottest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.bridgelabz.Car;
import com.bridgelabz.CarType;
import com.bridgelabz.Driver;
import com.bridgelabz.ParkingLot;
import com.bridgelabz.ParkingOwner;
import com.bridgelabz.ParkingObservers;
import com.bridgelabz.AirportSecurity;
import com.bridgelabz.ParkingAttendant;
import com.bridgelabz.CarParkingSystem;

class ParkingLotTest {
	PoliceDepartment policeDepartment;
	ParkingLot parkingLot1;
	ParkingLot parkingLot2;
	ParkingAttendant parkingAttendant;
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
		parkingLot1 = new ParkingLot(5);
		parkingLot2 = new ParkingLot(3);

		parkingAttendant = new ParkingAttendant(List.of(parkingLot1, parkingLot2), "Grayson");
		policeDepartment = new PoliceDepartment(parkingAttendant);
	}
        /*
	 * @Description - tests the large car parking method
	 * 
	 * @param - none
	 * 
	 * @return - none
	 */
	@Test
	void givenALot_DirectLargeCars_ReturnHighestFreeSpace() {
		System.out.println("Test Direct Large Car");
		Car largeCar = new Car("WB-12-1238", "Mercedes-Benz GLS", "Black", CarType.LARGE);

		parkingAttendant.directLargeCar(largeCar, Driver.Handicapped);

		assertTrue(parkingLot1.getParkedCars().contains(largeCar) || parkingLot2.getParkedCars().contains(largeCar));

		System.out.println();
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
        @Test
	void givenALot_CalculateTime_ReturnCharge() {
		System.out.println("Test Charge Parking");

		parkingLot.parkCar(car2);
		parkingLot.unparkCar("WB-12-1235");

		assertEquals(20, manager.chargeParking(car2));
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
	

    @Test
    public void givenALot_PoliceWantsWhiteCarsLocation_ReturnInvestigateOfBombThreat() {
       System.out.println("Test Get Location of Parked White Cars");
		Car whiteCar1 = new Car("WB-12-1234", "Toyota", "White", CarType.SMALL);
		Car whiteCar2 = new Car("WB-12-5678", "Honda", "White", CarType.LARGE);

		parkingLot1.parkCar(whiteCar1, Driver.Handicapped);
		parkingLot2.parkCar(whiteCar2, Driver.Non_HandiCapped);

		List<String> locations = policeDepartment.getLocationOfParkedColorCars("White");

		assertTrue(locations.contains("Parking Lot " + parkingLot1.hashCode()));
		assertTrue(locations.contains("Parking Lot " + parkingLot2.hashCode()));

		assertEquals(2, locations.size());

		System.out.println();
	}

    
  @Test
	void givenALot_GetLocationOfParkedBlueToyotaCars_ReturnInvestigateOfRobberyCase() {
		System.out.println("Test Get Location of Parked Blue Toyota Cars");
		Car blueToyotaCar1 = new Car("WB-12-1234", "Toyota", "Blue", CarType.SMALL);
		Car blueToyotaCar2 = new Car("WB-12-5678", "Toyota", "Blue", CarType.LARGE);

		parkingLot1.parkCar(blueToyotaCar1, Driver.Handicapped);
		parkingLot2.parkCar(blueToyotaCar2, Driver.Non_HandiCapped);

		List<String> locations = policeDepartment.getLocationOfParkedColorAndBrandCars("Blue", "Toyota");

		assertTrue(locations.contains(parkingAttendant.parkingAttendantName + " Parking Lot " + parkingLot1.hashCode()));
		assertTrue(locations.contains(parkingAttendant.parkingAttendantName + " Parking Lot " + parkingLot2.hashCode()));

		assertEquals(2, locations.size());

		System.out.println();
	}

	@Test
	void givenALot_GetLocationOfBMW_ReturnSecurityIncrease) {
		System.out.println("Test Get Location of Parked BMW Cars");

		Car bmwCar1 = new Car("WB-12-1234", "BMW", "White", CarType.SMALL);
		Car bmwCar2 = new Car("WB-12-5678", "BMW", "Blue", CarType.MEDIUM);

		parkingLot1.parkCar(bmwCar1, Driver.Handicapped);
		parkingLot2.parkCar(bmwCar2, Driver.Non_HandiCapped);

		List<String> locations = policeDepartment.getLocationOfParkedBrandCars("BMW");

		assertEquals(2, locations.size());
		assertTrue(locations.contains("Parking Lot " + parkingLot1.hashCode() + ", License Plate: " + bmwCar1.getLicensePlate()));
		assertTrue(locations.contains("Parking Lot " + parkingLot2.hashCode() + ", License Plate: " + bmwCar2.getLicensePlate()));

	}
}
