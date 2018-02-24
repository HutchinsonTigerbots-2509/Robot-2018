package org.usfirst.frc.team2509.robot.commands;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.subsystems.Arm;
import org.usfirst.frc.team2509.robot.subsystems.Gripper;
import org.usfirst.frc.team2509.robot.subsystems.Wrist;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class ArmSeq extends Command {
	Arm arm = Robot.arm;
	Gripper grip = Robot.gripper;
	Wrist wrist = Robot.wrist;

    public ArmSeq() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	/** ok so this is just some kind of psuedocode, since I know we're getting id of while loops, but  until i understand what... 
    	*... we're doing with that I'm just using this
    	*/
    	wrist.Down(0);//sets wrist to home position right away to avoid "accidents"
    	arm.retractUpper();//brings upper arm in
    	arm.rectractLower();//brings the "lift" down
    	Timer.delay(0.4);//waits 400ms; subject to change
    	if (arm.getLowerLimit().get() ) {
        	arm.Down();//rotates to home position if it isnt already
        }
    	arm.extendUpper();//then extends upper arm so robot is in position to grip and grab block
    	grip.extend();//opens up grippers, so its ready to take in a box
	
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
    	end();
    }
}
