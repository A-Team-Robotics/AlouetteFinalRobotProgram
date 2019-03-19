package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.commands.*;

public class BallReady extends CommandGroup{
    public BallReady(){
        addParallel(new LoadBall());//Prepare Gripper To Recieve Get Ball
        addParallel(new SlideBack());//Slide the Slide Back Until a limit is hit
        addSequential(new GripperButtonAction());//Wait until
        addSequential(new CloseGripper());//Close gripper
        addSequential(new SlidePosition(RobotMap.slidePos1);//Move Slide Forward A little bit
    }
}