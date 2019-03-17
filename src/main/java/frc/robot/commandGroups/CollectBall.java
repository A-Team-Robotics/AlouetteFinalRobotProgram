package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.RobotMap.RollerSpeed;
import frc.robot.commands.*;

public class CollectBall extends CommandGroup{
    public static int arm2DS1 = 691, arm2SD2 = 511, arm1DS1 = 18200;
    public CollectBall(){
       addSequential(new WaitElevatorPosition(RobotMap.elevatorClearGripper, true));
       //
       addSequential(new SlideBack());
       //
       addSequential(new WaitArm2Position(691,true));
       //
       addSequential(new RollersSpeed(RollerSpeed.FORWARD));
       //
       addSequential(new MultiArm(18200,511,true,false));
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