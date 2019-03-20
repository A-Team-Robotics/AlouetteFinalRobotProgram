package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class WaitElevatorPosition extends Command{

    private int pos = 0;
    private boolean direction = true; //true is forward and false is backward

    public WaitElevatorPosition(int pos){
        this.pos=pos;
        requires(Robot.elevatorSystem);
    }
    @Override
    protected void initialize() {
        if (Robot.elevatorSystem.getMotorPos() > this.pos){
            this.direction = false;
        }else {
            this.direction = true;
        }
        SmartDashboard.putString("Wait Elevator Status", "Trying to reach position");
    }

    @Override
    protected void execute() {
        Robot.elevatorSystem.setMotorPos(pos);
    }

    @Override
    protected boolean isFinished() {
        if(direction==true){
            if(Robot.elevatorSystem.getMotorPos()>(pos-10)){
                SmartDashboard.putString("Wait Elevator Status", "position reached");
                return true;
            }else{
                return false;
            }
        }else{
            if(Robot.elevatorSystem.getMotorPos()<(pos+10)){
                SmartDashboard.putString("Wait Elevator Status", "position reached");
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
        SmartDashboard.putString("Wait Elevator Status", "Position "+pos+" Reached");
    }
}