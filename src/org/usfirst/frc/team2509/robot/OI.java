/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2509.robot;

import org.usfirst.frc.team2509.robot.commands.ArmUp;
import org.usfirst.frc.team2509.robot.commands.ShiftDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick OperatorStick;
	public Joystick CoOperatorStick;
	private JoystickButton ShiftButton;
	private JoystickButton ArmButton;
	public SendableChooser<String> chooser = new SendableChooser<>();
	public String defaultAuto = "Default";
	public String Blue1 = "Blue 1";
	public String Blue2 = "Blue 2";
	public String Blue3 = "Blue 3";
	public String Red1 = "Red 1";
	public String Red2 = "Red 2";
	public String Red3 = "Red 3";
	private Command autoCommand;
	
	/**
	 * CREATING BUTTONS - 
	 * <p>One type of button is a joystick button which is any button on a joystick.
	 * You create one by telling it which joystick it's on and which button number it is.
	 * <p>Joystick stick = new Joystick(port);
	 * <p>Button button = new JoystickButton(stick, buttonNumber);
	 * <p>There are a few additional built in buttons you can use. Additionally,
	 * by subclassing Button you can create custom triggers and bind those to
	 * commands the same as any other Button.
	 * 
	 * <p>TRIGGERING COMMANDS WITH BUTTONS
	 * <p>Once you have a button, it's trivial to bind it to a button in one of three ways:
	 * <p>Start the command when the button is pressed and let it run the command until 
	 * it is finished as determined by it's isFinished method.
	 * <p>button.whenPressed(new ExampleCommand());
	 * <p>Run the command while the button is being held down and interrupt it once the 
	 * button is released.
	 * <p>button.whileHeld(new ExampleCommand());
	 * <p>Start the command when the button is released and let it run the command until 
	 * it is finished as determined by it's isFinished method.
	 * <p>button.whenReleased(new ExampleCommand());
	 * 
	 */
	public OI() {
		OperatorStick = new Joystick(0);
		CoOperatorStick = new Joystick(1);
		ShiftButton = new JoystickButton(OperatorStick, 2);
		ShiftButton.whenPressed(new ShiftDrive());
		ArmButton = new JoystickButton(OperatorStick,1);
		ArmButton.toggleWhenPressed(new ArmUp());
		
		chooser.addDefault("Default Auto", defaultAuto);
			chooser.addObject("Blue 1", Blue1);
			chooser.addObject("Blue 2", Blue2);
			chooser.addObject("Blue 3", Blue3);
			chooser.addObject("Red 1", Red1);
			chooser.addObject("Red 2", Red2);
			chooser.addObject("Red 3", Red3);
			SmartDashboard.putData("Auto choices", chooser);
			
			
		
	}
	/**
	 * When called constantly updates the SmartDashboard
	 */
	public Thread UpdateDashboard = new Thread(()->{
		while(true) {
			SmartDashboard.putNumber("Left Encoder", Robot.drivetrain.getLeftEncoder().get());
			SmartDashboard.putNumber("Right Encoder", Robot.drivetrain.getRightEncoder().get());
			SmartDashboard.putNumber("Gyro", Robot.drivetrain.getGyro().getAngle());
		}
	});
	public Command getAutonomous(String autoChoice, String gameData){
		switch(autoChoice) {
		case "Blue 1":
			if(gameData.charAt(0)=='L') {
				autoCommand = null;
			}else if(gameData.charAt(0)=='R') {
				autoCommand = null;
			}
			break;
		case "Blue 2":
			if(gameData.charAt(0)=='L') {
				autoCommand = null;
			}else if(gameData.charAt(0)=='R') {
				autoCommand = null;
			}
			break;
		case "Blue 3":
			if(gameData.charAt(0)=='L') {
				autoCommand = null;
			}else if(gameData.charAt(0)=='R') {
				autoCommand = null;
			}
			break;
		case "Red 1":
			if(gameData.charAt(0)=='L') {
				autoCommand = null;
			}else if(gameData.charAt(0)=='R') {
				autoCommand = null;
			}
			break;
		case "Red 2":
			if(gameData.charAt(0)=='L') {
				autoCommand = null;
			}else if(gameData.charAt(0)=='R') {
				autoCommand = null;
			}
			break;
		case "Red 3":
			if(gameData.charAt(0)=='L') {
				autoCommand = null;
			}else if(gameData.charAt(0)=='R') {
				autoCommand = null;
			}
			break;
		case "Default":
			default:
				if(gameData.charAt(0)=='L') {
					autoCommand = null;
				}else if(gameData.charAt(0)=='R') {
					autoCommand = null;
				}
				break;
		}
			return autoCommand;
			
	}
}
