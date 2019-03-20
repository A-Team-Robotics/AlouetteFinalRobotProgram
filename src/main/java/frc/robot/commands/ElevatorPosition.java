package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class ElevatorPosition extends InstantCommand{

    private int pos = 0;
    public ElevatorPosition(int pos){
        this.pos=pos;
        requires(Robot.elevatorSystem);
    }
    @Override
    protected void execute() {
        Robot.elevatorSystem.setMotorPos(pos);
    }
}