package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class WaitArm1Position extends Command{

    private int pos = 0;
    private boolean direction = true; //true is forward and false is backward

    public WaitArm1Position(int pos){
        this.pos=pos;
        requires(Robot.ballCollectorArm1);
    }
    
    @Override
    protected void initialize() {
        if (Robot.ballCollectorArm1.getMotorPos() > this.pos){
            this.direction = false;
        }else {
            this.direction = true;
        }
        SmartDashboard.putString("Wait Arm1 Status", "Trying to reach position");
        Robot.ballCollectorArm1.setMotorPos(pos);
    }

    @Override
    protected void execute() {
        
    }
    @Override
    protected boolean isFinished() {
        if(direction==true){
            if(Robot.ballCollectorArm1.getMotorPos()>(pos-10)){
                return true;
            }else{
                return false;
            }
        }else{
            if(Robot.ballCollectorArm1.getMotorPos()<(pos+10)){
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
        SmartDashboard.putString("Wait Arm1 Status","Position "+pos+" Reached");
    }
}