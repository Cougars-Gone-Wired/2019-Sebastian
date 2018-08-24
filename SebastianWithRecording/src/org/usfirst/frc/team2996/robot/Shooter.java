package org.usfirst.frc.team2996.robot;

import edu.wpi.first.wpilibj.Talon;

public class Shooter {
	
	private Talon shooterMotor;
	
	public Shooter() {
		shooterMotor = new Talon(Constants.SHOOTER_MOTOR_PORT);
	}
	
	public enum ShooterStates {
		NOT_MOVING, SPINNING
	}
	
	ShooterStates currentShooterState = ShooterStates.NOT_MOVING;
	
	public void shooter(boolean shooterBumper) {
		switch(currentShooterState) {
		case NOT_MOVING:
			if (shooterBumper) {
				shooterMotor.set(Constants.SHOOTER_SPEED);
				currentShooterState = ShooterStates.SPINNING;
			}
			break;
		case SPINNING:
			if (!shooterBumper) {
				shooterMotor.set(0);
				currentShooterState = ShooterStates.NOT_MOVING;
			}
			break;
		}
	}
}
