package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	private static DoubleSolenoid Upper = RobotMap.Arm_UpperSolenoid;
	private static DoubleSolenoid Lower = RobotMap.Arm_LowerSolenoid;
	private static WPI_TalonSRX Motor = RobotMap.Arm_Motor;
	private static DigitalInput LowerLimit = RobotMap.Arm_LowerLimit;
	private static DigitalInput MiddleLimit = RobotMap.Arm_MiddleLimit;
	private static DigitalInput UpperLimit = RobotMap.Arm_UpperLimit;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	/**
	 * Moves the arm down until hits the lower limit
	 */
	public Thread armThreadDown = new Thread(()-> {
		
		Arm.Down();
	});
	
	/**
	 * Moves the arm into the Middle Position while retracting the Wrist and Gripper
	 */
	public Thread armThreadMid = new Thread(()-> {
		
		Arm.retractUpper();
		Arm.Middle();
	}); 
	/**
	 * Moves the arm into the High Position
	 */
	public Thread armThreadHigh = new Thread(()-> {
		
		Arm.High();
	}); 
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    /**
     * It will extend the wrist and gripper forward
     */
    public void extendUpper() {
    	Upper.set(DoubleSolenoid.Value.kForward);
//    	Upper.set(DoubleSolenoid.Value.kOff);
    }
    /**
     * It will retract the wrist and gripper
     */
    public void retractUpper() {
    	Upper.set(DoubleSolenoid.Value.kReverse);
//    	Upper.set(DoubleSolenoid.Value.kOff);
    }
    /**
     * Lifts the arm Up
     */
    public void extendLower() {
    	Lower.set(DoubleSolenoid.Value.kForward);
//    	Lower.set(DoubleSolenoid.Value.kOff);
    }
    /**
     * Moves the arm down
     */
    public void rectractLower() {
    	Lower.set(DoubleSolenoid.Value.kReverse);
//    	Lower.set(DoubleSolenoid.Value.kOff);
    }
    /**
     * Moves the arm to the Upper Limit (high position)
     */
    public static void High() {
    	while(UpperLimit.get())	Motor.set(1);
    	Motor.set(0);
    }
    /**
     * Moves the arm to the middle position
     */
    public static void Middle() {
    	while(MiddleLimit.get()) Motor.set(1);
    	Motor.set(0);
    }
    /**
     * Moves the arm down
     */
    public static void Down(){   
    	while(LowerLimit.get()) {
    		Motor.set(-0.8);
    	}
    	Motor.set(0);
    }
    /**
     * Returns Arm_UpperSolenoid as Upper
     */
    public DoubleSolenoid getUpper() {
    	return Upper;
    }
    /**
     * Returns Arm_LowerSolenoid as Lower
     */
    public DoubleSolenoid getLower() {
    	return Lower;
    }
    /**
     *Returns Arm_Motor as Motor 
     */
    public WPI_TalonSRX getMotor() {
    	return Motor;
    }
    /**
     * Returns Arm_LowerLimit (Robot Map) as LowerLimit
     */
    public DigitalInput getLowerLimit() {
    	return LowerLimit;
    }
    /**
     * Returns Arm_MiddleLimit (Robot Map) as MiddleLimit
     */
    public DigitalInput getMiddleLimit() {
    	return MiddleLimit;
    }
    /**
     * Returns Arm_UpperLimit (Robot Map) as UpperLimit
     */
    public DigitalInput getUpperLimit() {
    	return UpperLimit;
    }
}

