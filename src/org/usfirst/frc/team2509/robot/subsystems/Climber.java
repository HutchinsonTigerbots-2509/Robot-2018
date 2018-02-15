package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.VictorSP;

/**
 *
 */
public class Climber extends Subsystem {
	private static VictorSP Motor = RobotMap.Climb_Motor;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	Motor.set(1);
    }
    public void ClimbUp() {
    	Motor.set(1);
    }
    public void ClimbStop() {
    	Motor.set(0);
    }
    public VictorSP getMotor() {
    	return Motor;
    }
}

