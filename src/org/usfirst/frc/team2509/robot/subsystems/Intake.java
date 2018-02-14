package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	private static DoubleSolenoid piston = RobotMap.Intake_Piston;
	private static VictorSP leftMotor = RobotMap.Intake_LeftMotor;
	private static VictorSP rightMotor = RobotMap.Intake_RightMotor;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public DoubleSolenoid getPiston() {
    	return piston;
    }
    public VictorSP getLeftMotor() {
    	return leftMotor;
    }
    public VictorSP getRightMotor() {
    	return rightMotor;
    }
}

