package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class HatchReady extends CommandGroup {
    public HatchReady() {
        addParallel(new LoadHatch());
        addParallel(new SlideBack());
    }
}