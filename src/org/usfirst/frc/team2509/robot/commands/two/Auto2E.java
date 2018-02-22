package org.usfirst.frc.team2509.robot.commands.two;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.subsystems.Arm;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2509.robot.subsystems.Gripper;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto2E extends Command {
	Arm arm = Robot.arm;
	DriveTrain driveTrain = Robot.drivetrain;
	Gripper grip =  Robot.gripper;
    public Auto2E() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	grip.retract();//Picks Up the box
    	arm.armThreadMid.start();//Starts armThreadMid
    	
    	driveTrain.driveForward(60);//driving Forward 60 inches
    	driveTrain.rotate(-90);//turns left
    	driveTrain.driveForward(150);//drives forward 150 inches
    	driveTrain.rotate(90);//turns right
    	driveTrain.driveForward(210);//drives forward 210 inches
    	driveTrain.rotate(90);//turns right
    	driveTrain.driveForward(75);//drives forward 75 inches
    	driveTrain.rotate(90);//turns right
    	driveTrain.driveForward(40);//drives forward 40 inches
    	
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
