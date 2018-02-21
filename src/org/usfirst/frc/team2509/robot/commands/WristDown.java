package org.usfirst.frc.team2509.robot.commands;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2509.robot.*;
import org.usfirst.frc.team2509.robot.subsystems.Wrist;

/**
 *
 */
public class WristDown extends Command {
	private Wrist wrist = Robot.wrist;
    public WristDown() {
    	requires(Robot.wrist);
//    	requires(wrist);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    //wrist2.set(-0.8);
   	wrist.Down(10);
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
    	wrist.Idle();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
