package org.usfirst.frc.team2996.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Controller {

	private Joystick controller;
	private boolean shooterButton;
	private double chainTrigger;
	private double driveForwardAxis;
	private double driveTurnAxis;
	private boolean clawsUpBumper;
	private boolean clawsDownBumper;
	
	public Controller() {
		controller = new Joystick(Constants.CONTROLLER_PORT);
	}
	
	public void setJoystickInputValues() {
		driveForwardAxis = controller.getRawAxis(Constants.DRIVE_FORWARD_AXIS);
		driveTurnAxis = controller.getRawAxis(Constants.DRIVE_TURN_AXIS);
		shooterButton = controller.getRawButton(Constants.SHOOTER_BUTTON);
		chainTrigger = controller.getRawAxis(Constants.CHAIN_TRIGGER);
		clawsUpBumper = controller.getRawButton(Constants.CLAWS_UP_BUMPER);
		clawsDownBumper = controller.getRawButton(Constants.CLAWS_DOWN_BUMBER);
	}

	public double getDriveForwardAxis() {
		return driveForwardAxis;
	}

	public double getDriveTurnAxis() {
		return driveTurnAxis;
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

	public boolean isClawsDownTrigger() {
		return clawsDownBumper;
	}
	
}
