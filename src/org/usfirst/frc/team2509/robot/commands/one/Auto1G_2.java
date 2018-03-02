package org.usfirst.frc.team2509.robot.commands.one;

import org.usfirst.frc.team2509.robot.commands.ArmMid;
import org.usfirst.frc.team2509.robot.commands.DriveForward;
import org.usfirst.frc.team2509.robot.commands.DriveTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto1G_2 extends CommandGroup {

    public Auto1G_2() {
        // Add Commands here:
    	//What's going on?
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new DriveForward(210));
    	addSequential(new DriveTurn(90));
    	addParallel(new ArmMid());
    	addSequential(new DriveTurn(18));
    	addSequential(new DriveForward(20));
    	//Drop BOx
    	
    }
}
