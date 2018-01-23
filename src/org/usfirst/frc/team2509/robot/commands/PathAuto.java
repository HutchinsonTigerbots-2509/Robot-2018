package org.usfirst.frc.team2509.robot.commands;

import org.usfirst.frc.team2509.robot.RobotMap;
import org.usfirst.frc.team2509.robot.pathplanner.FalconPathPlanner;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;

import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
/**
 *
 */
public class PathAuto extends Command {
	DifferentialDrive DT=RobotMap.RobotDrive;
	SpeedControllerGroup Left=RobotMap.DriveTrain_Left;
	SpeedControllerGroup Right=RobotMap.DriveTrain_Left;
	ADXRS450_Gyro gyro = RobotMap.DriveTrain_Gyro;
	Encoder encL = RobotMap.DriveTrain_LeftEncoder;
	Encoder encR = RobotMap.DriveTrain_LeftEncoder;
	public PathAuto() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	gyro.reset();
    	encL.reset();
    	encR.reset();
    	Timer.delay(0.1);
    	
    	double[][] waypoints = new double[][]{
    		{0, 0},
    		{0, 1},
    		{0,2},
    		{0,3},
    		{0.41, 4.166},
    		{1.5, 5},
    		{2.2083, 5.1666},
    		{2.8333, 5},
    		{3.9166, 4.166},
    		{4.333, 3},
    		{4.333, 2},
    		{4.333, 1},
    		{4.333, 0}
    		
    	}; 
    	int Number_Of_Loops = 0;
    	double totalTime = 15; //max seconds we want to drive the path
    	double timeStep = 0.001; //period of control loop on Rio, seconds
    	double robotTrackWidth = 2.375; //distance between left and right wheels, feet
    	FalconPathPlanner path = new FalconPathPlanner(waypoints);
    	path.calculate(totalTime, timeStep, robotTrackWidth);
    	double[][] Speed_Left = path.smoothLeftVelocity;
    	double[][] Speed_Right = path.smoothRightVelocity;
    	PIDController SpeedRight = new PIDController(0.04, 0.0002, 0.0001, 0.1, encR, Right);
    	PIDController SpeedLeft = new PIDController(0.04, 0.0002, 0.0001, 0.1, encL, Left);
    	while (Number_Of_Loops < Speed_Right.length){
    		SpeedLeft.setSetpoint(path.smoothLeftVelocity[Number_Of_Loops][1] / 2.5);
    		SpeedRight.setSetpoint(path.smoothRightVelocity[Number_Of_Loops][1] / 2.5);
    		SpeedLeft.disable();
    		SpeedRight.disable();
    		System.out.println(Speed_Right.length);
    		
    		Number_Of_Loops = (Number_Of_Loops + 1);
    		
    		
    		
    		// Place your code here.
    	}
    	
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
