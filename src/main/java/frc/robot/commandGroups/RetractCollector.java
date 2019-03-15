package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.RobotMap.PnuematicArm;
import frc.robot.RobotMap.RollerSpeed;
import frc.robot.commands.*;

public class RetractCollector extends CommandGroup{
    public static int retractArm1pos = 0, retractArm2pos = 0;
    public RetractCollector(){
        addSequential(new WaitElevatorPosition(RobotMap.elevatorClearGripper, true));
        //
        addSequential(new ArmPnuematics(PnuematicArm.CLOSE));
        addSequential(new RollersSpeed(RollerSpeed.STOP));
        //
        addSequential(new RetractBallArms());
        //  
        addSequential(new WaitElevatorPosition(RobotMap.elevatorPos1, false));
    }
}