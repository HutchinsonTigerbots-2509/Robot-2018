package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *The motors for the climbing at the end of the round
 */
public class Climb extends Subsystem {
	private VictorSP Motor1 = RobotMap.ClimbMotor1;
	private VictorSP Motor2 = RobotMap.ClimbMotor2;
	public SpeedControllerGroup ClimbMotors = RobotMap.ClimbMotors;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public VictorSP getClimbMotor1() {
    	return Motor1;
    }
    public VictorSP getClimbMotor2() {
    	return Motor2;
    }
    public void Up() {
    	double speed = 0.75;
    	ClimbMotors.set(speed);
    }
    public void Stop() {
    	double speed = 0.0;
    	ClimbMotors.set(speed);
    }
}