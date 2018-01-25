package org.usfirst.frc.team2509.robot.commands;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto3F extends Command {
	DriveTrain dt = Robot.drivetrain;

    public Auto3F() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    dt.driveForward(197); //Drive forward 197 inches
   	Timer.delay(2); //Wait 2 seconds
   	dt.rotate(-90.0); //Turn right 90 degrees
   	Timer.delay(2.0); //Wait 2 seconds
   	dt.driveForward(80); //Drive forward 80 inches
   	Timer.delay(2.0); //Wait 2 seconds
    dt.rotate(-90.0); //Turn left 90 degrees
    	
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
