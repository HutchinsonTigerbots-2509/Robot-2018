package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Wrist extends Subsystem {
	private static VictorSP motor = RobotMap.Wrist;
	private static DigitalInput upperLimit = RobotMap.Wrist_UpperLimit;
	private static DigitalInput lowerLimit = RobotMap.Wrist_LowerLimit;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void Up() {
    	while(upperLimit.get()) motor.set(.5);
    	motor.set(0);
    	
    }
    public void Down() {
    	while(lowerLimit.get()) motor.set(-.5);
    	motor.set(0);
    }
    
    public VictorSP getMotor() {
    	return motor;
    }
    public DigitalInput getUpperLimit() {
    	return upperLimit;
    }
    public DigitalInput getLowerLimit() {
    	return lowerLimit;
    }
}

