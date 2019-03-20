package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.commands.SlideBack;
import frc.robot.commands.TurretPosition;
import frc.robot.commands.WaitElevatorPosition;

public class HatchLoad extends CommandGroup {
    public HatchLoad() {
        addSequential(new WaitElevatorPosition(RobotMap.elevatorHatchLevel));
        addSequential(new TurretPosition(RobotMap.turret90));
        addSequential(new SlideBack());
    }
}