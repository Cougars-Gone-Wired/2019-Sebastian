package org.usfirst.frc.team2996.robot;

public class State {

	private boolean shooterBumperState;
	private double chainTriggerState;
	private boolean clawsUpBumperState;
	private double clawsDownTriggerState;
	private double driveForwardAxisState;
	private double driveTurnAxisState;
	public boolean isShooterBumperState() {
		return shooterBumperState;
	}
	public void setShooterBumperState(boolean shooterBumperState) {
		this.shooterBumperState = shooterBumperState;
	}
	public double getChainTriggerState() {
		return chainTriggerState;
	}
	public void setChainTriggerState(double chainTriggerState) {
		this.chainTriggerState = chainTriggerState;
	}
	public boolean isClawsUpBumperState() {
		return clawsUpBumperState;
	}
	public void setClawsUpBumperState(boolean clawsUpBumperState) {
		this.clawsUpBumperState = clawsUpBumperState;
	}
	public double getClawsDownTriggerState() {
		return clawsDownTriggerState;
	}
	public void setClawsDownTriggerState(double clawsDownTriggerState) {
		this.clawsDownTriggerState = clawsDownTriggerState;
	}
	public double getDriveForwardAxisState() {
		return driveForwardAxisState;
	}
	public void setDriveForwardAxisState(double driveForwardAxisState) {
		this.driveForwardAxisState = driveForwardAxisState;
	}
	public double getDriveTurnAxisState() {
		return driveTurnAxisState;
	}
	public void setDriveTurnAxisState(double driveTurnAxisState) {
		this.driveTurnAxisState = driveTurnAxisState;
	}
	
}
