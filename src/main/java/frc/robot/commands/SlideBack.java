package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SlideBack extends Command{
    public SlideBack(){
        requires(Robot.slideSystem);
    }
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        if(!Robot.slideSystem.getReverseLimit()){
            System.out.println("MovingSlideBack");
            Robot.slideSystem.moveReverse();
        }else{
            Robot.slideSystem.stopMotor();
        }
    }

    @Override
    protected boolean isFinished() {
        if(Robot.slideSystem.getReverseLimit()){
            Robot.slideSystem.stopMotor();
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