package org.usfirst.frc.team2509.robot.commands;

import org.usfirst.frc.team2509.robot.OI;
import org.usfirst.frc.team2509.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class OpDrive extends Command {
	private OI OI = Robot.oi;
	private DifferentialDrive DRIVETRAIN = Robot.driveTrain.getDrive();

    public OpDrive() {
    	requires(Robot.driveTrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
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
