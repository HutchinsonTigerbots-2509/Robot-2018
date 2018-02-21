package org.usfirst.frc.team2509.robot.commands.two;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto2G extends Command {
	DriveTrain driveTrain = Robot.drivetrain;
    public Auto2G() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	driveTrain.driveForward(60);//drives forward 60 inches
    	driveTrain.rotate(-90);//turns left
    	driveTrain.driveForward(150);//drives forward 150 inches
    	driveTrain.rotate(90);//turns right
    	driveTrain.driveForward(240);//drives forward 240 inches
    	driveTrain.rotate(90);//turns right
    	driveTrain.driveForward(90);//drives forward 90 inches
    	driveTrain.rotate(-90);//turns left
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
