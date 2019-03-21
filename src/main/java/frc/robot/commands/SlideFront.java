package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SlideFront extends Command{
    public SlideFront(){
        requires(Robot.slideSystem);
    }
    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if(!Robot.slideSystem.getForwardLimit()){
            Robot.slideSystem.moveFront();
        }else{
            Robot.slideSystem.stopMotor();
        }
    }

    @Override
    protected boolean isFinished() {
        if(Robot.slideSystem.getForwardLimit()){
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