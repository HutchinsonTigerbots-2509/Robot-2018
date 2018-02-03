/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2509.robot;


import org.usfirst.frc.team2509.robot.commands.Auto1A;
import org.usfirst.frc.team2509.robot.commands.Auto1B;
import org.usfirst.frc.team2509.robot.commands.Auto1C;
import org.usfirst.frc.team2509.robot.commands.Auto1D;
import org.usfirst.frc.team2509.robot.commands.Auto1E;
import org.usfirst.frc.team2509.robot.commands.Auto1F;
import org.usfirst.frc.team2509.robot.commands.Auto1G;
import org.usfirst.frc.team2509.robot.commands.Auto1H;
import org.usfirst.frc.team2509.robot.commands.Auto1J;
import org.usfirst.frc.team2509.robot.commands.Auto2A;
import org.usfirst.frc.team2509.robot.commands.Auto2B;
import org.usfirst.frc.team2509.robot.commands.Auto2C;
import org.usfirst.frc.team2509.robot.commands.Auto2D;
import org.usfirst.frc.team2509.robot.commands.Auto2E;
import org.usfirst.frc.team2509.robot.commands.Auto2F;
import org.usfirst.frc.team2509.robot.commands.Auto2G;
import org.usfirst.frc.team2509.robot.commands.Auto2H;
import org.usfirst.frc.team2509.robot.commands.Auto2I;
import org.usfirst.frc.team2509.robot.commands.Auto2J;
import org.usfirst.frc.team2509.robot.commands.Auto3A;
import org.usfirst.frc.team2509.robot.commands.Auto3B;
import org.usfirst.frc.team2509.robot.commands.Auto3C;
import org.usfirst.frc.team2509.robot.commands.Auto3D;
import org.usfirst.frc.team2509.robot.commands.Auto3E;
import org.usfirst.frc.team2509.robot.commands.Auto3F;
import org.usfirst.frc.team2509.robot.commands.Auto3G;
import org.usfirst.frc.team2509.robot.commands.Auto3H;
import org.usfirst.frc.team2509.robot.commands.Auto3I;
import org.usfirst.frc.team2509.robot.commands.OperatorDrive;
import org.usfirst.frc.team2509.robot.subsystems.Arm;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;

<<<<<<< HEAD
import edu.wpi.first.wpilibj.DriverStation;
=======
import edu.wpi.first.wpilibj.PIDOutput;
>>>>>>> origin/cole-auto
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
public class Robot extends TimedRobot implements PIDOutput{
	
	public static OI oi;
	public static DriveTrain drivetrain;
	public static Arm arm;
	public Command autonomousCommand;
	public Command operatorDrive;
	public Command Auto1I;
	public Command Auto1G;
	public Command Auto1A;
	public Command Auto1B;
	public Command Auto1C;
	public Command Auto1D;
	public Command Auto1F;
	public Command Auto1H;
	public Command Auto1J;
	public Command Auto2A;
	public Command Auto2B;
	public Command Auto2C;
	public Command Auto2D;
	public Command Auto2E;
	public Command Auto2F;
	public Command Auto2H;
	public Command Auto2I;
	public Command Auto2G;
	public Command Auto2J;
	public Command Auto3B;
	public Command Auto3A;
	public Command Auto3C;
	public Command Auto3D;
	public Command Auto3E;
	public Command Auto3F;
	public Command Auto3G;
	public Command Auto3I;
	public Command Auto1E;
	public Command Auto3H;
//	public Command Auto;
//	public Command Auto;
//	public Command Auto;
//	public Command Auto;
//	public Command Auto;
//	public Command Auto;
//	public Command Auto;
//	public Command Auto;


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
		Auto1A = new Auto1A();
		Auto1B = new Auto1B();
		Auto1C = new Auto1C();
		Auto1D = new Auto1D();
		Auto1F = new Auto1F();
		Auto1G = new Auto1G();
		Auto1H = new Auto1H();
		Auto1E = new Auto1E();
		Auto1J = new Auto1J();
		Auto2A = new Auto2A();
		Auto2B = new Auto2B();
		Auto2C = new Auto2C();
		Auto2D = new Auto2D();
		Auto2E = new Auto2E();
		Auto2F = new Auto2F();
		Auto2G = new Auto2G();
		Auto2H = new Auto2H();
		Auto2I = new Auto2I();
		Auto2J = new Auto2J();
		Auto3A = new Auto3A();
		Auto3B = new Auto3B();
		Auto3C = new Auto3C();
		Auto3D = new Auto3D();
		Auto3E = new Auto3E();
		Auto3F = new Auto3F();
		Auto3G = new Auto3G();
		Auto3I = new Auto3I();
		Auto3H = new Auto3H();
		Auto2A = new Auto2A();
		Auto2C = new Auto2C();
//		Auto = new Auto();
//		Auto = new Auto();
//		Auto = new Auto();
//		Auto = new Auto();
//		Auto = new Auto();
//		Auto = new Auto();
//		Auto = new Auto();
//		Auto = new Auto();
//		Auto = new Auto();
//		Auto = new Auto();
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
<<<<<<< HEAD
		autonomousCommand = oi.getAutonomous(oi.chooser.getSelected(), 
				DriverStation.getInstance().getGameSpecificMessage());
=======

		autonomousCommand = Auto1A;
//		autonomousCommand = Auto1B;
//		autonomousCommand = Auto1C;
//		autonomousCommand = Auto1D;
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
//		autonomousCommand = Auto;
//		autonomousCommand = Auto;
//		autonomousCommand = Auto;
//		autonomousCommand = Auto;
//		autonomousCommand = Auto;
//		autonomousCommand = Auto;
//		autonomousCommand = Auto;
//		autonomousCommand = Auto;
//		autonomousCommand = Auto;
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
>>>>>>> origin/cole-auto

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

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		
	}
}