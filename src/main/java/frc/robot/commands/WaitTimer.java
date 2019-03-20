

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class WaitTimer extends Command{

    public WaitTimer(Double waitTime){
        setTimeout(waitTime);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() { 
    //this sub is continously call by the robot program       
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }
}