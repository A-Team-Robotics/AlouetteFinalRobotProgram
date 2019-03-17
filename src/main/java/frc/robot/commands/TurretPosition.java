package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class TurretPosition extends InstantCommand{
    int pos = 0;
    public TurretPosition(int pos){
        this.pos=pos;
        requires(Robot.turret);
    }

    @Override
    protected void execute() {
        Robot.turret.setTurretPos(pos);
    }
}