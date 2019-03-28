package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.*;

public class Climb extends CommandGroup{
    public Climb(){
       addSequential(new WaitElevatorPosition(58000));
       //
       addParallel(new WaitArm2Position(350));
       //
       addParallel(new WaitArm1Position(20438));
       //
       //addSequential(new WaitArm2Position(219));
       //
       //addParallel(new WaitArm1Position(29800));
    }
}