package org.usfirst.frc.team2509.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.RobotMap;
import org.usfirst.frc.team2509.robot.subsystems.Climber;


/**
 *
 */
public class ClimbUp extends Command {
	private Climber climb = Robot.climber;
    public ClimbUp() {
    	requires(Robot.climber);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	climb.ClimbUp(); //sets motors to 1, this is in subsystem not command
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
    	climb.ClimbStop(); //sets motors to 0, should keep the robot in place via motor braking, this is in subsystem not command
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
