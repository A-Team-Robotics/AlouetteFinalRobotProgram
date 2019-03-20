package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.commands.SlideFront;
import frc.robot.commands.TurretPosition;
import frc.robot.commands.WaitElevatorPosition;

public class DeliverCargo extends CommandGroup {
    public enum side{
        LEFT,
        RIGHT
    }
    public DeliverCargo(side s) {
        switch(s){
            case LEFT:
            addSequential(new WaitElevatorPosition(RobotMap.elevatorCargoLevel));
            addSequential(new TurretPosition(RobotMap.turretMin));
            addSequential(new SlideFront());
            break;
            case RIGHT:
            addSequential(new WaitElevatorPosition(RobotMap.elevatorCargoLevel));
            addSequential(new TurretPosition(RobotMap.turretMax));
            addSequential(new SlideFront());
            break;
        }
    }
}