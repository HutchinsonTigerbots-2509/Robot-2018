package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Wrist extends Subsystem {
	private static WPI_TalonSRX wrist = RobotMap.Wrist;
	private static DigitalInput lower = RobotMap.Wrist_LowerLimit;
	private static DigitalInput upper = RobotMap.Wrist_UpperLimit;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void Up() {
    	while(upper.get()) wrist.set(.5);
    	wrist.set(0);
    	
    }
    public void Down() {
    	while(lower.get()) wrist.set(-.5);
    	wrist.set(0);
    }
    public DigitalInput getlower() {
    	return lower;
    }
    public DigitalInput getupper() {
    	return upper;
    }
    public WPI_TalonSRX getwrist() {
    	return wrist;
    }
}

