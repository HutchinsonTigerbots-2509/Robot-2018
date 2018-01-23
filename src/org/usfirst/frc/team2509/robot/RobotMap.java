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

	//Drivetran Variable
	public static DoubleSolenoid DT_Shifter;
	public static Encoder DT_LeftEncoder;
	public static Encoder DT_RightEncoder;
	public static ADXRS450_Gyro DT_Gyro;
	public static Talon DT_LEFT1;
	public static Talon DT_LEFT2;
	public static Talon DT_LEFT3;
	public static Talon DT_RIGHT1;
	public static Talon DT_RIGHT2;
	public static Talon DT_RIGHT3;
	public static SpeedControllerGroup DTG_LEFT;
	public static SpeedControllerGroup DTG_RIGHT;
	public static DifferentialDrive RobotDrive;
	
	/**
	 * 
	 */
	public static void init(){
		//Drivetrain Variable Initialize
		DT_Shifter = new DoubleSolenoid(0,1);
		
		DT_LeftEncoder = new Encoder(0,1);
		SmartDashboard.putNumber("Left Encoder", DT_LeftEncoder.get());
		
		DT_RightEncoder = new Encoder(2,3);
		SmartDashboard.putNumber("Right Encoder", DT_RightEncoder.get());
		
		
		DT_Gyro = new ADXRS450_Gyro();
		DT_Gyro.reset();
		DT_Gyro.calibrate();
		SmartDashboard.putNumber("Gyro", DT_Gyro.getAngle());
		
		DT_LEFT1 = new Talon(0);
		
		DT_LEFT2 = new Talon(2);
		
		DT_LEFT3 = new Talon(1);
		
		DT_RIGHT1 = new Talon(3);
		
		DT_RIGHT2 = new Talon(4);
		
		DT_RIGHT3 = new Talon(5);
		
		//DTG because its a drivetrain(DT) group
		DTG_LEFT = new SpeedControllerGroup(
				DT_LEFT1,DT_LEFT2,DT_LEFT3);
		
		DTG_RIGHT = new SpeedControllerGroup(
				DT_RIGHT1,DT_RIGHT2,DT_RIGHT3);
		
		RobotDrive = new DifferentialDrive(DTG_LEFT,DTG_RIGHT);
		
	}

	private static void whenPressed() {
		// TODO Auto-generated method stub
		
	}
}
