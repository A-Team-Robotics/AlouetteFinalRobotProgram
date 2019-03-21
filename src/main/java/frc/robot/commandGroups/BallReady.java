package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.*;

public class BallReady extends CommandGroup{
    public BallReady(){
        addParallel(new LoadBall());
        addSequential(new SlideBack());
        addSequential(new GripperButtonAction());
    }
}