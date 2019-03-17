package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

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
        SmartDashboard.putString("Wait Arm2 Status", "Trying to reach position");
    }

    @Override
    protected void execute() {}

    @Override
    protected boolean isFinished() {
        if(direction==true){
            if(Robot.ballCollectorArm2.getMotorTwoPos()>(pos-RobotMap.arm2Error)){
                return true;
            }else{
                return false;
            }
        }else{
            if(Robot.ballCollectorArm2.getMotorTwoPos()<(pos+RobotMap.arm2Error)){
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