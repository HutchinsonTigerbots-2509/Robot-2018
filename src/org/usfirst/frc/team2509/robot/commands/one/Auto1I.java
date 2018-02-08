package org.usfirst.frc.team2509.robot.commands.one;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class Auto1I extends Command {
	DriveTrain driveTrain = Robot.drivetrain;
    public Auto1I() {
    	// Use requires() here to declare subsystem dependencies
    	// eg. requires(chassis);
    	driveTrain.driveForward(270);
    	driveTrain.rotate(90);
    	driveTrain.driveForward(218);
  
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
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
