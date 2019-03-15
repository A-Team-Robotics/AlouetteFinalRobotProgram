package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.RobotMap.Payload;

public class DeliverPayload extends InstantCommand{
    public DeliverPayload() {
        requires(Robot.gripperSystem);
    }

    @Override
    protected void execute() {
        switch(Payload p){

        }
        if(Robot._payloadState==Payload.BALL){
            Robot.gripperSystem.closelowerGripper();
            Robot.gripperSystem.closeUpperGripper();
            Robot.gripperSystem.setGripperMotor(RobotMap.ballGripperSpeed);
            SmartDashboard.putBoolean("Upper Gripper", false);
            SmartDashboard.putBoolean("Lower Gripper", false);
        }else if(Robot._payloadState==Payload.HATCH){
            Robot.gripperSystem.closeUpperGripper();
            Robot.gripperSystem.openLowerGripper();
            Robot.gripperSystem.stopMotor();
            SmartDashboard.putBoolean("Upper Gripper", false);
            SmartDashboard.putBoolean("Lower Gripper", true);
        }else{
            
        }
    }
}