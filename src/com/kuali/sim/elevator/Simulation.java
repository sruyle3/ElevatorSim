package com.kuali.sim.elevator;

public class Simulation {
	
	private ElevatorController controller;
	
	public Simulation(int numElevators, int numFloors, ElevatorController controller) {
		this.controller = controller;
		controller.initController(numFloors, numElevators);
		
	}
	
	public void requestElevator(int targetFloor, int currentFloor) {
		
	}
	
	public void serviceElevator(int elevatorId) {
		
	}
	
}
