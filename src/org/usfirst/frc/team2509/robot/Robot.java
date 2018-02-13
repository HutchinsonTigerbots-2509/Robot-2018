/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2509.robot;


import org.usfirst.frc.team2509.robot.commands.AccelTest;
import org.usfirst.frc.team2509.robot.commands.OperatorDrive;
import org.usfirst.frc.team2509.robot.commands.one.Auto1A;
import org.usfirst.frc.team2509.robot.commands.one.Auto1B;
import org.usfirst.frc.team2509.robot.commands.one.Auto1C;
import org.usfirst.frc.team2509.robot.commands.one.Auto1D;
import org.usfirst.frc.team2509.robot.commands.one.Auto1E;
import org.usfirst.frc.team2509.robot.commands.one.Auto1F;
import org.usfirst.frc.team2509.robot.commands.one.Auto1G;
import org.usfirst.frc.team2509.robot.commands.one.Auto1H;
import org.usfirst.frc.team2509.robot.commands.one.Auto1I;
import org.usfirst.frc.team2509.robot.commands.one.Auto1J;
import org.usfirst.frc.team2509.robot.commands.three.Auto3A;
import org.usfirst.frc.team2509.robot.commands.three.Auto3B;
import org.usfirst.frc.team2509.robot.commands.three.Auto3C;
import org.usfirst.frc.team2509.robot.commands.three.Auto3D;
import org.usfirst.frc.team2509.robot.commands.three.Auto3E;
import org.usfirst.frc.team2509.robot.commands.three.Auto3F;
import org.usfirst.frc.team2509.robot.commands.three.Auto3G;
import org.usfirst.frc.team2509.robot.commands.three.Auto3H;
import org.usfirst.frc.team2509.robot.commands.three.Auto3I;
import org.usfirst.frc.team2509.robot.commands.three.Auto3J;
import org.usfirst.frc.team2509.robot.commands.two.Auto2A;
import org.usfirst.frc.team2509.robot.commands.two.Auto2B;
import org.usfirst.frc.team2509.robot.commands.two.Auto2C;
import org.usfirst.frc.team2509.robot.commands.two.Auto2D;
import org.usfirst.frc.team2509.robot.commands.two.Auto2E;
import org.usfirst.frc.team2509.robot.commands.two.Auto2F;
import org.usfirst.frc.team2509.robot.commands.two.Auto2G;
import org.usfirst.frc.team2509.robot.commands.two.Auto2H;
import org.usfirst.frc.team2509.robot.commands.two.Auto2I;
import org.usfirst.frc.team2509.robot.commands.two.Auto2J;
import org.usfirst.frc.team2509.robot.subsystems.Arm;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot{
	
	public static OI oi;
	public static DriveTrain drivetrain;
	public static Arm arm;
	public Command autonomousCommand;
	public Command operatorDrive;



//github.com/HutchinsonTigerbots-2509/Robot-2018.git
//	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		drivetrain = new DriveTrain();
		arm = new Arm();
		// OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
		oi = new OI();
		operatorDrive = new OperatorDrive();
		SmartDashboard.putData("Auto mode", oi.chooser);
		oi.UpdateDashboard.start();
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
//		RobotMap.comp.stop();
//		autonomousCommand = oi.getAutonomous(oi.chooser.getSelected(), 
//				DriverStation.getInstance().getGameSpecificMessage());
		
//		autonomousCommand = new AccelTest();
		autonomousCommand = new Auto3J();
//		autonomousCommand = new Auto1B();
//		autonomousCommand = new Auto1C();
//		autonomousCommand = new Auto1D();
//		autonomousCommand = Auto1E;
//		autonomousCommand = Auto1F;
//		autonomousCommand = Auto1G;
//		autonomousCommand = Auto1H;
//		autonomousCommand = Auto2D;
//		autonomousCommand = Auto3A;
//		autonomousCommand = Auto3B;
//		autonomousCommand = Auto3C;
//		autonomousCommand = Auto3D;
//		autonomousCommand = Auto3E;
//		autonomousCommand = Auto3F;
//		autonomousCommand = Auto1G;
//		autonomousCommand = Auto1I;
//		autonomousCommand = Auto3H;
//		autonomousCommand = Auto2B;
//		autonomousCommand = Auto2F;
//		autonomousCommand = Auto2J;
//		autonomousCommand = Auto2H;
//		autonomousCommand = AccelTest;
//		autonomousCommand = Auto;
//		autonomousCommand = Auto;
//		autonomousCommand = Auto;
//		autonomousCommand = Auto;
//		autonomousCommand = Auto;
//		autonomousCommand = Auto;
//		autonomousCommand = Auto;
//		autonomousCommand = Auto;
//		autonomousCommand = chooser.getSelected();

		

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