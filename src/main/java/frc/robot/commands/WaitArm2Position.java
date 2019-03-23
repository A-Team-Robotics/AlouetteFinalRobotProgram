package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class WaitArm2Position extends Command{

    private int pos = 0;
    private boolean direction = true; //true is forward and false is backward

    public WaitArm2Position(int pos){
        this.pos=pos;
        requires(Robot.ballCollectorArm2);
    }
    @Override
    protected void initialize() {
        if (Robot.ballCollectorArm2.getMotorPos() > this.pos){
            this.direction = false;
        }else {
            this.direction = true;
        }
        SmartDashboard.putString("Wait Arm2 Status", "Trying to reach position");
        Robot.ballCollectorArm2.setMotorPos(pos);  
    }

    @Override
    protected void execute() {
             
    }

    @Override
    protected boolean isFinished() {
        if(direction==true){
            if(Robot.ballCollectorArm2.getMotorPos()>(pos-RobotMap.arm2Error)){
                return true;
            }else{
                return false;
            }
        }else{
            if(Robot.ballCollectorArm2.getMotorPos()<(pos+RobotMap.arm2Error)){
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
        SmartDashboard.putString("Wait Arm2 Status", "Position "+pos+" Reached");
    }
}