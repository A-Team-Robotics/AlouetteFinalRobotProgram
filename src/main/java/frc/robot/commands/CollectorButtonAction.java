package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class CollectorButtonAction extends Command {

    public CollectorButtonAction(){
        requires(Robot.arm);
    }
    @Override
    protected void execute() {
        SmartDashboard.putString("Collect Ball Status", "Waiting for button to be pressed");
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
        SmartDashboard.putString("Collect Ball Status","waiting...");
    }

}