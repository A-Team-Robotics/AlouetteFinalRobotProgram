package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class LoadHatch extends InstantCommand{
    public LoadHatch() {
        requires(Robot.gripperSystem);
    }

    @Override
    protected void execute() {
        Robot.gripperSystem.openLowerGripper();
        Robot.gripperSystem.closeUpperGripper();
        Robot.gripperSystem.setGripperMotor(0.0);
        Robot.gripperState=false;
        SmartDashboard.putBoolean("Upper Gripper", false);
        SmartDashboard.putBoolean("Lower Gripper", true);
    }
}