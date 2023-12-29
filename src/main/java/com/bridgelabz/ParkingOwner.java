package com.bridgelabz;
import com.bridgelabz.model.Car;

/*
 * @Description -Notify the manager about parking lot status
 * 
 * @Methods - update() - notifies the manager about parking lot status
 * 
 */
public class ParkingOwner implements ParkingObservers {
        @Override

	/*
	 * @Description - Update the owner about parking lot status
	 * 
	 * @param - none
	 * 
	 * @return - none
	 */
	public String update(boolean isFull) {
		if (isFull) {
			System.out.println("Dear Owner " + "the Parking Space is full. " + "Kindly put out the PARKING LOT FULL Sign ");
                        return "full";
		} else {
			System.out.println("Dear Owner" + "the Parking Space is not full. " + "Kindly put out the PARKING LOT FULL Sign ");
			return "not full";

		}
	}

/*
	 * @Description - returns the charge for parking
	 * 
	 * @param - Car object
	 * 
	 * @return - charge for parking
	 */
	public double chargeParking(Car car) {
		double charge = 0;
		int time = car.getUnparkTime().getHour() - (car.getParkTime().getHour());
		System.out.println("Parking Time: " + car.getParkTime()+ " " + car.getUnparkTime());
		if (time <= 1) {
			charge = 20;
		} else {
			charge = 20 + (time - 1) * 10;
		}
		return charge;
	}

}
