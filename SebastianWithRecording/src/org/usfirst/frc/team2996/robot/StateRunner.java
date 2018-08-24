package org.usfirst.frc.team2996.robot;

import java.util.List;

public class StateRunner {

	private Shooter shooter;
	private Chain chain;
	private Claws claws;
	private Drive drive;
	
	List<State> states;
	
	int counter = 0;

	public StateRunner(Robot robot) {
		this.shooter = robot.getShooter();
		this.chain = robot.getChain();
		this.claws = robot.getClaws();
		this.drive = robot.getDrive();
	}

	public void counterInitialize() {
		counter = 0;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public void run() {
		if (counter < states.size()) {
			State s = states.get(counter);
			
			shooter.shooter(s.isShooterBumperState());
			chain.chain(s.getChainTriggerState());
			claws.claws(s.isClawsUpBumperState(), s.getClawsDownTriggerState());
			drive.arcadeDrive(s.getDriveForwardAxisState(), s.getDriveTurnAxisState());
			
			counter++;
		}
	}
}
