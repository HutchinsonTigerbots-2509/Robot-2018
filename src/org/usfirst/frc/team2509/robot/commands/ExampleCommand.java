/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2509.robot.commands;

import org.usfirst.frc.team2509.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example command.  You can replace me with your own command.
 */
public class ExampleCommand extends Command {
	private WPI_TalonSRX motor12 = RobotMap.DriveTrain_right1;
	private WPI_TalonSRX motor1 = RobotMap.DriveTrain_left1;
	//private WPI_TalonSRX motor2 = RobotMap.DriveTrain_right1;
	
	public ExampleCommand() {
		// Use requires() here to declare subsystem dependencies
		
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		//motor1.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 1);
		//motor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 1);
		
		//motor1.set(0.25);
		//motor12.set(0.25);
		motor1.config_kF(0, 0.01, 10);
		motor1.config_kP(0, 0.4, 10);
		motor1.config_kI(0, 0.0001, 10);
		motor1.config_kD(0, .001, 10);
		motor1.setSelectedSensorPosition(0, 0, 0);
		motor1.configMotionCruiseVelocity(1000, 0);
		motor1.configMotionAcceleration(1000, 0);
		motor1.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 10);
		motor1.set(ControlMode.MotionMagic, 100000);
		motor12.config_kF(0, 0.031, 10);
		motor12.config_kP(0, 0.03, 10);
		motor12.config_kI(0, 0.00001, 10);
		motor12.config_kD(0, 0.3, 10);
		motor12.setSelectedSensorPosition(0, 0, 0);
		motor12.configMotionCruiseVelocity(1000, 0);
		motor12.configMotionAcceleration(1000, 0);
		motor12.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 10);
		motor12.set(ControlMode.MotionMagic, 100000);
		SmartDashboard.getNumber("Angle", 0);
		
		
		//motor1.configMotionAcceleration(1000, 0);
		
		//SmartDashboard.putNumber("RPM", motor1.getSelectedSensorVelocity(0));
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		//SmartDashboard.putNumber("RPM", (motor12.getSelectedSensorVelocity(0)));
		//SmartDashboard.putNumber("postion", (motor12.getSelectedSensorPosition(0)));
		SmartDashboard.putNumber("RPM1", (motor12.getSelectedSensorVelocity(0)));
		SmartDashboard.putNumber("postion1", (motor12.getSelectedSensorPosition(0)));
		//SmartDashboard.putNumber("postion1", (motor12.getSelectedSensorPosition(0)));
		SmartDashboard.putNumber("current", (motor12.getOutputCurrent()));
		SmartDashboard.putNumber("voltage", (motor12.getMotorOutputVoltage()));
		SmartDashboard.putNumber("percent", (motor12.getMotorOutputPercent()));
		//SmartDashboard.putNumber("RPM", (motor1.getSelectedSensorVelocity(0)));
		//SmartDashboard.putNumber("postion", (motor1.getSelectedSensorPosition(0)));
		
		
	
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		motor1.set(ControlMode.Current, 0);
		motor12.set(ControlMode.Current, 0);
		//motor1.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
