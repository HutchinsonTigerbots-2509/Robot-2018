package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.RobotMap;
import org.usfirst.frc.team2509.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gripper extends Subsystem {
	Arm arm = Robot.arm;
	private static DigitalInput limit = RobotMap.Gripper_Limit;
	private static DoubleSolenoid piston = RobotMap.Gripper_Piston;
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public DigitalInput getLimit() {
    	return limit;
    }
    public DoubleSolenoid getPiston() {
    	return piston;
    }
    public void extend() {
    	piston.set(DoubleSolenoid.Value.kForward);
    }
    public void retract() {
    	piston.set(DoubleSolenoid.Value.kReverse);
    	
    }
}

