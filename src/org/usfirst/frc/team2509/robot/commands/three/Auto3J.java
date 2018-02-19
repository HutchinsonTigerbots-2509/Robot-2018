package org.usfirst.frc.team2509.robot.commands.three;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.commands.ArmHigh;
import org.usfirst.frc.team2509.robot.subsystems.Arm;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2509.robot.subsystems.Wrist;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class Auto3J extends Command {
	Arm arm = Robot.arm;
	DriveTrain driveTrain = Robot.drivetrain;
	Command armHigh = new ArmHigh();
	Wrist wrist = Robot.wrist;
    public Auto3J() {
    	// Use requires() here to declare subsystem dependencies
    	// eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain.driveForward(275);
    	driveTrain.rotate(-90);
    	driveTrain.driveBackward(15);
    	arm.armThreadHigh.start();
    	Timer.delay(3);
    	
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
    	arm.armThreadHigh.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
