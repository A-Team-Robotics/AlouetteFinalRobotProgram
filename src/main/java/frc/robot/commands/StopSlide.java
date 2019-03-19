package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class StopSlide extends InstantCommand{
    public StopSlide(){
        requires(Robot.slideSystem);
    }

    @Override
    protected void initialize() {
        Robot.slideSystem.stopMotor();
    }
}