package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.RobotMap.RollerSpeed;
import frc.robot.commands.*;

public class RetractCollector extends CommandGroup{
    public RetractCollector(){
        addSequential(new WaitElevatorPosition(18000, true));
        //
        addSequential(new ArmPnuematics(2));
        addSequential(new RollersSpeed(RollerSpeed.STOP));
        //
        addSequential(new RetractBallArms());
        //  
        addSequential(new WaitElevatorPosition(RobotMap.elevatorPos1, false));
    }
}