package org.usfirst.frc.team2509.robot.commands.two;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto2F extends Command {
	DriveTrain driveTrain = Robot.drivetrain;
    public Auto2F() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain.driveForward(60);//drives forward 60 inches
    	driveTrain.rotate(90);//turns right
    	driveTrain.driveForward(150);//drives forward 150 inches
    	driveTrain.rotate(-90);//turns left
    	driveTrain.driveForward(180);//drives forward 180 inches
    	driveTrain.rotate(-90);//turns left
    	driveTrain.driveForward(75);//drives forward 75 inches
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
