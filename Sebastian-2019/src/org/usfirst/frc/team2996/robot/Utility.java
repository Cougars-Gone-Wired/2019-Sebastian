package org.usfirst.frc.team2996.robot;

public class Utility {

	public static double deadZone(double axisOutputValue) {
		if (Math.abs(axisOutputValue) > 0.15){
			return axisOutputValue;
		} else {
			return 0;
		}
	}
	
	public static double invertDouble(double doubleValue) {
		return -doubleValue;
	}
}
