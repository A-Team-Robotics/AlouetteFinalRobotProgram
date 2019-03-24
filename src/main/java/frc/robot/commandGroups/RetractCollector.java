package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RetractCollector extends CommandGroup{
    public static int arm1RS1 = 0, arm2RS1 = 514, arm2RS2;
    public RetractCollector(){
        //addSequential(new WaitElevatorPosition(RobotMap.elevatorClearGripper));
        //
        //addSequential(new ArmPnuematics(PnuematicArm.CLOSE));
        //
        //addSequential(new RollersSpeed(RollerSpeed.STOP));
        //
       // addSequential(new WaitArm2Position(514));
        //
        //addSequential(new MultiArm(RobotMap.arm1Min,RobotMap.arm2Max));
        //  
//addSequential(new WaitElevatorPosition(RobotMap.elevatorPos1));
    }
}