package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class EStop extends Command{

    public EStop(){
        requires(Robot.elevatorSystem);
    }

    @Override
    protected void initialize() {
        Robot.eStop();
    }
    
    @Override
    protected void execute() {
        Robot.eStop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}