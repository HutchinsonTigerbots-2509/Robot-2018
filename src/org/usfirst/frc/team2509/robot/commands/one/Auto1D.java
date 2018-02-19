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
public class Auto1D extends Command {
	DriveTrain driveTrain = Robot.drivetrain;
	Arm arm = Robot.arm;
	Command armMid = new ArmMid();
    public Auto1D() {
       
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain.driveForward(38);
    	driveTrain.rotate(90);
    	driveTrain.driveForward(200);
    	driveTrain.rotate(-90);
    	
    	driveTrain.driveForward(72);
    	driveTrain.rotate(-90);
    	arm.armThreadMid.start();
    	driveTrain.driveForward(30);
    	Timer.delay(3);
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
    	arm.armThreadMid.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
