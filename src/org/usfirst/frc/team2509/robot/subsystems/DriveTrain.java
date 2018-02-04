package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends Subsystem implements PIDOutput{
	//Subsystem Variables
	private static DoubleSolenoid Shifter = RobotMap.DriveTrain_Shifter;
	private static Encoder LeftEncoder = RobotMap.DriveTrain_LeftEncoder;
	private static Encoder RightEncoder = RobotMap.DriveTrain_RightEncoder;
	private static ADXRS450_Gyro Gyro = RobotMap.DriveTrain_Gyro;
	private static WPI_TalonSRX Left_1 = RobotMap.DriveTrain_left1;
	private static WPI_TalonSRX Left_2 = RobotMap.DriveTrain_left2;
	private static WPI_TalonSRX Left_3 = RobotMap.DriveTrain_left3;
	private static WPI_TalonSRX Right_1 = RobotMap.DriveTrain_right1;
	private static WPI_TalonSRX Right_2 = RobotMap.DriveTrain_right2;
	private static WPI_TalonSRX Right_3 = RobotMap.DriveTrain_right3;
	private static SpeedControllerGroup Left = RobotMap.DriveTrain_Left;
	private static SpeedControllerGroup Right = RobotMap.DriveTrain_Right;
	private static DifferentialDrive Drive = RobotMap.RobotDrive;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void drive(Joystick stick) {
    	Drive.arcadeDrive(stick.getY(), stick.getZ());
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
    	Timer.delay(0.05);
    	if(Gyro.getAngle()<targetAngle) {
    		while(Gyro.getAngle()<targetAngle)	Drive.tankDrive(-0.5, 0.5);
    		Drive.tankDrive(0, 0);
    	}else if(Gyro.getAngle()>targetAngle) {
    		while(Gyro.getAngle()>targetAngle)Drive.tankDrive(0.5, -0.5);
    		Drive.tankDrive(0, 0);
    	}else {
    		Drive.tankDrive(0, 0);
    	}
    	}
    public void AccDrive(double targetDistance) {
    	sensorReset();
    	double wheelDiameter = 6;
    	double target = (targetDistance/(wheelDiameter*Math.PI))*3*360;
    	Timer.delay(0.1);
    	double CurrentDistance = ((RightEncoder.get()+LeftEncoder.get())/2);
    	double AccelGain = 1.05;
    	double DecelGain = 0.95;
    	double Speed = 0.25;
    	double TimeDelay = 0.015;
    	while(CurrentDistance <= target/2) {
    		if(Speed >= 0.9) {
    			Drive.arcadeDrive(Speed, Gyro.getAngle()*(0.15));
    			Timer.delay(TimeDelay);
    		}
    		else {
    			Speed = Speed * AccelGain;
    			Drive.arcadeDrive(Speed, Gyro.getAngle()*(0.15));
    			Timer.delay(TimeDelay);
    		}
    	}
    	while(CurrentDistance < target){
    		if(Speed > 0.35) {
    			Speed = Speed * DecelGain;
    			Drive.arcadeDrive(Speed, Gyro.getAngle()*(0.15));
    			Timer.delay(TimeDelay);
    		}
    		else {
    			Drive.arcadeDrive(Speed, Gyro.getAngle()*(0.15));
    			Timer.delay(TimeDelay);
    		}
    	}
    	Drive.tankDrive(0, 0);
    }
    public void AccDriveMark2(double targetDistance) {
    	sensorReset();
    	double wheelDiameter = 6;
    	double target = (targetDistance/(wheelDiameter*Math.PI))*3*360;
    	Timer.delay(0.1);
    	double CurrentDistance = ((RightEncoder.get()+LeftEncoder.get())/2);
    	double TimeDelay = 0.015;
    	double MaxVolts = 0.9;
    	double MinVolts = 0.35;
    	double VoltsRange = MaxVolts-MinVolts;
    	while(CurrentDistance <= target/2) {
    	double AccelVolts = (VoltsRange*CurrentDistance)/(target/2);
    		Drive.arcadeDrive(Math.max(AccelVolts, MinVolts), Gyro.getAngle()*(0.15));
			Timer.delay(TimeDelay);
    	}
    	while(CurrentDistance < target){
    	double DecelVolts = (VoltsRange*(target-CurrentDistance))/(target/2);
    		Drive.arcadeDrive(Math.max(DecelVolts, MinVolts), Gyro.getAngle()*(0.15));
			Timer.delay(TimeDelay);
    	}
    	Drive.tankDrive(0, 0);
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
    	while((RightEncoder.get()-LeftEncoder.get())/2<=target) {
    		Drive.arcadeDrive(0.5, Gyro.getAngle()*(0.15));
    	}
    	Drive.tankDrive(0, 0);
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
    public ADXRS450_Gyro getGyro() {
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
    public Talon getLeft1() {
    	return Left_1;
    }
    /**
     * 
     * @return DriveTrain_Left_2
     */
    public Talon getLeft2() {
    	return Left_2;
    }
    /**
     * 
     * @return DriveTrain_Left_3
     */
    public Talon getLeft3() {
    	return Left_3;
    }
    /**
     * 
     * @return DriveTrain_Right_1
     */
    public Talon getRight1() {
    	return Right_1;
    }
    /**
     * 
     * @return DriveTrain_Right_2
     */
    public Talon getRight2() {
    	return Right_2;
    }
    /**
     * 
     * @return DriveTrain_Ri6ght_3
     */
    public Talon getRight3() {
    	return Right_3;
    }
	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		
	}

}