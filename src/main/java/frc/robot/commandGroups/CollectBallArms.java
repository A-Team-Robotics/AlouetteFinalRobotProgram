package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.*;

public class CollectBallArms extends CommandGroup{
    public CollectBallArms(){
        addParallel(new WaitArm2Position(219, true));
        addParallel(new WaitArm1Position(29800, true));
    }
}