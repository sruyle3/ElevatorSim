package com.kuali.sim.elevator;

/** 
 * Interface to allow for simulator to use different controllers as they are implemented, with perhaps different algorithms for determining elevator to task
 * @author Ruyle
 */
public interface ElevatorController {
	
	public void requestElevator(int targetFloor, int currentFloor);
	
	public void serviceElevator(int elevatorId);
	
	
}
