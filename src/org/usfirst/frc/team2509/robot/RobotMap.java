/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2509.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static Talon Driveright1 = new Talon(0);
	public static Talon Driveright2 = new Talon(2);
	public static Talon Driveright3 = new Talon(1);
	public static Talon Driveleft1 = new Talon(3);
	public static Talon Driveleft2 = new Talon(4);
	public static Talon Driveleft3 = new Talon(5);
	public static SpeedControllerGroup Driveright = new SpeedControllerGroup(Driveright1, Driveright2, Driveright3);
	public static SpeedControllerGroup Driveleft = new SpeedControllerGroup(Driveleft1, Driveleft2, Driveleft3);
	public static DifferentialDrive differentialdrive = new DifferentialDrive(Driveleft, Driveright);
	public static DoubleSolenoid Solenoid = new DoubleSolenoid(0,1);
	public static Encoder enc1 = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	public static Encoder enc2 = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();

	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	public static void init(){
    	gyro.calibrate();
		SmartDashboard.putNumber("Encoder", enc1.get()/3);
	}
}
