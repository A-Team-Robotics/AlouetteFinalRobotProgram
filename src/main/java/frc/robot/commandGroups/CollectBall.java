package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.RobotMap.RollerSpeed;
import frc.robot.commands.*;

public class CollectBall extends CommandGroup{
    public CollectBall(){
       addSequential(new WaitElevatorPosition(RobotMap.elevatorLoadPos1, true));
       //
       addSequential(new CollectBallArms());
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