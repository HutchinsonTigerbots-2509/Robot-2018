package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Arm extends Subsystem {
	private static DoubleSolenoid Upper = RobotMap.Arm_UpperSolenoid;
	private static DoubleSolenoid Lower = RobotMap.Arm_LowerSolenoid;
	private static VictorSP Motor = RobotMap.Arm_Motor;
	private static DigitalInput LowerLimit = RobotMap.Arm_LowerLimit;
	private static DigitalInput MiddleLimit = RobotMap.Arm_MiddleLimit;
	private static DigitalInput UpperLimit = RobotMap.Arm_UpperLimit;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Thread armThreadDown = new Thread(()-> {
		
		Arm.Down();
	}); 
	public Thread armThreadMid = new Thread(()-> {
		
		Arm.Middle();
	}); 
	public Thread armThreadHigh = new Thread(()-> {
		
		Arm.High();
	}); 
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void extendUpper() {
    	Upper.set(DoubleSolenoid.Value.kForward);
//    	Upper.set(DoubleSolenoid.Value.kOff);
    }
    public void retractUpper() {
    	Upper.set(DoubleSolenoid.Value.kReverse);
//    	Upper.set(DoubleSolenoid.Value.kOff);
    }
    public void extendLower() {
    	Lower.set(DoubleSolenoid.Value.kForward);
//    	Lower.set(DoubleSolenoid.Value.kOff);
    }
    public void rectractLower() {
    	Lower.set(DoubleSolenoid.Value.kReverse);
//    	Lower.set(DoubleSolenoid.Value.kOff);
    }
    public static void High() {
    	while(UpperLimit.get())	Motor.set(1);
    	Motor.set(0);
    }
    public static void Middle() {
    	while(MiddleLimit.get()) Motor.set(1);
    	Motor.set(0);
    }
    public static void Down(){   
    	while(LowerLimit.get()) {
    		Motor.set(-0.8);
    	}
    	Motor.set(0);
    }
    public DoubleSolenoid getUpper() {
    	return Upper;
    }
    public DoubleSolenoid getLower() {
    	return Lower;
    }
    public VictorSP getMotor() {
    	return Motor;
    }
    public DigitalInput getLowerLimit() {
    	return LowerLimit;
    }
    public DigitalInput getMiddleLimit() {
    	return MiddleLimit;
    }
    public DigitalInput getUpperLimit() {
    	return UpperLimit;
    }
}

