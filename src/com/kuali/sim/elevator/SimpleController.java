package com.kuali.sim.elevator;

import java.util.HashMap;
import java.util.Map;

public class SimpleController implements ElevatorController, ElevatorObserver {
	Map<Integer, Elevator> elevatorsById = new HashMap<Integer, Elevator>();
	
	public SimpleController() {
		// Init elevators, fire as separate threads
		
		// Register controller as observer
		
		// Add to map 

	}
	


	@Override
	public void requestElevator(int targetFloor, int currentFloor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void serviceElevator(int elevatorId) {
		// TODO Auto-generated method stub
		
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


	
	
}
