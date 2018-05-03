package org.usfirst.frc.team2996.robot;

import edu.wpi.first.wpilibj.Talon;

public class Claws {

	public enum ClawsStates {
		NOT_MOVING, GOING_UP, GOING_DOWN
	}
	
	ClawsStates currentClawsState = ClawsStates.NOT_MOVING;
	
	private Talon clawsMotor;
	
	public Claws() {
		clawsMotor = new Talon(Constants.CLAWS_MOTOR_ID);
	}
	
	public void claws(boolean clawsUpBumper, boolean clawsDownBumper) {
		switch(currentClawsState) {
		case NOT_MOVING:
			if (clawsUpBumper && !clawsDownBumper) {
				clawsMotor.set(1);
				currentClawsState = ClawsStates.GOING_UP;
			} else if (!clawsUpBumper && clawsDownBumper) {
				clawsMotor.set(-1);
				currentClawsState = ClawsStates.GOING_DOWN;
			}
			break;
		case GOING_UP:
		case GOING_DOWN:
			if (!clawsUpBumper && !clawsDownBumper) {
				clawsMotor.set(0);
				currentClawsState = ClawsStates.NOT_MOVING;
			}
			break;
		}
	}
}
