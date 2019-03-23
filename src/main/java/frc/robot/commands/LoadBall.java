package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class LoadBall extends InstantCommand{
    public LoadBall(){
        requires(Robot.gripperSystem);
    }

    @Override
    protected void initialize() {
        Robot.gripperSystem.openLowerGripper();
        Robot.gripperSystem.openUpperGripper();
        Robot.gripperSystem.setMotorSpeed(-RobotMap.ballGripperSpeed);
        SmartDashboard.putBoolean("Upper Gripper", true);
        SmartDashboard.putBoolean("Lower Gripper", true);
    }
}