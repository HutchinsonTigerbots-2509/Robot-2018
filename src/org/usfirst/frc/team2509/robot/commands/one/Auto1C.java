package org.usfirst.frc.team2509.robot.commands.one;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto1C extends Command {
	DriveTrain dt = Robot.drivetrain;

    public Auto1C() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    dt.driveForward(140.0); //Drive forward 140 inches
    dt.rotate(90); //Turn right 92 degrees
//    dt.driveForward(10.0); //Drive forward 20 inches
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
