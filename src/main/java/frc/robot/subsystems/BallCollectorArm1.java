package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class BallCollectorArm1 extends Subsystem{

    private WPI_TalonSRX _armOneMotor = new WPI_TalonSRX(RobotMap.BALL_COLLECTOR_MOTOR_ONE);

    private static BallCollectorArm1 _ballCollectorSystemInstance = null;

    public BallCollectorArm1(){
        super("Intake");
    }

    public static BallCollectorArm1 getInstance(){
        if(_ballCollectorSystemInstance == null){
            _ballCollectorSystemInstance = new BallCollectorArm1();
        }
        return _ballCollectorSystemInstance;
    }

    
    public void init() {
        _armOneMotor.enableVoltageCompensation(true);
        _armOneMotor.setInverted(true);
    }

    public void log() {
        SmartDashboard.putNumber("Ball Collector Arm One", _armOneMotor.getSelectedSensorPosition());
    }

    public void setMotorPos(int pos){
        _armOneMotor.set(ControlMode.Position, pos);
    }

    public int getMotorPos(){
        return _armOneMotor.getSelectedSensorPosition();
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(null);
    }

    public void stopMotor(){
        _armOneMotor.stopMotor();
        _armOneMotor.set(ControlMode.Disabled, 0.0);
    }

}