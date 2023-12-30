package com.bridgelabz;

public class ParkingAttendant {
	private List<ParkingLot> parkingLots;

    public ParkingAttendant(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
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
	Parking cars for handicapped in nearest space

}
