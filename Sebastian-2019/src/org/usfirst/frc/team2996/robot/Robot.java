package org.usfirst.frc.team2996.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {

	private Controller joysticks;
	
	private Shooter shooter;
	private Chain chain;
	
	private Drive drive;
	private Claws claws;
	
	@Override
	public void robotInit() {
		joysticks = new Controller();
		
		shooter = new Shooter();
		chain = new Chain();
		
		drive = new Drive();
		claws = new Claws();
	}

	@Override
	public void teleopPeriodic() {
		joysticks.setJoystickInputValues();
		
		shooter.shooter(joysticks.isShooterButton());
		chain.chain(joysticks.getChainTrigger());
		
		drive.arcadeDrive(joysticks.getDriveForwardAxis(), joysticks.getDriveTurnAxis());
		claws.claws(joysticks.isClawsUpBumper(), joysticks.isClawsDownTrigger());
	}

}
