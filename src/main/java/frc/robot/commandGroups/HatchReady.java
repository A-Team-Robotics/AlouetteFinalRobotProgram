package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.commands.*;


public class HatchReady extends CommandGroup {
    public HatchReady() {
        addParallel(new WaitElevatorPosition(RobotMap.elevatorRecieveHatch));
        addParallel(new LoadHatch());
        addParallel(new SlideBack());
    }
}