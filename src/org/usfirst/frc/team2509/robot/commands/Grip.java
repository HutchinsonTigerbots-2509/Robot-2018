package org.usfirst.frc.team2509.robot.commands;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.subsystems.Gripper;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Grip extends Command {
	Gripper grip = Robot.gripper;
    public Grip() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	grip.extend();
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
    	grip.retract();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
