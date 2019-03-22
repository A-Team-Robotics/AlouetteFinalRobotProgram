package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.RobotMap.PnuematicArm;
import frc.robot.RobotMap.RollerSpeed;
import frc.robot.commands.*;

public class CollectBall extends CommandGroup{
    public CollectBall(){
       addSequential(new WaitElevatorPosition(RobotMap.elevatorClearGripper));
       //       
       addParallel(new SlideBack());
       //
       addSequential(new WaitArm2Position(RobotMap.arm2DS1));
       //
       addParallel(new RollersSpeed(RollerSpeed.FORWARD));
       //
       addParallel(new ArmPnuematics(PnuematicArm.OPEN));
       //
       addSequential(new MultiArm(RobotMap.arm1DS1,RobotMap.arm2SD2));
       /*
       addSequential(new WaitElevatorPosition(RobotMap.elevatorPos1));
       //
       addParallel(new LoadBall());
       //
       addSequential(new CollectorButtonAction());
       //
       addSequential(new TransferBall());
       */
    }
}