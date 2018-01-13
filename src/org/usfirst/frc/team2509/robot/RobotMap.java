/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2509.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class RobotMap {
	
	public static WPI_TalonSRX DT_left1 = new WPI_TalonSRX(1);
	public static WPI_TalonSRX DT_right1 = new WPI_TalonSRX(2);
	public static WPI_TalonSRX DT_left2 = new WPI_TalonSRX(3);
	public static WPI_TalonSRX DT_right2 = new WPI_TalonSRX(4);
	
	public static SpeedControllerGroup DT_left = new SpeedControllerGroup(DT_left1, DT_left2);
	public static SpeedControllerGroup DT_right = new SpeedControllerGroup(DT_right1, DT_right2);
	
	public static DifferentialDrive RobotDrive = new DifferentialDrive(DT_left, DT_right);
	
	
	public static void init(){
		
	}
}