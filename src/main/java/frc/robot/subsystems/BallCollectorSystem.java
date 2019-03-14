package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class BallCollectorSystem extends Subsystem{

    private WPI_TalonSRX _armOneMotor = new WPI_TalonSRX(RobotMap.BALL_COLLECTOR_MOTOR_ONE);

    private static BallCollectorSystem _ballCollectorSystemInstance = null;

    public BallCollectorSystem(){
        super("Intake");
    }

    public static BallCollectorSystem getInstance(){
        if(_ballCollectorSystemInstance == null){
            _ballCollectorSystemInstance = new BallCollectorSystem();
        }
        return _ballCollectorSystemInstance;
    }

    
    public void init() {
        _armOneMotor.setInverted(true);
    }

    public void log() {
        SmartDashboard.putNumber("Ball Collector Arm One", _armOneMotor.getSelectedSensorPosition());
    }

    public void setMotorOne(int pos){
        _armOneMotor.set(ControlMode.Position, pos);
    }

    public int getArmOnePosition(){
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