package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

/**
 *Here contains all of our methods -- drive, sensorReset, rotate, shift, driveForward, driveBackward, getShifter,
 * getLeftEncoder, getRightEncoder, getGyro, getLeft, getRight, getDrive, getLeft1, getLeft2, getLeft3, getRight1, getRight2,
 * getRight3, and pidWrite
 */
public class DriveTrain extends Subsystem implements PIDOutput{
	//Subsystem Variables
	private static DoubleSolenoid Shifter = RobotMap.DriveTrain_Shifter;
	private static Encoder LeftEncoder = RobotMap.DriveTrain_LeftEncoder;
	private static Encoder RightEncoder = RobotMap.DriveTrain_RightEncoder;
	private static AHRS Gyro = RobotMap.DriveTrain_NavX;
	
	private static WPI_TalonSRX Left_1 = RobotMap.DriveTrain_left1;
	private static WPI_TalonSRX Left_2 = RobotMap.DriveTrain_left2;
	
	private static WPI_TalonSRX Right_1 = RobotMap.DriveTrain_right1;
	private static WPI_TalonSRX Right_2 = RobotMap.DriveTrain_right2;
	private static SpeedControllerGroup Left = RobotMap.DriveTrain_Left;
	private static SpeedControllerGroup Right = RobotMap.DriveTrain_Right;
	private static DifferentialDrive Drive = RobotMap.RobotDrive;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//For a reason unknown to you
    }
    /**
     * Allows use to arcadeDrive with one Joystick using the Y-axis and Z-axis
     */
    public void drive(Joystick stick) {
    	Drive.arcadeDrive(-stick.getY(), -stick.getZ()*0.7);
    	SmartDashboard.putNumber("Left_Speed", Left_1.getSelectedSensorVelocity(0));
		SmartDashboard.putNumber("Left_Postion", Left_1.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Right_Speed",  Right_1.getSelectedSensorVelocity(0));
		SmartDashboard.putNumber("Right_Position",  Right_1.getSelectedSensorPosition(0));
    }
    /**
     * Resets all sensors
     */
    public void sensorReset() {
    	Gyro.reset();
    	RightEncoder.reset();
    	LeftEncoder.reset();
    }
    /**
     * Gets angle from the Gyro to tell the motors to make a specific turn
     * @param Angle
     */
    public void rotate(double targetAngle) {
    	Gyro.reset();
    	Timer.delay(0.1);
    	if(Gyro.getAngle()<targetAngle) {
    		while(Gyro.getAngle()<targetAngle)	Drive.tankDrive(-0.6, 0.6);
    		Drive.tankDrive(0, 0);
    	}else if(Gyro.getAngle()>targetAngle) {
    		while(Gyro.getAngle()>targetAngle)Drive.tankDrive(0.6, -0.6);
    		Drive.tankDrive(0, 0);
    	}else {
    		Drive.tankDrive(0, 0);
    	}
    	if(Gyro.getAngle()<targetAngle) {
    		while(Gyro.getAngle()<targetAngle)	Drive.tankDrive(-0.6, 0.6);
    		Drive.tankDrive(0, 0);
    	}else if(Gyro.getAngle()>targetAngle) {
    		while(Gyro.getAngle()>targetAngle)Drive.tankDrive(0.6, -0.6);
    		Drive.tankDrive(0, 0);
    	}else {
    		Drive.tankDrive(0, 0);
    	}
    }
    
    /**
     * Switches the gear between high and low, with a double solenoid.
     * @param isExtended
     */
    public void shift(boolean isExtended) {
    	if(isExtended) {
    		Shifter.set(DoubleSolenoid.Value.kForward);
    	}
    	else {
    		Shifter.set(DoubleSolenoid.Value.kReverse);
    	}
    }
    
    /**
     * When called will drive forward.
     * You need to input inches as a target value.
     * @param targetDistance
     */
    public void driveForward(double targetDistance) {
    	sensorReset();
    	double wheelDiameter = 6;
    	double target = (targetDistance/(wheelDiameter*Math.PI))*3*360;
    	Timer.delay(0.1);
    	while((RightEncoder.get()+LeftEncoder.get())/2<=target) {
    		Drive.arcadeDrive(0.7, Gyro.getAngle()*(0.1));
    	}
    	Drive.tankDrive(0, 0);
    }
    /**
     * When called will drive backward
     * Input inches as a target value
     * @param targetDistance
     */
    public void driveBackward(double targetDistance) {
    	sensorReset();
    	double wheelDiameter = 6;
    	double target = (targetDistance/(wheelDiameter*Math.PI))*3*360;
    	Timer.delay(0.1);
    	while((RightEncoder.get()+LeftEncoder.get())/2>=(target*(-1))) {
    		Drive.arcadeDrive(-0.5, Gyro.getAngle()*(0.1));
    	}
    	Drive.tankDrive(0, 0);
    }
    
    public void motion_magic(int targetDistance, int Cruise, int accell) {
    	Left_1.setSelectedSensorPosition(0, 0, 0);
    	Right_1.setSelectedSensorPosition(0, 0, 0);
    	//Right_2.set(ControlMode.Follower, 4);
    	//Left_2.set(ControlMode.Follower, 2);
    	Left_1.config_kD(0, 0.001, 0);
    	Left_1.config_kP(0, 0.4, 0);
    	Left_1.config_kI(0, 0.0001, 0);
    	Left_1.config_kF(0, 0.01, 0);
    	Left_1.configMotionCruiseVelocity(Cruise, 0);
    	Left_1.configMotionAcceleration(accell, 0);
    	Left_1.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 10);
    	Left_1.set(ControlMode.MotionMagic, targetDistance);
    	//Right_1.config_kD(1, 0.001, 10);
    	//Right_1.config_kP(1, 0.4, 10);
    	//Right_1.config_kI(1, 0.0001, 10);
    	//Right_1.config_kF(1, 0.01, 10);
    	//Right_1.configMotionCruiseVelocity(Cruise, 10);
    	//Right_1.configMotionAcceleration(accell, 10);
    	//Right_1.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 10);
    	//Right_1.set(ControlMode.MotionMagic, targetDistance);
    	
    	
    }
    
    /**
     * 
     * @return DriveTrain_Shifter
     */
    public DoubleSolenoid getShifter() {
    	return Shifter;
    }
    /**
     * 
     * @return DriveTrain_LeftEncoder
     */
    public Encoder getLeftEncoder() {
    	return LeftEncoder;
    }
    /**
     * 
     * @return DriveTrain_RightEncoder
     */
    public Encoder getRightEncoder() {
    	return RightEncoder;
    }
    /**
     * 
     * @return DriveTrain_Gyro
     */
    public AHRS getGyro() {
    	//return Gyro;
    	return Gyro;
    }
    /**
     * 
     * @return DriveTrain_Left
     */
    public SpeedControllerGroup getLeft() {
    	return Left;
    }
    /**
     * 
     * @return DriveTrain_Right
     */
    public SpeedControllerGroup getRight() {
    	return Right;
    }
    /**
     * 
     * @return DriveTrain_Drive
     */
    public DifferentialDrive getDrive() {
    	return Drive;
    }
    /**
     * 
     * @return DriveTrain_Left_1
     */
    public WPI_TalonSRX getLeft1() {
    	return Left_1;
    }
    /**
     * 
     * @return DriveTrain_Left_2
     */
    public WPI_TalonSRX getLeft2() {
    	return Left_1;
    }
    /**
     * 
     * @return DriveTrain_Left_3
     */
    public WPI_TalonSRX getLeft3() {
    	return Left_2;
    }
    /**
     * 
     * @return DriveTrain_Right_1
     */
    public WPI_TalonSRX getRight1() {
    	return Right_1;
    }
    /**
     * 
     * @return DriveTrain_Right_2
     */
    public WPI_TalonSRX getRight2() {
    	return Right_1;
    }
    /**
     * 
     * @return DriveTrain_Ri6ght_3
     */
    public int getLeft_Speed() {
    	return Left_1.getSelectedSensorVelocity(0);
    }
    public int getLeft_position() {
    	return Left_1.getSelectedSensorPosition(0);
    }
    public int getRight_speed() {
    	return Right_1.getSelectedSensorVelocity(1);
    }
    public int getRight_postion() {
    	return Right_1.getSelectedSensorPosition(1);
    }
    
	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		
	}

}