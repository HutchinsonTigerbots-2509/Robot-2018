/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2509.robot;


import org.usfirst.frc.team2509.robot.commands.AutonomousCommand;
import org.usfirst.frc.team2509.robot.commands.OperatorDrive;
import org.usfirst.frc.team2509.robot.subsystems.BoxVision;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2509.robot.subsystems.vision;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team2509.robot.commands.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static OI oi;
	public static DriveTrain drivetrain;
	public static vision Vision;
	public static BoxVision boxVision;
	Command autonomousCommand;
	public Command operatorDrive;
	public Command Auto3H;
	public Command Auto3B;
	public Command Auto3D;
	public Command Auto3F;
	public Command Auto1A;
	public Command Auto1C;
	public Command Auto1G;
	public Command Auto1E;
	public Command PathAuto;
//	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	
	//just putting this here to make sure it commits
	@Override
	public void robotInit() {
		RobotMap.init();
		drivetrain = new DriveTrain();
		Vision = new vision();
		boxVision = new BoxVision(); 
		// OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
		oi = new OI();
		operatorDrive = new OperatorDrive();

		//Auto3J = new Auto3I();
		//Auto3E = new Auto3E();
		//Auto3D = new Auto3D();
		//Auto3F = new Auto3F();
		//Auto1A = new Auto1A();
		//Auto1C = new Auto1C();
		//Auto1G = new Auto1G();
		//Auto1E = new Auto1E();
		PathAuto = new PathAuto();
//		chooser.addDefault("Default Auto", null);
// 		chooser.addObject("My Auto", new MyAutoCommand());
//		SmartDashboard.putData("Auto mode", chooser);
		oi.UpdateDashboard.start();
		//autonomousCommand = new AutonomousCommand();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = Auto3H;
		autonomousCommand = Auto3B;
		autonomousCommand = Auto3D;
		autonomousCommand = Auto3F;
		autonomousCommand = Auto1A;
		autonomousCommand = Auto1C;
		autonomousCommand = Auto1G;
		autonomousCommand = Auto1E;
		autonomousCommand = PathAuto;
//		autonomousCommand = chooser.getSelected();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector", "Default"); 
		 * switch(autoSelected){ 
		 * 	case "My Auto": 
		 * 		autonomousCommand = new MyAutoCommand(); 
		 * 		break; 
		 * 	case "Default Auto": default:
		 * 		autonomousCommand = new ExampleCommand(); 
		 * 		break; 
		 * }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		operatorDrive.start();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
