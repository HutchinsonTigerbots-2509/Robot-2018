package org.usfirst.frc.team2509.robot.commands.one;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.commands.ArmMid;
import org.usfirst.frc.team2509.robot.subsystems.Arm;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2509.robot.subsystems.Gripper;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *Drives Forward 140 inches, turns right, drives forward 10 inches, drives foward 8 inches,
 * and drops the box into the switch
 */
public class Auto1C extends Command {
	Arm arm = Robot.arm;
	DriveTrain driveTrain = Robot.drivetrain;
	Command armMid = new ArmMid();
	Gripper grip = Robot.gripper;
	
	
    public Auto1C() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	grip.retract();//Picks Up the box
    	arm.armThreadMid.start();//Starts armThreadMid
    	
    	driveTrain.driveForward(140.0); //Drive forward 140 inches
    	driveTrain.rotate(90); //Turn right 90 degrees
      	driveTrain.driveForward(10.0); //Drive forward 10
    	driveTrain.driveForward(8);//Drive forward 8 inches
 	    
    	grip.extend();//Lets go of the box so we can drop it
	    Timer.delay(3);//Sets a delay on armThreadMid    	
 	    driveTrain.driveBackward(15);
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
