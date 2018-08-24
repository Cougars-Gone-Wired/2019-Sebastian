package org.usfirst.frc.team2996.robot;

import java.util.List;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	private Controller controller;
	
	private Shooter shooter;
	private Chain chain;
	private Claws claws;
	private Drive drive;
	
	private StateRecorder recorder;
	private StateRunner runner;

	@Override
	public void robotInit() {
		controller = new Controller();
		
		shooter = new Shooter();
		chain = new Chain();
		claws = new Claws();
		drive = new Drive();
		
		recorder = new StateRecorder();
		runner = new StateRunner(this);
		
		GsonSmartDash.put();
	}

	@Override
	public void autonomousInit() {
		runner.counterInitialize();
		try {
			List<State> states = StateReader.read(StateLister.gsonChooser.getSelected());
			runner.setStates(states); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void autonomousPeriodic() {
		runner.run();
	}

	@Override
	public void teleopInit() {
		recorder.initialize();
		runner.counterInitialize();
	}
	
	@Override
	public void teleopPeriodic() {
		controller.setControllerInputValues();
		
		shooter.shooter(controller.isShooterBumper());
		chain.chain(controller.getChainTrigger());
		claws.claws(controller.isClawsUpBumper(), controller.getClawsDownTrigger());
		drive.arcadeDrive(controller.getDriveForwardAxis(), controller.getDriveTurnAxis());
		
		recorder.record(controller);
	}

	@Override
	public void disabledInit() {
		if (GsonSmartDash.shouldRecord) {
			List<State> states = recorder.getStates();
			try {
				StatesWriter.writeStates(states, GsonSmartDash.gsonFileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		StateLister.getStateNames(); 
		
		SmartDashboard.putBoolean("Should Record", false);
	}

	@Override
	public void disabledPeriodic() {
		GsonSmartDash.set();
		
		if (!GsonSmartDash.shouldRecord) {
			SmartDashboard.putString("Gson File Name", "");
		}
	}
	
	public Shooter getShooter() {
		return shooter;
	}

	public Chain getChain() {
		return chain;
	}

	public Claws getClaws() {
		return claws;
	}

	public Drive getDrive() {
		return drive;
	}
}
