package com.kuali.sim.elevator;

public class Simulation {
	private int numElevators;
	private int numFloors;
	
	public Simulation(int numElevators, int numFloors) {
		this.numElevators = numElevators;
		
		// Required to be able to initialize with at least 1 floor
		if (numFloors < 1) {
			throw new IllegalArgumentException("Must be at least 1 floor");
		} else {
			this.numFloors = numFloors;
		}
		
	}
	
	public void requestElevator(int targetFloor, int currentFloor) {
		if (targetFloor > numFloors - 1 || targetFloor < 0 || currentFloor > numFloors - 1 || currentFloor < 0) {
			throw new IllegalArgumentException("Invalid floor request " + targetFloor + " " + currentFloor);
		}
	}
	
	public void serviceElevator(int elevatorId) {
		
	}
	
}
