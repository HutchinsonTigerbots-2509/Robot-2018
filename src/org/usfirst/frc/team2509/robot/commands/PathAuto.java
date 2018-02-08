package org.usfirst.frc.team2509.robot.commands;

import java.sql.Time;
import java.util.ArrayList;

import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.RobotMap;
import org.usfirst.frc.team2509.robot.pathplanner.FalconPathPlanner;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;

import org.usfirst.frc.team2509.robot.subsystems.BoxVision;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2509.robot.subsystems.vision;

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
	DriveTrain dt = Robot.drivetrain;
	BoxVision BX = Robot.boxVision;
	SpeedControllerGroup Right=RobotMap.DriveTrain_Left; 
	DriveTrain dt = Robot.drivetrain;
	vision VT = Robot.Vision;
	SpeedControllerGroup Left =RobotMap.DriveTrain_Right;
	ADXRS450_Gyro gyro = RobotMap.DriveTrain_Gyro;
	Encoder encL = RobotMap.DriveTrain_LeftEncoder;
	Encoder encR = RobotMap.DriveTrain_LeftEncoder;
	Mat cam = RobotMap.Box_camera;
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
    	int Speed_Right_calculation = (int) ((encR.get()) / System.currentTimeMillis());
    	//PIDSource Speed_Left_Calculation2 = Speed_Left_calculation;
    	//PIDSource Speed_Right_Calculation2 = Speed_Right_calculation;
    	double totalTime = 15; //max seconds we want to drive the path
    	double timeStep = 0.001; //period of control loop on Rio, seconds
    	double robotTrackWidth = 2.375; //distance between left and right wheels, feet
    	FalconPathPlanner path = new FalconPathPlanner(waypoints);
    	path.calculate(totalTime, timeStep, robotTrackWidth);
    	double[][] Speed_Left = path.smoothLeftVelocity;
    	double[][] Speed_Right = path.smoothRightVelocity;
    	//PIDController SpeedRight = new PIDController(0.04, 0.0002, 0.0001, 0.1, Speed_Left_calculation, Right);
    	//PIDController SpeedLeft = new PIDController(0.04, 0.0002, 0.0001, 0.1, encL, Left);
    	DT.arcadeDrive(0.5, 0);
    	Timer.delay(0.5);
    	//SpeedRight.setOutputRange(-1, 1);
    	while (gyro.getAngle() > -165){
    		Right.set(0.82);//0.65  -  0.35
    		Left.set(-0.25);//-0.25  -  -0.1
    		
    	
    		
    		
    		
    		
    		
    		// Place your code here.
    	
    	
    		
    	
    	}
    	
    	BX.process(cam);
    	for (MatOfPoint contour : BX.filterContoursOutput()) {
    		final Rect bb = Imgproc.boundingRect(contour);
    		double x = bb.x;
    		double angle_to_target = Math.atan((x-319.5)/554.25);
    		double angle_to_target_degrees1=Math.toDegrees(angle_to_target);
    		
    	
    	}
    	dt.rotate(angle_to_target_degrees);
    	//*DT.arcadeDrive(0.5, 0);
    	//Timer.delay(2);
    	//DT.arcadeDrive(0, 0);
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
