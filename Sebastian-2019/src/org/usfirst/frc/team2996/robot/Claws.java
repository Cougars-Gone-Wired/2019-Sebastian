package org.usfirst.frc.team2996.robot;

import edu.wpi.first.wpilibj.Talon;

public class Claws {
	
	private Talon clawsMotor;
	
	public Claws() {
		clawsMotor = new Talon(Constants.CLAWS_MOTOR_PORT);
	}
	
	public enum ClawsStates {
		NOT_MOVING, GOING_UP, GOING_DOWN
	}
	
	ClawsStates currentClawsState = ClawsStates.NOT_MOVING;
	
	public void claws(boolean clawsUpBumper, double clawsDownTrigger) {
		switch(currentClawsState) {
		case NOT_MOVING:
			if (clawsUpBumper && clawsDownTrigger < 0.15) {
				clawsMotor.set(1);
				currentClawsState = ClawsStates.GOING_UP;
			} else if (!clawsUpBumper && clawsDownTrigger >= 0.15) {
				clawsMotor.set(-1);
				currentClawsState = ClawsStates.GOING_DOWN;
			}
			break;
		case GOING_UP:
		case GOING_DOWN:
			if (!clawsUpBumper && clawsDownTrigger < 0.15) {
				clawsMotor.set(0);
				currentClawsState = ClawsStates.NOT_MOVING;
			}
			break;
		}
	}
}
