package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.TurretSystem;

public class MoveTurret extends Command {

    public MoveTurret(){
        requires(Robot.turret);
    }
    @Override
    protected void execute() {
        Robot.turret.setTurretPos((int)TurretSystem.map(OI.joystickController.getThrottle(), -1, 1, RobotMap.turret0, RobotMap.turret180));//200, 7500
        if(Robot.turret.getLeftLimitSwitch()==false||Robot.turret.getRightLimitSwitch()==false){
            Robot.turret.stopMotor();
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

    // public MoveTurret(){
    //     requires(Robot.turret);
    // }
    // @Override
    // protected void execute() {
    //     if(Robot.turret.getLeftLimitSwitch()==false&&Robot.turret.getRightLimitSwitch()==true){
    //         Robot.turret.setTurretPos((int)TurretSystem.map(OI.joystickController.getThrottle(), -1, 1, 200, 7500));//200, 7500
    //     }else{
    //         Robot.turret.setTurretPos((int)TurretSystem.map(OI.joystickController.getThrottle(), -1, 1, 200, 7500));//200, 7500
    //     }
    // }
    // @Override
    // protected boolean isFinished() {
    //     return false;
    // }

    // @Override
    // protected void interrupted() {
    //     end();
    // }

    // @Override
    // protected void end() {
    //     Robot.turret.stopMotor();
    // }

}