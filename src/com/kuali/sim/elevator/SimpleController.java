package com.kuali.sim.elevator;

import java.util.HashMap;
import java.util.Map;

/** 
 * SimpleController implementation of ElevatorController to handle requests from the sim
 * @author Ruyle
 *
 */
public class SimpleController implements ElevatorController, ElevatorObserver {
	Map<Integer, Elevator> elevatorsById = new HashMap<Integer, Elevator>();
	private int numFloors;
	private int numElevators;
			
	public SimpleController() {
		
	}
	
	public void initController(int numFloors, int numElevators) {
		// Required to be able to initialize with at least 1 floor
		if (numFloors < 1) {
			throw new IllegalArgumentException("Must be at least 1 floor");
		} else {
			this.numFloors = numFloors;
		}
		
		// Init elevators, fire as separate threads
		this.numElevators = numElevators;
		
		
		
		// Register controller as observer
		
		// Add to map so can access later
		
	}
	
	public void haltController() {
		// Kill all running threads
		for (Elevator elevator : elevatorsById.values()) {
			elevator.killElevatorThread();
		}
	}
	
	@Override
	public void requestElevator(int targetFloor, int currentFloor) {
		// Validate floors
		if (targetFloor > numFloors - 1 || targetFloor < 0 || currentFloor > numFloors - 1 || currentFloor < 0) {
			throw new IllegalArgumentException("Invalid floor request " + targetFloor + " " + currentFloor);
		}
		
		// Check if someone moving up or down with floor in between 
		
		// Otherwise sort through to find closest, should be able to sort on absolute difference between Elevator.currentFloor and requestFloor		
	}

	
	
	@Override
	public void serviceElevator(int elevatorId) {
		// Validate elevatorId
		
		// Call into service the elevator
		
	}
	
	@Override
	public void observeFloorChange(int elevatorId, int currentFloor) {
		System.out.println("Elevator " + elevatorId + " at floor " + currentFloor);
		
	}

	@Override
	public void observeDoorOpen(int elevatorId) {
		System.out.println("Elevator " + elevatorId + " opened door");
		
	}

	@Override
	public void observeDoorClose(int elevatorId) {
		System.out.println("Elevator " + elevatorId + " closed door");
		
	}


	//
	public void haltElevators() {
		
	}
	
	
}
