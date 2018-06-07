package org.usfirst.frc.team2996.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {

	private Controller joysticks;
	
	private Shooter shooter;
	private Chain chain;
	private Claws claws;
	private Drive drive;

	@Override
	public void robotInit() {
		joysticks = new Controller();
		
		shooter = new Shooter();
		chain = new Chain();
		claws = new Claws();
		drive = new Drive();
	}

	@Override
	public void teleopPeriodic() {
		joysticks.setControllerInputValues();
		
		shooter.shooter(joysticks.isShooterButton());
		chain.chain(joysticks.getChainTrigger());
		claws.claws(joysticks.isClawsUpBumper(), joysticks.isClawsDownBumper());
		drive.arcadeDrive(joysticks.getDriveForwardAxis(), joysticks.getDriveTurnAxis());
	}
}
