package org.usfirst.frc.team2509.robot.commands;

import org.usfirst.frc.team2509.robot.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbUp extends Command {
	private VictorSP Motor1 = RobotMap.ClimbMotor1;
	private VictorSP Motor2 = RobotMap.ClimbMotor2;

    public ClimbUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	Motor1.set(1.0);
    	Motor2.set(1.0);
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
    	Motor1.set(0.0);
    	Motor2.set(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
