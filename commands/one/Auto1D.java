package org.usfirst.frc.team2509.robot.commands.one;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.commands.ArmMid;
import org.usfirst.frc.team2509.robot.subsystems.Arm;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2509.robot.subsystems.Gripper;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *drives Forward 38 inches, turns right, drives forward 200 inches,  turns left, drives forward 72 inches, turns left, drives 
 *forward 30 inches, and drops the box into the switch
 */
public class Auto1D extends Command {
	DriveTrain driveTrain = Robot.drivetrain;
	Arm arm = Robot.arm;
	Command armMid = new ArmMid();
	Gripper grip = Robot.gripper;
	
    public Auto1D() {
       
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	grip.retract();//Picks Up the box
    	
    	driveTrain.driveForward(38);//drives Forward 38 inches
    	driveTrain.rotate(90);//turns right
    	driveTrain.driveForward(200);//drives Forward 200 inches
    	driveTrain.rotate(-90);//turns left
    	driveTrain.driveForward(72);//drives Forward 72 inches
    	
    	arm.armThreadMid.start();//Starts armThreadMid
    	
    	driveTrain.rotate(-90);//turns left
    	driveTrain.driveForward(30);//drives forward 30 inches
    	
    	grip.extend();//Lets go of the box so we can drop it
	    Timer.delay(3);//Sets a delay on armThreadMid
	    driveTrain.driveBackward(10);//Drives in reverse 10 Inches
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
