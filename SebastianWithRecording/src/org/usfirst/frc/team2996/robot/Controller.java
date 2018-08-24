package org.usfirst.frc.team2996.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Controller {

	private Joystick controller;
	private boolean shooterBumper;
	private double chainTrigger;
	private boolean clawsUpBumper;
	private double clawsDownTrigger;
	private double driveForwardAxis;
	private double driveTurnAxis;
	
	public Controller() {
		controller = new Joystick(Constants.CONTROLLER_PORT);
	}
	
	public void setControllerInputValues() {
		shooterBumper = controller.getRawButton(Constants.SHOOTER_BUMPER);
		chainTrigger = controller.getRawAxis(Constants.CHAIN_TRIGGER);
		clawsUpBumper = controller.getRawButton(Constants.CLAWS_UP_BUMPER);
		clawsDownTrigger = controller.getRawAxis(Constants.CLAWS_DOWN_TRIGGER);
		driveForwardAxis = controller.getRawAxis(Constants.DRIVE_FORWARD_AXIS);
		driveTurnAxis = controller.getRawAxis(Constants.DRIVE_TURN_AXIS);
	}
	
	public boolean isShooterBumper() {
		return shooterBumper;
	}

	public double getChainTrigger() {
		return chainTrigger;
	}
	
	public boolean isClawsUpBumper() {
		return clawsUpBumper;
	}

	public double getClawsDownTrigger() {
		return clawsDownTrigger;
	}
	
	public double getDriveForwardAxis() {
		return driveForwardAxis;
	}

	public double getDriveTurnAxis() {
		return driveTurnAxis;
	}
}
