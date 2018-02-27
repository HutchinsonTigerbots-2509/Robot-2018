package org.usfirst.frc.team2509.robot.commands;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTurn extends Command {
	private DriveTrain drive = Robot.drivetrain;
	private double target = 0;
	private double turnSpeed = 0.6;
	private Boolean turnRight;
	private Boolean turnLeft;
    public DriveTurn(double targetAngle) {
    	requires(drive);
    	target = targetAngle;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drive.sensorReset();
    	Timer.delay(0.1);
    	if(drive.getGyro().getAngle()<target) {
    		turnRight = true;
    		turnLeft = false;
    	}else if(drive.getGyro().getAngle()>target){
    		turnRight = false;
    		turnLeft = true;
    	}
    	if(turnRight) {
    		drive.getDrive().tankDrive(turnSpeed, -turnSpeed);
    	}else if(turnLeft) {
    		drive.getDrive().tankDrive(-turnSpeed, turnSpeed);
    	}else {
    		end();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(turnRight) {
    		return drive.getGyro().getAngle()>target;
    	}else if(turnLeft) {
    		return drive.getGyro().getAngle()<target;
    	}else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	drive.getDrive().tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
