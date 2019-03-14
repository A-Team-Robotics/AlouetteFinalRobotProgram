package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class WaitArm2Position extends Command{

    private int pos = 0;
    private boolean direction = true; //true is forward and false is backward

    public WaitArm2Position(int pos,boolean dir){
        this.pos=pos;
        this.direction=dir;
        requires(Robot.ballCollectorArm2);
    }
    @Override
    protected void initialize() {
        Robot.ballCollectorArm2.setMotorTwo(pos);
    }

    @Override
    protected void execute() {}

    @Override
    protected boolean isFinished() {
        if(direction==true){
            if(Robot.ballCollectorArm2.getMotorTwoPos()>(pos-2)){
                return true;
            }else{
                return false;
            }
        }else{
            if(Robot.ballCollectorArm2.getMotorTwoPos()<(pos+2)){
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