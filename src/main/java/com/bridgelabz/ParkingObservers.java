package com.bridgelabz;

/*
 * @Description -Notify the observers about parking lot status
 * 
 * @Methods - update() - notifies the observers about parking lot status
 */
public interface ParkingObservers {
	String update( boolean isFull);
}
