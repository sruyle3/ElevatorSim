package com.kuali.sim.elevator;

/** 
 * Interface to allow for simulator to use different controllers as they are implemented, with perhaps different algorithms for determining elevator to task
 * @author Ruyle
 */
public interface ElevatorController {
	
	/**
	 * Initialize a controller instance
	 */
	public void initController(int numFloors, int numElevators);
	
	/** 
	 * Stop the controller, supports end of simulation to stop running threads
	 */
	public void haltController();
	
	/** 
	 * @param targetFloor Floor passenger going to, European style so ground level floor is 0
	 * @param currentFloor Floor passenger on, European style so ground level floor is 0
	 */
	public void requestElevator(int targetFloor, int currentFloor);
	
	/** 
	 * Service an elevator for maintenance
	 * @param elevatorId
	 */
	public void serviceElevator(int elevatorId);
	
	
	
	
}
