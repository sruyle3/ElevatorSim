package com.kuali.sim.elevator;
/**
 * Implementation of observer pattern for subscription to elevator actions or changes
 */
public interface ElevatorObserver {

	public void observeFloorChange(int elevatorId, int currentFloor);
	
	public void observeDoorOpen(int elevatorId);
	
	public void observeDoorClose(int elevatorId);
	
}
