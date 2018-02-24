package org.usfirst.frc.team2509.robot.commands;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {
	private DriveTrain drive = Robot.drivetrain;
	public double target = 0;
    public DriveForward(double targetDistance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drive);
    	double wheelDiameter = 6;
    	target = (targetDistance/(wheelDiameter*Math.PI))*3*360;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drive.getDrive().arcadeDrive(0.7, drive.getGyro().getAngle()*(0.1));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	drive.getDrive().arcadeDrive(0.7, drive.getGyro().getAngle()*(0.1));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return (drive.getRightEncoder().get()+drive.getLeftEncoder().get())/2>=target;
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
