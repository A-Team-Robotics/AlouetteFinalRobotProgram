package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.RobotMap.PnuematicArm;
import frc.robot.RobotMap.RollerSpeed;
import frc.robot.commands.*;

public class FoldClimb extends CommandGroup{
    public FoldClimb(){
        addSequential(new WaitElevatorPosition(RobotMap.elevatorCargoLevel));
        //
        addSequential(new ArmPnuematics(PnuematicArm.CLOSE));
        //
        addSequential(new RollersSpeed(RollerSpeed.STOP));
        //
        addSequential(new WaitArm2Position(314));
        //
        addSequential(new MultiArm(RobotMap.arm1Min,RobotMap.arm2Max));
        //  
        addSequential(new WaitElevatorPosition(RobotMap.elevatorPos1));
    }
}