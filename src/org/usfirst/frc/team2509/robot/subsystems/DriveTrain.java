package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {
	//Subsystem Variables
	private static DoubleSolenoid Shifter = RobotMap.DriveTrain_Shifter;
	private static Encoder LeftEncoder = RobotMap.DriveTrain_LeftEncoder;
	private static Encoder RightEncoder = RobotMap.DriveTrain_RightEncoder;
	private static ADXRS450_Gyro Gyro = RobotMap.DriveTrain_Gyro;
	private static Talon Left_1 = RobotMap.DriveTrain_left1;
	private static Talon Left_2 = RobotMap.DriveTrain_left2;
	private static Talon Left_3 = RobotMap.DriveTrain_left3;
	private static Talon Right_1 = RobotMap.DriveTrain_right1;
	private static Talon Right_2 = RobotMap.DriveTrain_right2;
	private static Talon Right_3 = RobotMap.DriveTrain_right3;
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
     * @param target
     */
    public void driveForward(double targetDistance) {
    	double target = targetDistance/18.849555921539*3*360;
    	RightEncoder.reset();
    	LeftEncoder.reset();
    	while((RightEncoder.get()-LeftEncoder.get())/2<=target) {
    		Drive.arcadeDrive(0.5, Gyro.getAngle()*(0.03));
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
     * @return DriveTrain_Right_3
     */
    public Talon getRight3() {
    	return Right_3;
    }

}

