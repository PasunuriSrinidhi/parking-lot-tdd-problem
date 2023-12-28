package com.bridgelabz.observers;

/*
 * @Description -Notify the observers about parking lot status
 * 
 * @Methods - update() - notifies the observers about parking lot status
 */
public interface ParkingObservers {
	void update();

	String getStatus();
}
