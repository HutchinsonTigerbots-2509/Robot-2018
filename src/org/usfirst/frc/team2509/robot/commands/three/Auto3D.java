package org.usfirst.frc.team2509.robot.commands.three;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.commands.ArmMid;
import org.usfirst.frc.team2509.robot.subsystems.Arm;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2509.robot.subsystems.Gripper;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
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
    	//driveTrain.driveForward(2);
    	//arm.retractUpper();
    	grip.extend();
    	arm.armThreadMid.start();
    	driveTrain.driveForward(135.0); //Drive forward 135 inche
	    driveTrain.rotate(-90); //Turn left 90 degrees
	    driveTrain.driveForward(5.0); //Drive forward 5 inches
	    grip.retract();
	    Timer.delay(3);
	    driveTrain.driveBackward(10);
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
    }
}
