package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SlideMoveBackward extends Command{
    public SlideMoveBackward(){
        requires(Robot.slideSystem);
    }
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {        
        Robot.slideSystem.moveReverse();
    }

    @Override
    protected boolean isFinished() {
        // if(!Robot.m_oi.moveSlideBackward.get()){
        //     Robot.slideSystem.stopMotor();
        //     return true;
        // }
        return false;
        //TODO uncomment this
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected void end() {
        
    }
}