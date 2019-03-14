package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class Align extends Command {

    boolean stop = false;
    public Align(){
        requires(Robot.drive);
    }
    
    @Override
    protected void execute() {
        Robot.drive.arcadeDrive(OI.xboxController);
    }

    @Override
    protected void initialize() {
        Robot.drive.arcadeDrive(OI.xboxController);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
    @Override
    protected void interrupted() {
        stop = true;
    }
}