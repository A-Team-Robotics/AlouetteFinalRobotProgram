package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.LoadHatch;
import frc.robot.commands.SlideBack;

public class HatchReady extends CommandGroup {
    public HatchReady() {
        addParallel(new LoadHatch());
        addParallel(new SlideBack());
    }
}