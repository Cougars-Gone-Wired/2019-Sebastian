package org.usfirst.frc.team2996.robot;

import java.util.ArrayList;
import java.util.List;

public class StateRecorder {

	List<State> states;

	public void initialize() {
		states = new ArrayList<>();
	}
	
	public void record(Controller controller) {
		State s = new State();
		
		s.setShooterBumperState(controller.isShooterBumper());
		s.setChainTriggerState(controller.getChainTrigger());
		s.setClawsUpBumperState(controller.isClawsUpBumper());
		s.setClawsDownTriggerState(controller.getClawsDownTrigger());
		s.setDriveForwardAxisState(controller.getDriveForwardAxis());
		s.setDriveTurnAxisState(controller.getDriveTurnAxis());
		
		states.add(s);
	}

	public List<State> getStates() {
		return states;
	}
}
