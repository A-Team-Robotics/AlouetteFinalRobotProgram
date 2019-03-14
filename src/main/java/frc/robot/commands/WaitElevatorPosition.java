package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class WaitElevatorPosition extends Command{

    private int pos = 0;
    private boolean direction = true; //true is forward and false is backward

    public WaitElevatorPosition(int pos,boolean dir){
        this.pos=pos;
        this.direction=dir;
        requires(Robot.elevatorSystem);
    }
    @Override
    protected void initialize() {
        Robot.elevatorSystem.setElevatorPosition(pos);
    }

    @Override
    protected void execute() {}

    @Override
    protected boolean isFinished() {
        if(direction==true){
            if(Robot.elevatorSystem.getElevaotrPosition()>(pos-20)){
                return true;
            }else{
                return false;
            }
        }else{
            if(Robot.elevatorSystem.getElevaotrPosition()<(pos+20)){
                return true;
            }else{
                return false;
            }
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