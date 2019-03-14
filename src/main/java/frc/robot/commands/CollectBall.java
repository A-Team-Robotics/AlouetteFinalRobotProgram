package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;

public class CollectBall extends CommandGroup{
    public CollectBall(){
       addSequential(new WaitElevatorPosition(RobotMap.elevatorLoadPos1, true));
       //
       addSequential(new CollectBallArms());
       //
       addSequential(new RollersSpeed(1));
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