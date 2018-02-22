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
public class Auto2H extends Command {
	Arm arm = Robot.arm;
	DriveTrain driveTrain = Robot.drivetrain;
	Gripper grip =  Robot.gripper;
    public Auto2H() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	grip.retract();//Picks Up the box
    	arm.armThreadMid.start();//Starts armThreadMid
    	
    	driveTrain.driveForward(60);//drives forward 60 inches
    	driveTrain.rotate(90);//turns right
    	driveTrain.driveForward(150);//drives forward 150 inches
    	driveTrain.rotate(-90);//turns left
    	driveTrain.driveForward(240);//drives forward 240 inches
    	driveTrain.rotate(-90);//turns left
    	driveTrain.driveForward(45);//drives forward 45 inches
    	driveTrain.rotate(90);//turns left
    	driveTrain.driveForward(15);//drives forward 15 inches
    	
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
