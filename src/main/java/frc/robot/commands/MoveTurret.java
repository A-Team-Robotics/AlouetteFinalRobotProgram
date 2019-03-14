package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.TurretSystem;

public class MoveTurret extends Command {

    public MoveTurret(){
        requires(Robot.turret);
    }
    @Override
    protected void execute() {
        Robot.turret.setTurretPos((int)TurretSystem.map(OI.joystickController.getThrottle(), -1, 1, 200, 7500));//200, 7500
        if(Robot.turret.getLeftLimitSwitch()==false||Robot.turret.getRightLimitSwitch()==false){
            Robot.turret.stopTurretMotor();
        }
    }
    @Override
    protected boolean isFinished() {
         if(Robot.turret.getLeftLimitSwitch()==false||Robot.turret.getRightLimitSwitch()==false){
            return true;
        }else{
            return false;
        }
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected void end() {
        
    }

}