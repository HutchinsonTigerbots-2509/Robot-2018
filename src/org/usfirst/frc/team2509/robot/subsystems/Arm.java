package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	private static DoubleSolenoid LowerSolenoid = RobotMap.Arm_lowerSolenoid;
	private static DoubleSolenoid UpperSolenoid = RobotMap.Arm_UpperSolenoid;
	private static Talon Motor = RobotMap.Arm_motor;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void extendLower() {
    	LowerSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    public void extendUpper() {
    	UpperSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    public void retractLower() {
    	LowerSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    public void reractUpper() {
    	UpperSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    public void Up() {
    	Motor.set(.5);
    	Timer.delay(2.0);
    	Motor.set(0);
    }
    public void Down(){   
    	Motor.set(-.5);
    	Timer.delay(2.0);
    	Motor.set(0);
    }
}

