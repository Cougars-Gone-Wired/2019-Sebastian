package org.usfirst.frc.team2996.robot;

import edu.wpi.first.wpilibj.Talon;

public class Shooter {

	public enum ShooterStates {
		NOT_MOVING, SPINNING
	}
	
	ShooterStates currentShooterState = ShooterStates.NOT_MOVING;
	
	private Talon shooterMotor;
	
	public Shooter() {
		shooterMotor = new Talon(Constants.SHOOTER_MOTOR_PORT);
	}
	
	public void shooter(boolean shooterButton) {
		switch(currentShooterState) {
		case NOT_MOVING:
			if (shooterButton) {
				shooterMotor.set(Constants.SHOOTER_SPEED);
				currentShooterState = ShooterStates.SPINNING;
			}
			break;
		case SPINNING:
			if (!shooterButton) {
				shooterMotor.set(0);
				currentShooterState = ShooterStates.NOT_MOVING;
			}
			break;
		}
	}
}
