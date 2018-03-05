package org.usfirst.frc.team2509.robot.commands.three;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.commands.ArmMid;
import org.usfirst.frc.team2509.robot.subsystems.Arm;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2509.robot.subsystems.Gripper;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *Drives Forward 135 inches, turns left, drives forward five inches, and then drops the box into the switch
 */
public class Auto3D extends Command {
	Arm arm = Robot.arm;
	DriveTrain driveTrain = Robot.drivetrain;
	Command armMid = new ArmMid();
	Gripper grip = Robot.gripper;

    public Auto3D() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    	grip.retract();//Picks Up the box
    	arm.armThreadMid.start();//Starts armThreadMid
    	driveTrain.driveForward(135.0); //Drive forward 135 inches
	    driveTrain.rotate(-90); //Turn left 90 degrees
	    driveTrain.driveForward(5.0); //Drive forward 5 inches
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
