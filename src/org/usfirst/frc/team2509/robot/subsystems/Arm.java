package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	private static DoubleSolenoid Upper = RobotMap.Arm_UpperSolenoid;
	private static DoubleSolenoid Lower = RobotMap.Arm_LowerSolenoid;
	private static Talon Motor = RobotMap.Arm_Motor;
	private static DigitalInput LowerLimit = RobotMap.Arm_LowerLimit;
	private static DigitalInput MiddleLimit = RobotMap.Arm_MiddleLimit;
	private static DigitalInput UpperLimit = RobotMap.Arm_UpperLimit;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void extendUpper() {
    	Upper.set(DoubleSolenoid.Value.kForward);
    }
    public void retractUpper() {
    	Upper.set(DoubleSolenoid.Value.kReverse);
    }
    public void extendLower() {
    	Lower.set(DoubleSolenoid.Value.kForward);
    }
    public void rectractLower() {
    	Lower.set(DoubleSolenoid.Value.kReverse);
    }
    public void High() {
    	while(UpperLimit.get()) Motor.set(.5);
    	Motor.set(0);
    }
    public void Middle() {
    	while(MiddleLimit.get()) Motor.set(.5);
    	Motor.set(0);
    }
    public void Down(){   
    	while(LowerLimit.get()) Motor.set(-.5);
    	Motor.set(0);
    }
    public DoubleSolenoid getUpper() {
    	return Upper;
    }
    public DoubleSolenoid getLower() {
    	return Lower;
    }
    public Talon getMotor() {
    	return Motor;
    }

}

