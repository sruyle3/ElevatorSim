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
	final int topFloor;
	boolean hasPassenger = false;
	ElevatorMode currentMode = ElevatorMode.OPERATIONAL;
	
	// Keep list of observers
	List<ElevatorObserver> observers = new ArrayList<ElevatorObserver>();
	
	/** 
	 * @param topFloor Should be number of floors - 1
	 */
	public Elevator(int topFloor) {
		this.topFloor = topFloor;
	}
	
	public void move(int targetFloor) {
		if (targetFloor > topFloor) {
			throw new IllegalArgumentException("Can't shoot through the roof like in Willy Wonka!");
		}
		
		if (targetFloor < 0) {
			throw new IllegalArgumentException("Can't drill into the earth core!");
		}
		
		
		
		
		// Increment numTrips and Check if go into maintenance mode
		if (++numTrips == 100) {
			this.currentMode = ElevatorMode.MAINTENANCE;
		}
	}
	
	// Returns current floor after move, assumes caller handles maxFloor check
	private int moveUp() {
		return ++currentFloor;
	}
	
	private int moveDown() {
		return --currentFloor;
	}
	
	// Fix the elevator back to operational status
	public void serviceElevator() {
		this.currentMode = ElevatorMode.OPERATIONAL;
	}
	
	// Simplifying assumption that have no requirement to stop observing
	public void addObserver(ElevatorObserver observer) {
		this.observers.add(observer);
	}
	
	public boolean hasPassenger() {
		return hasPassenger;
	}
	
	public boolean isAvailable() {
		return currentMode == ElevatorMode.OPERATIONAL && !hasPassenger;
	}
}
