package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SlideMoveForward extends Command{
    public SlideMoveForward(){
        requires(Robot.slideSystem);
    }
    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.slideSystem.moveFront();        
    }

    @Override
    protected boolean isFinished() {
        // if(!Robot.m_oi.moveSlideForward.get()){
        //     Robot.slideSystem.stopMotor();
        //     return true;
        // }
        //TODO uncomment this
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