package org.usfirst.frc.team2996.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {

	private Controller controller;
	
	private Shooter shooter;
	private Chain chain;
	private Claws claws;
	private Drive drive;

	@Override
	public void robotInit() {
		controller = new Controller();
		
		shooter = new Shooter();
		chain = new Chain();
		claws = new Claws();
		drive = new Drive();
	}

	@Override
	public void teleopPeriodic() {
		controller.setControllerInputValues();
		
		shooter.shooter(controller.isShooterBumper());
		chain.chain(controller.getChainTrigger());
		claws.claws(controller.isClawsUpBumper(), controller.getClawsDownTrigger());
		drive.arcadeDrive(controller.getDriveForwardAxis(), controller.getDriveTurnAxis());
	}
}
