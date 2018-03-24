/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ExampleSubsystem extends Subsystem {
	private WPI_TalonSRX left = RobotMap.DriveTrain_left1;
	private WPI_TalonSRX right = RobotMap.DriveTrain_right1;
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.

		// setDefaultCommand(new MySpecialCommand());
	}
	public void drive_foward(int distant) {
		right.setSelectedSensorPosition(0, 0, 0);
		left.setSelectedSensorPosition(0, 0, 0);
		while(left.getSelectedSensorPosition(0) < distant) {
			
			right.set(ControlMode.MotionMagic, -(distant * 1000));
			left.set(ControlMode.MotionMagic, (distant * 1000));
			SmartDashboard.putNumber("Right_RPM", (right.getSelectedSensorVelocity(0)));
			SmartDashboard.putNumber("Right_postion", (right.getSelectedSensorPosition(0)));
			SmartDashboard.putNumber("Left_RPM", (left.getSelectedSensorVelocity(0)));
			SmartDashboard.putNumber("Left_Postion", (left.getSelectedSensorPosition(0)));
			double Right_Speed = right.getMotorOutputVoltage();
			double Left_Speed = left.getMotorOutputVoltage();
		}
		right.set(1);
		left.set(1);
		//right.set(ControlMode.PercentOutput, value);
		
		//motor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 1);
		
		
	}
	
	public void Turn_right(double radius) {
		right.set(1);
		left.set(1);
		right.setSelectedSensorPosition(0, 0, 0);
		left.setSelectedSensorPosition(0, 0, 0);
		right.configMotionCruiseVelocity(350, 0);
		right.configMotionAcceleration(10000, 0);
		left.configMotionCruiseVelocity(175, 0);
		left.configMotionAcceleration(5000, 0);
		while(left.getSelectedSensorPosition(0) < 1000000) {
			//right.set(ControlMode.Velocity, -350);
			//left.set(ControlMode.Velocity, 175);
			right.set(ControlMode.MotionMagic, -1000000);
			left.set(ControlMode.MotionMagic, 500000);
			SmartDashboard.putNumber("Right_RPM", (right.getSelectedSensorVelocity(0)));
			SmartDashboard.putNumber("Right_postion", (right.getSelectedSensorPosition(0)));
			SmartDashboard.putNumber("Left_RPM", (left.getSelectedSensorVelocity(0)));
			SmartDashboard.putNumber("Left_Postion", (left.getSelectedSensorPosition(0)));
		}
		
	}
	public void off() {
		//motor.set(0);
	}
}
