package org.usfirst.frc.team2509.robot.commands;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.subsystems.Arm;
import org.usfirst.frc.team2509.robot.subsystems.Gripper;

import edu.wpi.first.wpilibj.command.Command;

/**
 *It moves the arm back into the position were it is able to pick up a box- bringing it to the home position
 */
public class HomeForTheArm extends Command {
	private Arm Arm = Robot.arm;
	private Gripper Grip = Robot.gripper;

    public HomeForTheArm() {
    	requires(Robot.arm);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Grip.retract();
    	Arm.retractUpper();
    	Arm.armThreadDown.start();
    	Arm.extendLower();
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
    	Arm.armThreadDown.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
