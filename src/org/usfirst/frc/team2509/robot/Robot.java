/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2509.robot;

import org.usfirst.frc.team2509.subsystems.DriveTrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;


public class Robot extends TimedRobot {
	public static OI oi;
	public static DifferentialDrive myDrive;
	public static Joystick RIGHTSTICK;
	public static DriveTrain drivetrain; 
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();


	@Override
	public void robotInit() {
		RobotMap.init();
		myDrive = new DifferentialDrive(1, 2, 3, 4);
//		LEFTSTICK = new Joystick(2);
		RIGHTSTICK = new Joystick(1);
		drivetrain = new DriveTrain();
		
		
		oi = new OI();

	}


	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();


		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	
	public void operatorControl() {
		while (isOperatorControl() && isEnabled()) {
			drivetrain.drive(RIGHTSTICK);
				Timer.delay(0.01);
		}
	}
	@Override
	public void teleopInit() {
		
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void testPeriodic() {
	}
}
