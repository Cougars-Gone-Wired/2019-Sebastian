package org.usfirst.frc.team2996.robot;

import edu.wpi.first.wpilibj.Talon;

public class Chain {

	private Talon chainMotor;
	
	public Chain() {
		chainMotor = new Talon(Constants.CHAIN_MOTOR_PORT);
	}
	
	public enum ChainStates {
		NOT_MOVING, MOVING_FORWARD
	}
	
	ChainStates currentChainState = ChainStates.NOT_MOVING;
	
	public void chain(double chainTrigger) {
		switch(currentChainState) {
		case NOT_MOVING:
			if (chainTrigger >= 0.15) {
				chainMotor.set(1);
				currentChainState = ChainStates.MOVING_FORWARD;
			}
			break;
		case MOVING_FORWARD:
			if (chainTrigger < 0.15) {
				chainMotor.set(0);
				currentChainState = ChainStates.NOT_MOVING;
			}
			break;
		}
	}
}
