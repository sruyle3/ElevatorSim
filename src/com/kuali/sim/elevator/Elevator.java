package com.kuali.sim.elevator;

import java.util.ArrayList;
import java.util.List;

public class Elevator {

	enum ElevatorMode {
		MAINTENANCE, OPERATIONAL;
	}
	
	final int elevatorId; 
	int numTrips = 0;
	// Let's label floors starting at zero like in Europe
	int currentFloor = 0;
	final int topFloor;
	boolean hasPassenger = false;
	boolean doorOpen = false;
	ElevatorMode currentMode = ElevatorMode.OPERATIONAL;
	
	// Keep list of observers
	List<ElevatorObserver> observers = new ArrayList<ElevatorObserver>();
	
	/** 
	 * @param id Unique identifer for specific elevator
	 * @param topFloor Should be number of floors - 1
	 */
	public Elevator(int id, int topFloor) {
		this.elevatorId = id;
		this.topFloor = topFloor;
	}
	
	public void move(int targetFloor) {
		if (targetFloor > topFloor) {
			throw new IllegalArgumentException("Can't shoot through the roof like in Willy Wonka!");
		}
		
		if (targetFloor < 0) {
			throw new IllegalArgumentException("Can't drill into the earth core!");
		}
		
		// Move up or down until reach target floor
		boolean movingUp = (targetFloor > currentFloor);
		while (currentFloor != targetFloor) {
			doMove(movingUp);
		}
		
		// Increment numTrips and Check if go into maintenance mode
		if (++numTrips == 100) {
			this.currentMode = ElevatorMode.MAINTENANCE;
		}
	}
	
	/** 
	 * Allow controller to call letPassengerOn when elevator reaches floor
	 */
	public void letPassengerOn() {
		this.reportDoorOpen();
		
		// Assuming that for the sim pause for 1 second for action
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("LOGGING: Failed to sleep letting passenger on");
		}
		
		this.reportDoorClose();
		this.hasPassenger = true;
	}
	
	/**
	 * Allow controller to call letPassengerOff when elevator reaches floor
	 */
	public void letPassengerOff() {
		this.reportDoorOpen();
		
		// Assuming that for the sim pause for 1 second for action
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("LOGGING: Failed to sleep letting passenger off");
		}
		
		this.reportDoorClose();
		this.hasPassenger = false;
	}
	
	private int doMove(boolean up) {
		// Assuming that for the sim pause for 1 second for action
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("LOGGING: Failed to sleep between floors");
		}
		
		if (up) {
			++currentFloor;
		} else {
			--currentFloor;
		}
		
		this.reportMove(currentFloor);
		
		return currentFloor;
	}
	
	private void reportMove(int currentFloor) {
		// Tell everyone watching us we moved
		for (ElevatorObserver obs : this.observers) {
			obs.observeFloorChange(this.elevatorId, currentFloor);
		}
	}
	
	// Tell everyone watching us we opened the door
	private void reportDoorOpen() {
		for (ElevatorObserver obs : this.observers) {
			obs.observeDoorOpen(this.elevatorId);
		}
	}
	
	// Tell everyone watching us we closed the door
	private void reportDoorClose() {
		for (ElevatorObserver obs : this.observers) {
			obs.observeDoorOpen(this.elevatorId);
		}
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
