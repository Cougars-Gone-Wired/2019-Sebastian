package org.usfirst.frc.team2996.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Controller {

	private Joystick controller;
	private boolean shooterButton;
	private double chainTrigger;
	private boolean clawsUpBumper;
	private boolean clawsDownBumper;
	private double driveForwardAxis;
	private double driveTurnAxis;
	
	public Controller() {
		controller = new Joystick(Constants.CONTROLLER_PORT);
	}
	
	public void setControllerInputValues() {
		shooterButton = controller.getRawButton(Constants.SHOOTER_BUTTON);
		chainTrigger = controller.getRawAxis(Constants.CHAIN_TRIGGER);
		clawsUpBumper = controller.getRawButton(Constants.CLAWS_UP_BUMPER);
		clawsDownBumper = controller.getRawButton(Constants.CLAWS_DOWN_BUMBER);
		driveForwardAxis = controller.getRawAxis(Constants.DRIVE_FORWARD_AXIS);
		driveTurnAxis = controller.getRawAxis(Constants.DRIVE_TURN_AXIS);
	}
	
	public boolean isShooterButton() {
		return shooterButton;
	}

	public double getChainTrigger() {
		return chainTrigger;
	}
	
	public boolean isClawsUpBumper() {
		return clawsUpBumper;
	}

	public boolean isClawsDownBumper() {
		return clawsDownBumper;
	}
	
	public double getDriveForwardAxis() {
		return driveForwardAxis;
	}

	public double getDriveTurnAxis() {
		return driveTurnAxis;
	}
}
