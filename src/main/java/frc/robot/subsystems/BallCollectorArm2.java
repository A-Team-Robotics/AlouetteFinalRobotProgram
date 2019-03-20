package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class BallCollectorArm2 extends Subsystem {

    public int currentPosition = 0;

    private WPI_TalonSRX _armTwoMotor = new WPI_TalonSRX(RobotMap.BALL_COLLECTOR_MOTOR_TWO);

    public void init(){
       _armTwoMotor.setInverted(true);
       _armTwoMotor.setSensorPhase(true);
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(null);
    }

    public void  invertMotor(){
         _armTwoMotor.setInverted(InvertType.InvertMotorOutput);
    }

    public void  unInvertMotor(){
        _armTwoMotor.setInverted(InvertType.None);
   }

   public void stopMotor(){
       _armTwoMotor.set(ControlMode.Disabled,0.0);
       _armTwoMotor.stopMotor();
   }
    
    public void log() {
        SmartDashboard.putNumber("Ball Collector Arm Two",_armTwoMotor.getSelectedSensorPosition());
    }

    public void setMotorPos(double pos){
        _armTwoMotor.set(ControlMode.Position, pos);
    }

    public int getMotorPos(){
        currentPosition = _armTwoMotor.getSelectedSensorPosition();
        return _armTwoMotor.getSelectedSensorPosition();
    }
}