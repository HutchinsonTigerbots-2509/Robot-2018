/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2509.robot;



import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static WPI_TalonSRX DT_LEFT1 = new WPI_TalonSRX(0);
	public static WPI_TalonSRX DT_LEFT2 = new WPI_TalonSRX(1);
	public static WPI_TalonSRX DT_RIGHT1 = new WPI_TalonSRX(2);
	public static WPI_TalonSRX DT_RIGHT2 = new WPI_TalonSRX(3);
	public static SpeedControllerGroup LeftDrive = new SpeedControllerGroup(DT_LEFT1,DT_LEFT2);
	public static SpeedControllerGroup RightDrive = new SpeedControllerGroup(DT_RIGHT1,DT_RIGHT2);
			
	public static DifferentialDrive myDrive = new DifferentialDrive(LeftDrive, RightDrive);
	
	
	 
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
		
		
	public static void init(){
		
	}
		
}
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
