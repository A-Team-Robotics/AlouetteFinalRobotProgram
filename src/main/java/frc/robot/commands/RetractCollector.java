package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;

public class RetractCollector extends CommandGroup{
    public RetractCollector(){
        addSequential(new WaitElevatorPosition(18000, true));
        //
        addParallel(new ArmPnuematics(2));
        //
        addParallel(new RollersSpeed(3));
        //
        addParallel(new WaitArm2Position(385,true));
        //
        addSequential(new WaitArm1Position(13000,true));
        //
        addParallel(new WaitArm1Position(0,false));
        addParallel(new WaitArm2Position(595,true));
        //
        //-addParallel(new WaitArm1ToPos(Constants.arm1RetractPosFinal));
        //-addParallel(new WaitArm2ToPos(Constants.arm2RetractPosFinal));     
        addSequential(new WaitElevatorPosition(RobotMap.elevatorPos1, false));
    }
}