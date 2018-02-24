package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *Wrist- moves the gripper up and down with gripper.Up, gripper.Down, and gripper.Idle
 */
public class Wrist extends Subsystem {
	private static WPI_TalonSRX motor = RobotMap.Wrist;
	private static Encoder WristEncoder = RobotMap.WristEncoder;
//	private static DigitalInput upperLimit = RobotMap.Wrist_UpperLimit;
//	private static DigitalInput lowerLimit = RobotMap.Wrist_LowerLimit;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
//    public void Up() {
//    	while(upperLimit.get()) motor.set(.45);
//    	motor.set(0);
//    	
//    }
    /**
     * Moves the gripper up
     * @param Target
     */
    public void Up(double Target) {
    	int Max = 35;
    	//while(WristEncoder.get() <= (Target - 3) && WristEncoder.get()<=Max){
    	motor.set(0.25);
    	
    	//motor.set(0);
    		
    }
    /**
     * Moves the gripper down
     * @param Target
     */
    public void Down(double Target) {
    	//int Min = 0;
    	//while(WristEncoder.get() >= (Target + 3)) {
    	motor.set(-0.25);
    	

    	//motor.set(0);
    }
//    public void Down() {
//    	while(lowerLimit.get()) motor.set(-.45);
//    	motor.set(0);
//    }
    /**
     * Keeps the gripper still
     */
    public void Idle() { //Probably not needed, but I'm paranoid.
    	motor.set(0);
    }
    
    public WPI_TalonSRX getMotor() {
    	return motor;
    }
//    public DigitalInput getUpperLimit() {
//    	return upperLimit;
//    }
//    public DigitalInput getLowerLimit() {
//    	return lowerLimit;
//    }
}

