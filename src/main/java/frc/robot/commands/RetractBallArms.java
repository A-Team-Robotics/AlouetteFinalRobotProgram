package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RetractBallArms extends CommandGroup{
    public RetractBallArms(){
        addParallel(new WaitArm2Position(622, true));
        addParallel(new WaitArm1Position(0, false));
    }
}