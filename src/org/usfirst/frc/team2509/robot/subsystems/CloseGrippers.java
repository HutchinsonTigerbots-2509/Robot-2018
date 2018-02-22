package org.usfirst.frc.team2509.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *Close the grippers, but it doesn't work (SO IF YOU PLAN TO USE IT DON'T)
 */
public abstract class CloseGrippers extends Trigger {
    public boolean get(DigitalInput Grippers) {
        return Grippers.get();
    }
}