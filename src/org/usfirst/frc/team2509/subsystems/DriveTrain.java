package org.usfirst.frc.team2509.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {
	WPI_TalonSRX left1 = RobotMap.DT_left1;
	WPI_TalonSRX right1 = RobotMap.DT_right1;
	WPI_TalonSRX left2 = RobotMap.DT_left2;
	WPI_TalonSRX right2 = RobotMap.DT_right2;
	
	SpeedControllerGroup DT_left = RobotMap.DT_left;
	SpeedControllerGroup DT_right = RobotMap.DT_right;
	
	DifferentialDrive RobotDrive = RobotMap.RobotDrive; 
    

    public void initDefaultCommand() {
    	
    }
    public void drive(Joystick stick) {
    	RobotDrive.arcadeDrive(stick.getY(), stick.getZ());
    }
}

