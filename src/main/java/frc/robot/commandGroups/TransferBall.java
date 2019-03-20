package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.RobotMap.RollerSpeed;
import frc.robot.commands.*;

public class TransferBall extends CommandGroup{
    public TransferBall(){
        addSequential(new RollersSpeed(RollerSpeed.STOP));
        //
        addSequential(new MultiArm(RobotMap.arm1TS1,RobotMap.arm2TS1));
        //
        addSequential(new RollersSpeed(RollerSpeed.FORWARD));
        //
        addSequential(new GripperButtonAction());
        //
        addSequential(new RetractCollector());
    }

    @Override
    protected void interrupted() {
        
    }

    @Override
    protected void end() {
        
    }
}