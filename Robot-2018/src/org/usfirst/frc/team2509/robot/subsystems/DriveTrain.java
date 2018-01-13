package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
/**
 *
 */
public class DriveTrain extends Subsystem {
	private final WPI_TalonSRX Driveleft1 = RobotMap.DT_LEFT1;
	private final WPI_TalonSRX Driveleft2 = RobotMap.DT_LEFT2;
	private final WPI_TalonSRX Driveright1 = RobotMap.DT_RIGHT1;
	private final WPI_TalonSRX DrIVeright2 = RobotMap.DT_RIGHT2;
	private final DifferentialDrive DRIVETRAIN = RobotMap.myDrive;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    }
    	public DifferentialDrive getDrive(){
    		return DRIVETRAIN;
    	}
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }


