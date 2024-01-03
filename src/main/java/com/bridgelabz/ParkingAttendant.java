package com.bridgelabz;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.bridgelabz.Driver;
import com.bridgelabz.CarType;

public class ParkingAttendant {
	List<ParkingLot> parkingLots = new ArrayList<>();
	public String parkingAttendantName;
        
	public ParkingAttendant(List<ParkingLot> parkingLots,String parkingAttendantName) {
        this.parkingLots = new ArrayList<>(parkingLots);
	this.parkingAttendantName = parkingAttendantName;
    }
    public ParkingAttendant() {
		// TODO Auto-generated constructor stub
	}

    public void directCar() {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasAvailableSpot()) {
                parkingLot.parkCar();
                return;
            }
        }
        System.out.println("All parking lots are full. Unable to park car.");
    }

   public void directCarToNearestSpot() {
        ParkingLot nearestLot = parkingLots.stream()
                .filter(ParkingLot::hasAvailableSpot)
                .min(Comparator.comparingInt(ParkingLot::getFreeSpots))
                .orElse(null);

        if (nearestLot != null) {
            nearestLot.parkCar();
            System.out.println("Car parked in the nearest available spot.");
        } else {
            System.out.println("All parking lots are full. Unable to park car.");
        }
    }

	/*
	 * @Description - parks the car in the parking lot
	 * 
	 * @param - car - car to be parked
	 * 
	 * @return - none
	 */
	public void parkCar(ParkingLot parklot, Car car,  Driver driver) {

		parklot.parkCar(car,driver);

	}
	public List<String> getLocationOfParkedCarsbyColor(String color) {
		List<String> locations = new ArrayList<>();
		for (ParkingLot parkingLot : parkingLots) {
			locations.addAll(parkingLot.getLocationOfParkedbyColor(color));
		}
		return locations;
	}
	

	public List<String> getLocationOfParkedCarsbyBrandAndColor(String color,String brand) {
		List<String> locations = new ArrayList<>();
		for (ParkingLot parkingLot : parkingLots) {
			locations.addAll(parkingLot.getLocationOfParkedbyColorAndBrand(color,brand) );
		}
		return locations;
	}
	public List<String> getLocationOfParkedCarsByBrand(String brand) {
		List<String> locations = new ArrayList<>();
		for (ParkingLot parkingLot : parkingLots) {
			locations.addAll(parkingLot.getLocationOfParkedCarsByBrand(brand));
		}
		return locations;
	}

	public void directLargeCar(Car car, Driver driver) {

		ParkingLot selectedParkingLot = parkingLots.stream()
				.max(Comparator.comparingInt(ParkingLot::getFreeSpaces))
				.orElse(null);

		if (selectedParkingLot != null) {
			parkCar(selectedParkingLot, car, driver);
			System.out.println("Large car directed to Parking Lot with capacity " + selectedParkingLot.capacity);
		} else {
			System.out.println("No suitable parking lot found for the large car.");
		}
	}
public List<String> carsParkedLast30Minutes() {
		List<String> carsParkedLast30Minutes = new ArrayList<>();
		LocalTime currentTime = LocalTime.now();

		for (ParkingLot parkingLot : parkingLots) {
			for (Car car : parkingLot.getParkedCars()) {
				if (Duration.between(car.getParkTime(), currentTime).toMinutes() <= 30) {
					carsParkedLast30Minutes
							.add("License Plate: " + car.getLicensePlate() + ", Parking Lot: " + parkingLot.hashCode());
				}
			}
		}

		return carsParkedLast30Minutes;
	}
/*
	 * @Description - waits for the given number of minutes
	 * 
	 * @param - minutes - number of minutes to wait
	 * 
	 * @return - none
	 */
	public void waitMinutes(int minutes) {
		try {
			Thread.sleep(minutes * 60 * 1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	/*
	 * @Description - gets the small cars parked on rows B and D
	 * 
	 * @param - none
	 * 
	 * @return - list of small cars parked on rows B and D
	 */
	public List<String> getSmallHandicapCarsOnRowsBorD() {
		List<String> result = new ArrayList<>();

		for (ParkingLot parkingLot : parkingLots) {
			for (Car car : parkingLot.getParkedCars()) {
				if (car.getSize() == CarType.SMALL
						&& (car.getCarRow().charAt(0) == 'B' || car.getCarRow().charAt(0) == 'D')) {
					result.add("Parking Lot: " + parkingLot.hashCode() + ", License Plate: " + car.getLicensePlate());
				}
			}

		}
		return result;
	}
	private static void showAllParkedCars(ParkingLot lot) {
        System.out.println("Police Investigation: All Parked Cars in " + lot.getLotId());
        List<String> parkedCarDetails = lot.getAllParkedCarsInfo();
        parkedCarDetails.forEach(System.out::println);
    }
}



	


