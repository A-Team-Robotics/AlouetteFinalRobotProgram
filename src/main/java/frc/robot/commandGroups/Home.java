package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.commands.*;

public class Home extends CommandGroup{
    public Home(){
        addSequential(new ElevatorPosition(0));
        addSequential(new CloseGripper());
        addSequential(new SlideBack());
        addSequential(new TurretPosition(RobotMap.turret0));
    }
}