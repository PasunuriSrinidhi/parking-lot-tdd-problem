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

}
