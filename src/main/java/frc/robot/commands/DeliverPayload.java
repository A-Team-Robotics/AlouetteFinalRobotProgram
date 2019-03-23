package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DeliverPayload extends InstantCommand{
    public DeliverPayload() {
        requires(Robot.gripperSystem);
    }

    @Override
    protected void execute() {
        switch(Robot._payloadState) {
            case BALL:
            Robot.gripperSystem.closelowerGripper();
            Robot.gripperSystem.openUpperGripper();
            Robot.gripperSystem.setMotorSpeed(RobotMap.ballGripperSpeed);
            SmartDashboard.putBoolean("Upper Gripper", false);
            SmartDashboard.putBoolean("Lower Gripper", false);
              break;
            case HATCH:
            Robot.gripperSystem.closeUpperGripper();
            Robot.gripperSystem.openLowerGripper();
            Robot.gripperSystem.stopMotor();
            SmartDashboard.putBoolean("Upper Gripper", false);
            SmartDashboard.putBoolean("Lower Gripper", true);
              break;
            case NULL:
            break;
          }
    }
}