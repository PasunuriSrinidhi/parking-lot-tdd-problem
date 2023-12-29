package com.bridgelabz;

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

}
