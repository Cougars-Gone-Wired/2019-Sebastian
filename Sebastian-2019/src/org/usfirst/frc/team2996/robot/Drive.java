package org.usfirst.frc.team2996.robot;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drive {

	private Talon frontLeftMotor;
	private Talon rearLeftMotor;
	private SpeedControllerGroup leftMotors;
	
	private Talon frontRightMotor;
	private Talon rearRightMotor;
	private SpeedControllerGroup rightMotors;
	
	private DifferentialDrive robotDrive;

	public Drive(){
		frontLeftMotor = new Talon(Constants.FRONT_LEFT_MOTOR_PORT);
		rearLeftMotor = new Talon(Constants.REAR_LEFT_MOTOR_PORT);
		leftMotors = new SpeedControllerGroup(frontLeftMotor, rearLeftMotor);
		
		frontRightMotor = new Talon(Constants.FRONT_RIGHT_MOTOR_PORT);
		rearRightMotor = new Talon(Constants.REAR_RIGHT_MOTOR_PORT);
		rightMotors = new SpeedControllerGroup(frontRightMotor, rearRightMotor);
		
		robotDrive = new DifferentialDrive(leftMotors, rightMotors);
	}
	
	public void arcadeDrive(double driveForwardAxis, double driveTurnAxis) {
		driveForwardAxis = -Utility.deadZone(driveForwardAxis) * Constants.DRIVE_SPEED * Constants.DRIVE_FORWARD_CONSTANT;
		driveTurnAxis = Utility.deadZone(driveTurnAxis) * Constants.DRIVE_SPEED * Constants.DRIVE_TURN_CONSTANT;
		
		robotDrive.arcadeDrive(driveForwardAxis, driveTurnAxis);
	}
	
}
