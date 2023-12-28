package com.bridgelabz.observers;

/*
 * @Description -Notify the owner about parking lot status
 * 
 * @Methods - update() - notifies the owner about parking lot status
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
	public void update() {
		System.out
				.println("Dear Owner " + "the Parking Space is full. " + "Kindly put out the PARKING LOT FULL Sign ");
	}

	public String getStatus() {
		return "full";
	}

}
