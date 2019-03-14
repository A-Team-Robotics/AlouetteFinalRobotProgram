package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class CloseGripper extends InstantCommand{
    public CloseGripper() {
        requires(Robot.gripperSystem);
    }

    @Override
    protected void execute() {
        Robot.gripperSystem.closeUpperGripper();
        Robot.gripperSystem.closelowerGripper();
        Robot.gripperSystem.setGripperMotor(0.0);
        SmartDashboard.putBoolean("Upper Gripper", false);
        SmartDashboard.putBoolean("Lower Gripper", false);
    }
}