package org.usfirst.frc.team2509.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public abstract class CloseGrippers extends Trigger {
    public boolean get(DigitalInput Grippers) {
        return Grippers.get();
    }
}