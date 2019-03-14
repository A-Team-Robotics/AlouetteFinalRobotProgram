package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class Arm1Position extends InstantCommand{

    private int pos = 0;
    public Arm1Position(int pos){
        this.pos=pos;
        requires(Robot.ballCollector);
    }
    @Override
    protected void execute() {
        Robot.ballCollector.setMotorOne(pos);
    }
}