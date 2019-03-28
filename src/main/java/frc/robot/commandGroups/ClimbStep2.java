package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.*;

public class ClimbStep2 extends CommandGroup{
    public ClimbStep2(){
       addSequential(new WaitElevatorPosition(58000));
       //
       addParallel(new WaitArm2Position(350));
       //
       addParallel(new WaitArm1Position(50438));
       //
       addSequential(new WaitElevatorPosition(20));
    }
}