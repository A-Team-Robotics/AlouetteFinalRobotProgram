package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.WaitArm1Position;
import frc.robot.commands.WaitArm2Position;

public class WaitArm1WaitArm2 extends CommandGroup{
    public WaitArm1WaitArm2(int p, int g){
        addParallel(new WaitArm2Position(p, true));
        addParallel(new WaitArm1Position(g, false));
    }
}