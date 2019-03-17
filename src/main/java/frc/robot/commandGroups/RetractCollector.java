package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.RobotMap.PnuematicArm;
import frc.robot.RobotMap.RollerSpeed;
import frc.robot.commands.*;

public class RetractCollector extends CommandGroup{
    public static int arm1RS1 = 0, arm2RS1 = 514, arm2RS2;
    public RetractCollector(){
        addSequential(new WaitElevatorPosition(RobotMap.elevatorClearGripper, true));
        //
        addSequential(new ArmPnuematics(PnuematicArm.CLOSE));
        //
        addSequential(new RollersSpeed(RollerSpeed.STOP));
        //
        addSequential(new WaitArm2Position(514, true));
        //
        addSequential(new MultiArm(RobotMap.arm1Min,RobotMap.arm2Max,false, true));
        //  
        addSequential(new WaitElevatorPosition(RobotMap.elevatorPos1, false));
    }
}