package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;

/**
 *
 */
public class Climber extends Subsystem {
	private static SpeedControllerGroup climb = RobotMap.ClimbGroup;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
    }
    public void ClimbUp() {
    	climb.set(1);
    }
    public void ClimbStop() {
    	climb.set(0);
    }
    public SpeedControllerGroup getSpeedControllerGroup() {
    	return climb;
    }
}

