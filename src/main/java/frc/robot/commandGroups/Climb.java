package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.RobotMap.RollerSpeed;
import frc.robot.commands.*;

public class Climb extends CommandGroup{
    public Climb(){
       addSequential(new WaitElevatorPosition(18000));
       //
       addParallel(new WaitArm2Position(250));
       //
       addParallel(new WaitArm1Position(23438));
       //
       addSequential(new WaitArm2Position(219));
       //
       addSequential(new WaitElevatorPosition(RobotMap.elevatorPos1));
       //
       addParallel(new WaitArm1Position(29800));
       addParallel(new RollersSpeed(RollerSpeed.STOP));
    }
}