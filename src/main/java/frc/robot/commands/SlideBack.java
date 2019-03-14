package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SlideBack extends Command{
    public SlideBack(){
        requires(Robot.slideSystem);
    }
    @Override
    protected void initialize() {
        if(!Robot.slideSystem.getReverseLimit()){
        Robot.slideSystem.moveReverse();
        }
    }

    @Override
    protected boolean isFinished() {
        if(Robot.slideSystem.getReverseLimit()){
            return true;
        }
        return false;
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected void end() {
        
    }
}