package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climb extends Subsystem {
	private static VictorSP LeftMotor = RobotMap.leftMotor;
	private static VictorSP RightMotor = RobotMap.rightMotor;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void on() {
    	LeftMotor.set(1);
    	RightMotor.set(1);
    }
    public void off() {
    	LeftMotor.set(0);
    	RightMotor.set(0);
    }
}

