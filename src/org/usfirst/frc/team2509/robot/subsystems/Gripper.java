package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gripper extends Subsystem {
	private static DoubleSolenoid Gripper = RobotMap.Gripper;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    /**
     * Extends the gripper for the box pickup method.
     */
    public void extend() {
    	Gripper.set(DoubleSolenoid.Value.kForward);
    	Gripper.set(DoubleSolenoid.Value.kOff);
    }
    /**
     * Retracts the gripper for the box pickup method.
     */
    public void retract() {
    	Gripper.set(DoubleSolenoid.Value.kReverse);
    	Gripper.set(DoubleSolenoid.Value.kOff);
    }
}

