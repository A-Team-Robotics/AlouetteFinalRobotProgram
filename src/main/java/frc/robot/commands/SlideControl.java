package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.OI;
import frc.robot.Robot;

public class SlideControl extends InstantCommand {

    public SlideControl() {
        requires(Robot.slideSystem);
    }
    
    @Override
    protected void initialize() {
        if(Robot.slideSystem.getForwardLimit()==false&&Robot.slideSystem.getReverseLimit()==true){
            Robot.slideSystem.joyControl(-Math.abs(OI.joystickController.getRawAxis(1)));
        }else if(Robot.slideSystem.getReverseLimit()==false&&Robot.slideSystem.getForwardLimit()==true){
            Robot.slideSystem.joyControl(Math.abs(OI.joystickController.getRawAxis(1)));
        }else{
            Robot.slideSystem.joyControl(OI.joystickController.getRawAxis(1));
        }
    }
}