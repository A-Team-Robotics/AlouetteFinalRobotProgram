package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class GripperButtonAction extends Command {

    public GripperButtonAction(){
        requires(Robot.gripperSystem);
    }
    @Override
    protected void execute() {
        
    }
    @Override
    protected boolean isFinished() {
         if(Robot.gripperSystem.getButton()==false){
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