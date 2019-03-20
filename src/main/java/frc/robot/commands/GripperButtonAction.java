package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap.Payload;

public class GripperButtonAction extends Command {

    public GripperButtonAction(){
        requires(Robot.gripperSystem);
    }
    @Override
    protected boolean isFinished() {
         if(Robot.gripperSystem.getButton()==false){
            Robot._payloadState = Payload.BALL;
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