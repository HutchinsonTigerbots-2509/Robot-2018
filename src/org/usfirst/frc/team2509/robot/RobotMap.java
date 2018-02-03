/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2509.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import org.usfirst.frc.team2509.robot.subsystems.*;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	//Drivetran Variable
	public static DoubleSolenoid DriveTrain_Shifter;
	public static Encoder DriveTrain_LeftEncoder;
	public static Encoder DriveTrain_RightEncoder;
	public static AHRS NavX;
	public static Talon DriveTrain_left1;
	public static Talon DriveTrain_left2;
	public static Talon DriveTrain_left3;
	public static Talon DriveTrain_right1;
	public static Talon DriveTrain_right2;
	public static Talon DriveTrain_right3;
	public static SpeedControllerGroup DriveTrain_Left;
	public static SpeedControllerGroup DriveTrain_Right;
	public static DifferentialDrive RobotDrive;

	/**OK before you ask why I'm creating this up here instead of the method, it hates conforming to normal rules, as far as Nate 
	*  can tell this doesn't break anything so just roll with it, OK?
	*/
	
	
	static final double kToleranceDegrees = 2.0f;
	public static void init(){
		//Drivetrain Variable Initialize
		DriveTrain_Shifter = new DoubleSolenoid(0,1);
		
		DriveTrain_LeftEncoder = new Encoder(0,1);
		SmartDashboard.putNumber("Left Encoder", DriveTrain_LeftEncoder.get());
		
		DriveTrain_RightEncoder = new Encoder(2,3);
		SmartDashboard.putNumber("Right Encoder", DriveTrain_RightEncoder.get());
		
		
		NavX = new AHRS(SPI.Port.kMXP);
		NavX.reset();
		SmartDashboard.putNumber("Gyro", NavX.getAngle());
		
		
		DriveTrain_left1 = new Talon(0);
		
		DriveTrain_left2 = new Talon(2);
		
		DriveTrain_left3 = new Talon(1);
		
		DriveTrain_right1 = new Talon(3);
		
		DriveTrain_right2 = new Talon(4);
		
		DriveTrain_right3 = new Talon(5);
		
		DriveTrain_Left = new SpeedControllerGroup(
				DriveTrain_left1,DriveTrain_left2,DriveTrain_left3);
		
		DriveTrain_Right = new SpeedControllerGroup(
				DriveTrain_right1,DriveTrain_right2,DriveTrain_right3);
		
		RobotDrive = new DifferentialDrive(DriveTrain_Left,DriveTrain_Right);
		
	}


}
