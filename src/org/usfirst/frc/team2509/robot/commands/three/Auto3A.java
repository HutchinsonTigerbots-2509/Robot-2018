package org.usfirst.frc.team2509.robot.commands.three;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.commands.ArmMid;
import org.usfirst.frc.team2509.robot.subsystems.Arm;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2509.robot.subsystems.Gripper;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *Drives Forward 35 in., Turns Left, Drives Forward 140 in., Turns Right, and Drives Foward 26 Inches during Autonomous so we can go to
 *position 1A.
 */
public class Auto3A extends Command {
	DriveTrain driveTrain = Robot.drivetrain;
	Arm arm = Robot.arm;
	Gripper grip = Robot.gripper;
	Command armMid = new ArmMid();
    public Auto3A() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	grip.retract();//Picks Up the box
    	arm.armThreadMid.start();//Starts armThreadMid
    	
    	driveTrain.driveForward(35);//Drives Forward 35 Inches
    	driveTrain.rotate(-90);//Turns Left 
    	driveTrain.driveForward(140);//Drives Forward 140 Inches
    	driveTrain.rotate(90);//Rotates to the Right
    	driveTrain.driveForward(26);//Drives Forward 26 Inches
    	
    	grip.extend();//Lets go of the box so we can drop it
    	Timer.delay(3);//Sets Timer Delay for the Robot
    	driveTrain.driveBackward(30);//Moves the Robot Backwards
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
    	arm.armThreadMid.stop();//Stops armThreadMid
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
