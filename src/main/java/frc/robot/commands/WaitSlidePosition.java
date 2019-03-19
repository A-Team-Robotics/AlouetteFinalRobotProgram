package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.RobotMap.Direction;;


public class WaitSlidePosition extends Command{

    private int pos = 0;
    Direction dir = Direction.NULL;
    public WaitSlidePosition(int pos, Direction dir){
        this.pos=pos;
        this.dir=dir;
        requires(Robot.slideSystem);
    }

    @Override
    protected void initialize() {
        if(dir==Direction.NULL){
            Robot.slideSystem.stopMotor();
        }else{
            Robot.slideSystem.setPosition(pos);
        }
    }

    @Override
    protected boolean isFinished() {
        switch(dir){
            case NULL:
            return true;
            case FORWARD:
            if(Robot.slideSystem.getPosition()>pos-RobotMap.turretError){
                return true;
            }
            case REVERSE:
            if(Robot.slideSystem.getPosition()<pos-RobotMap.turretError){
                return true;
            }
            case STOP:
            Robot.slideSystem.stopMotor();
            break;
        }
        return false;
    }

    @Override
    protected void end() {
        Robot.slideSystem.stopMotor();
    }
}