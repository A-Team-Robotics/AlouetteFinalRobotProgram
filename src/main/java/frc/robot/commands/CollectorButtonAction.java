package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CollectorButtonAction extends Command {

    public CollectorButtonAction(){
        requires(Robot.arm);
    }
    @Override
    protected void execute() {
        
    }
    @Override
    protected boolean isFinished() {
         if(Robot.arm.getBallStopButton()==false){
            return true;
        }else{
            return false;
        }
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected void end() {
        
    }

}