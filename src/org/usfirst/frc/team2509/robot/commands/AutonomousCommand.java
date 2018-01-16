package org.usfirst.frc.team2509.robot.commands;

import org.usfirst.frc.team2509.robot.RobotMap;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
/**
 *
 */
public class AutonomousCommand extends Command {
	DifferentialDrive DT=RobotMap.Drive;
	SpeedControllerGroup Left=RobotMap.DTG_LEFT;
	SpeedControllerGroup Right=RobotMap.DTG_RIGHT;
	ADXRS450_Gyro gyro = RobotMap.gyro;
	Encoder enc1 = RobotMap.enc1;
	Encoder enc2 = RobotMap.enc2;
	
	public AutonomousCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	gyro.reset();
    	enc1.reset();
    	enc2.reset();
    	Timer.delay(0.1);
    	int targetDistance = 2872*3;
    	while(((enc1.get()-enc2.get())/2)<=targetDistance) {
    		DriveTrain.arcadeDrive(0.75, gyro.getAngle()*(0.03));//0.03
    	}
    
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
