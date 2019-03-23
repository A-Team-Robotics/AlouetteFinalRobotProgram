package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.commands.*;

public class BallReady extends CommandGroup{
    public BallReady(){
        addParallel(new WaitElevatorPosition(RobotMap.elevatorRecieveBall));
        addSequential(new LoadBall());
        addSequential(new SlideBack());
        addSequential(new GripperButtonAction());
        addSequential(new CloseGripper());
    }
}