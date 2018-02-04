/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2509.robot;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
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
	public static DoubleSolenoid DriveTrain_Shifter;
	public static Encoder DriveTrain_LeftEncoder;
	public static Encoder DriveTrain_RightEncoder;
	public static AHRS DriveTrain_NavX;
	public static WPI_TalonSRX DriveTrain_left1;
	public static WPI_TalonSRX DriveTrain_left2;
	public static WPI_TalonSRX DriveTrain_left3;
	public static WPI_TalonSRX DriveTrain_right1;
	public static WPI_TalonSRX DriveTrain_right2;
	public static WPI_TalonSRX DriveTrain_right3;
	public static SpeedControllerGroup DriveTrain_Left;
	public static SpeedControllerGroup DriveTrain_Right;
	public static DifferentialDrive RobotDrive;
	//Arm Variable
	public static DoubleSolenoid Arm_LowerSolenoid;
	public static DoubleSolenoid Arm_UpperSolenoid;
	public static VictorSP Arm_Motor;
	public static DigitalInput Arm_LowerLimit;
	public static DigitalInput Arm_MiddleLimit;
	public static DigitalInput Arm_UpperLimit;
	
	/**
	 * 
	 */
	public static void init(){
		//Drivetrain Variable Initialize
		DriveTrain_Shifter = new DoubleSolenoid(0,1);
		
		DriveTrain_LeftEncoder = new Encoder(0,1);
		SmartDashboard.putNumber("Left Encoder", DriveTrain_LeftEncoder.get());
		
		DriveTrain_RightEncoder = new Encoder(2,3);
		SmartDashboard.putNumber("Right Encoder", DriveTrain_RightEncoder.get());
		
		DriveTrain_NavX = new AHRS(SPI.Port.kMXP);
		DriveTrain_NavX.reset();
		SmartDashboard.putNumber("Gyro", DriveTrain_NavX.getAngle());
		
		DriveTrain_left1 = new WPI_TalonSRX(0);
		
		DriveTrain_left2 = new WPI_TalonSRX(2);
		
		DriveTrain_left3 = new WPI_TalonSRX(1);
		
		DriveTrain_right1 = new WPI_TalonSRX(3);
		
		DriveTrain_right2 = new WPI_TalonSRX(4);
		
		DriveTrain_right3 = new WPI_TalonSRX(5);
		
		DriveTrain_Left = new SpeedControllerGroup(
				DriveTrain_left1,DriveTrain_left2,DriveTrain_left3);
		
		DriveTrain_Right = new SpeedControllerGroup(
				DriveTrain_right1,DriveTrain_right2,DriveTrain_right3);
		
		RobotDrive = new DifferentialDrive(DriveTrain_Left,DriveTrain_Right);
		
		//Arm Variable Initialize
		Arm_LowerSolenoid = new DoubleSolenoid(2,3);
		
		Arm_UpperSolenoid = new DoubleSolenoid(4,5);
		
		Arm_Motor = new VictorSP(0);
		
		Arm_LowerLimit = new DigitalInput(4);
		
		Arm_MiddleLimit = new DigitalInput(5);
		
		Arm_UpperLimit = new DigitalInput(6);
	}
}
