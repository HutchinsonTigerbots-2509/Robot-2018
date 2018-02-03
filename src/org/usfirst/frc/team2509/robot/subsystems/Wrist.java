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
    /**
     * Turns the Wrist to face up.
     */
    public void upper() {
    	while(upper.get()) wrist.set(-0.5);
    	wrist.set(0);
    }
    /**
     * Turns the Wrist to face forward
     */
    public void lower() {
    	while(lower.get()) wrist.set(0.5);
    	wrist.set(0);
    	
    }
}

