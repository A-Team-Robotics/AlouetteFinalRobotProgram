package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.commands.*;

public class Climb extends CommandGroup{
    public Climb(){
       addSequential(new WaitElevatorPosition(18000, true));
       //
       addParallel(new WaitArm2Position(250, false));
       //
       addParallel(new WaitArm1Position(23438, true));
       //
       addSequential(new WaitArm2Position(219, true));
       //
       addSequential(new WaitElevatorPosition(RobotMap.elevatorPos1, false));
       //
       addParallel(new WaitArm1Position(29800, true));
       addParallel(new RollersSpeed(1));
    }
}