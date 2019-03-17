package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.RobotMap.RollerSpeed;
import frc.robot.commands.*;

public class CollectBall extends CommandGroup{
    public CollectBall(){
       addSequential(new WaitElevatorPosition(RobotMap.elevatorClearGripper, true));
       //
       addSequential(new WaitArm2Position(219,true));
       addSequential(new WaitArm1WaitArm2(0,0));
       //
       addSequential(new RollersSpeed(RollerSpeed.FORWARD));
       //
       addSequential(new WaitElevatorPosition(RobotMap.elevatorPos1, false));
       //
       addParallel(new LoadBall());
       //
       addSequential(new CollectorButtonAction());
       //
       addSequential(new TransferBall());
    }
}