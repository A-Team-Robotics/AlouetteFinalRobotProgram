package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.*;

public class BallReady extends CommandGroup{
    public BallReady(){
        addParallel(new LoadBall());
        addParallel(new SlideBack());
        addSequential(new GripperButtonAction());
    }
}