package com.kuali.sim.elevator;

import java.util.ArrayList;
import java.util.List;

public class Elevator {

	enum ElevatorMode {
		MAINTENANCE, OPERATIONAL;
	}
	
	int numTrips = 0;
	// Let's label floors starting at zero like in Europe
	int currentFloor = 0; 
	boolean hasPassenger = false;
	ElevatorMode currentMode = ElevatorMode.OPERATIONAL;
	
	// Keep list of observers
	List<ElevatorObserver> observers = new ArrayList<ElevatorObserver>();
	
	public Elevator() {
		// Placeholder for now
	}
	
	public boolean hasPassenger() {
		return hasPassenger;
	}
	
	public boolean isAvailable() {
		return currentMode == ElevatorMode.OPERATIONAL && !hasPassenger;
	}
}
