package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BallReady extends CommandGroup{
    public BallReady(){
        addParallel(new BallReady());
        addParallel(new SlideBack());
    }
}