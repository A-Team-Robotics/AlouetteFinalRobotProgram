package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.WaitArm1Position;
import frc.robot.commands.WaitArm2Position;

public class MultiArm extends CommandGroup{
    public MultiArm(int one, int two, boolean dir1, boolean dir2){
        addParallel(new WaitArm2Position(two, dir1));
        addParallel(new WaitArm1Position(one, dir2));
    }
}