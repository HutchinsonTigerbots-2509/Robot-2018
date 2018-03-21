/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2509.robot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static WPI_TalonSRX DriveTrain_left1;
	public static WPI_TalonSRX DriveTrain_left2;
	
	public static WPI_TalonSRX DriveTrain_right1;
	public static WPI_TalonSRX DriveTrain_right2;

	public static void init(){
		DriveTrain_right1 = new WPI_TalonSRX(1);
		//DriveTrain_right1.setInverted(true);
		
		DriveTrain_right2 = new WPI_TalonSRX(4);
		DriveTrain_left1 = new WPI_TalonSRX(0);
		DriveTrain_left2 = new WPI_TalonSRX(3);
		//shoot.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
		//DriveTrain_left1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		DriveTrain_right1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		DriveTrain_left1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		//DriveTrain_left1.configNominalOutputForward(0, 10);
		//DriveTrain_left1.configNominalOutputReverse(0, 10);
		//DriveTrain_left1.configPeakOutputForward(1, 10);
		//DriveTrain_left1.configPeakOutputReverse(-1, 10);
	    //DriveTrain_right2.setInverted(true);       
		//DriveTrain_right1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 10);
	
		DriveTrain_right2.set(ControlMode.Follower, 1);
		DriveTrain_left2.set(ControlMode.Follower, 0);
		//DriveTrain_right2.configOpenloopRamp(3, 10);
		//DriveTrain_left2.set(ControlMode.Follower, 2);
		//
		//DriveTrain_left2.set(ControlMode.Follower, 4);
		
		//slave2.set(ControlMode.Follower, 6);
		
	}
	
}
