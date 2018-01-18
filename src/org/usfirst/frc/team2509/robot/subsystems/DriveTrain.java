package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


/**
 *
 */
public class DriveTrain extends Subsystem {
	WPI_TalonSRX LEFT1 = RobotMap.DT_LEFT1;
	WPI_TalonSRX LEFT2 = RobotMap.DT_LEFT2;
	WPI_TalonSRX RIGHT1 = RobotMap.DT_RIGHT1;
	WPI_TalonSRX RIGHT2 = RobotMap.DT_RIGHT2;
	Encoder enc = RobotMap.enc1; 
	SpeedControllerGroup DTG_LEFT = RobotMap.DTG_LEFT;
	SpeedControllerGroup DTG_RIGHT = RobotMap.DTG_RIGHT;
	
	DifferentialDrive Drive = RobotMap.Drive;
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void drive(Joystick STICK) {
		Drive.arcadeDrive(STICK.getY(), STICK.getZ());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	public static void arcadeDrive(double d, double e) {
		// TODO Auto-generated method stub
		
	}
}

