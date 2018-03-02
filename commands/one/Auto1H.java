package org.usfirst.frc.team2509.robot.commands.one;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.commands.ArmMid;
import org.usfirst.frc.team2509.robot.subsystems.Arm;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto1H extends Command {
	Arm arm = Robot.arm;
	DriveTrain driveTrain = Robot.drivetrain;
	Command armMid = new ArmMid();
    public Auto1H() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	driveTrain.driveForward(220);//drive forward 220 inches
    	driveTrain.rotate(90);//turn right
    	driveTrain.driveForward(270);//drive forward 270 inches
    	driveTrain.rotate(-90);//turn left
    	driveTrain.driveForward(50);//drive forward 50 inches
    	driveTrain.rotate(-90);//turn left
    	arm.armThreadMid.start();//start lifting arm
    	Timer.delay(3);//waits 3 seconds to simulate dropping off the box
 	    driveTrain.driveBackward(15);//drive backward 15 inches
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain.driveForward(210);//drives forward 210
    	driveTrain.rotate(90);//turns right
    	driveTrain.driveForward(18);//drives forward 18
    	driveTrain.rotate(-90);//turns left
    	driveTrain.driveForward(20);//drives forward 20
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
    	arm.armThreadMid.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
