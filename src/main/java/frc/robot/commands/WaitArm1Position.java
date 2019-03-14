package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class WaitArm1Position extends Command{

    private int pos = 0;
    private boolean direction = true; //true is forward and false is backward

    public WaitArm1Position(int pos,boolean dir){
        this.pos=pos;
        this.direction=dir;
        requires(Robot.ballCollector);
    }
    @Override
    protected void initialize() {
        Robot.ballCollector.setMotorOne(pos);
    }

    @Override
    protected void execute() {}

    @Override
    protected boolean isFinished() {
        if(direction==true){
            if(Robot.ballCollector.getArmOnePosition()>(pos-10)){
                return true;
            }else{
                return false;
            }
        }else{
            if(Robot.ballCollector.getArmOnePosition()<(pos+10)){
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