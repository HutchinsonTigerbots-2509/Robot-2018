package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	private static WPI_TalonSRX leftMotor = RobotMap.LeftMotor;
	private static WPI_TalonSRX rightMotor = RobotMap.RightMotor;
	private static DoubleSolenoid piston = RobotMap.Intake;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    /**
     * Extends the two arms for the box pickup.
     */
    public void extend() {
    	piston.set(DoubleSolenoid.Value.kForward);
    	piston.set(DoubleSolenoid.Value.kOff);
    }
    /**
     * Retracts the two arms for the box pickup.
     */
    public void retract() {
    	piston.set(DoubleSolenoid.Value.kReverse);
    	piston.set(DoubleSolenoid.Value.kOff);
    }
    /**
     * Turns on the wheels for the box pickup method.
     */
    public void on() {
    	leftMotor.set(0.5);
    	rightMotor.set(0.5);
    }
    /**
     * Turns off the wheels for the box pickup method.
     */
    public void off() {
    	leftMotor.set(0);
    	rightMotor.set(0);
    	
    }
}

