package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.RobotMap.Payload;

public class LoadBall extends InstantCommand{
    public LoadBall(){
        requires(Robot.gripperSystem);
    }

    @Override
    protected void execute() {
        Robot.gripperSystem.openLowerGripper();
        Robot.gripperSystem.openUpperGripper();
        Robot.gripperSystem.setGripperMotor(-RobotMap.ballGripperSpeed);
        Robot._payloadState=Payload.BALL;
        SmartDashboard.putBoolean("Upper Gripper", true);
        SmartDashboard.putBoolean("Lower Gripper", true);
    }
}