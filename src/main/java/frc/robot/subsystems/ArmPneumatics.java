package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class ArmPneumatics extends Subsystem{

    private WPI_TalonSRX _rollerMotorLeft = new WPI_TalonSRX(RobotMap.ROLLER_MOTOR_LEFT);
    private VictorSPX _rollerMotorRight = new VictorSPX(RobotMap.ROLLER_MOTOR_RIGHT);

    private DoubleSolenoid _armExtendor = new DoubleSolenoid(RobotMap.BALL_COLLECTOR_SOLENOID[0],RobotMap.BALL_COLLECTOR_SOLENOID[1]);

    private DigitalInput buttonStop = new DigitalInput(RobotMap.ARM_BUTTON_STOP);

    private static ArmPneumatics _armPneumaticsInstance = null;

    public ArmPneumatics(){
        super("Pneumatics");
    }

    public static ArmPneumatics getInstance(){
        if(_armPneumaticsInstance == null){
            _armPneumaticsInstance = new ArmPneumatics();
        }
        return _armPneumaticsInstance;
    }

    public boolean getBallStopButton(){
        return buttonStop.get();
    }

    
    public void log() {
        SmartDashboard.putBoolean("Arm Button", getBallStopButton());
    }

    public void setRollersForward(){
        _rollerMotorLeft.set(RobotMap.rollersSpeed);
        _rollerMotorRight.set(ControlMode.PercentOutput, -RobotMap.rollersSpeed);
    }

    public void stopRollers(){
        _rollerMotorLeft.stopMotor();
        _rollerMotorRight.set(ControlMode.PercentOutput, 0);

    }

    public void setRollersReverse(){
        _rollerMotorLeft.set(-RobotMap.rollersSpeed);
        _rollerMotorRight.set(ControlMode.PercentOutput, RobotMap.rollersSpeed);
    }

    public void openArms(){
        _armExtendor.set(Value.kForward);
    }

    public void closeArms(){
        _armExtendor.set(Value.kReverse);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(null);
    }

}