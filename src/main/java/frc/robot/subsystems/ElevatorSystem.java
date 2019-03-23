package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class ElevatorSystem extends Subsystem{

    private final WPI_TalonSRX _elevatorDriveMotor = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR);

    private final TalonSRXConfiguration _elevatorConfig = new TalonSRXConfiguration();

    private static ElevatorSystem _elavatorInstance = null;

    public ElevatorSystem(){
        super("Elevator");
    }

    public static ElevatorSystem getInstance(){
        if(_elavatorInstance == null){
            _elavatorInstance = new ElevatorSystem();
        }
        return _elavatorInstance;
    }
    
    public void talonConfig(){
        _elevatorConfig.primaryPID.selectedFeedbackSensor = FeedbackDevice.QuadEncoder;
        _elevatorConfig.motionCruiseVelocity = RobotMap.elevatorCruiseValue;
        _elevatorConfig.slot0.kF = RobotMap.elevatorFeedFGain;
        _elevatorConfig.slot0.kP = RobotMap.elevatorFeedPGain;
        _elevatorConfig.slot0.kI = RobotMap.elevatorFeedIGain;
        _elevatorConfig.slot0.kD = RobotMap.elevatorFeedDGain;
        _elevatorConfig.peakOutputReverse = 0.1;
        _elevatorConfig.peakOutputForward = 1.0;

    }
    
    public void init() {
        talonConfig();
        _elevatorDriveMotor.setSensorPhase(true);
        _elevatorDriveMotor.setSelectedSensorPosition(0);
        _elevatorDriveMotor.configAllSettings(_elevatorConfig);
    }

    
    public void log() {
        SmartDashboard.putNumber("Elevator Encoder Position", getMotorPos());
        SmartDashboard.putNumber("Talon 5 Temp", _elevatorDriveMotor.getTemperature());
    }

    public void configTest(){
        
    }

    /**
   * Set the Speed of the Elevator Motor
   *
   * <p>Will automaticly stop when a limit switch is hit.
   *
   * @param speed Set the speed of the motor. Value should be 1.0 to -1.0
   */
    public void setMotorSpeed(double speed){
        _elevatorDriveMotor.set(speed);
    }

    /**
    * Stop the Elevator Motor
    */
    public void stopMotor(){
        _elevatorDriveMotor.set(ControlMode.Disabled, 0.0);
        _elevatorDriveMotor.stopMotor();
    }

    /**
    * Holds the elevator at a cetain level
    *
    * <p>Will hold the elevator at a set position
    *
    * @return get the current state of the limit switch. boolean true or false 
        */
        public void setMotorPos(int pos){
            System.out.println("Setting pos2 " + pos);
            _elevatorDriveMotor.set(ControlMode.Position, pos);
        }
    
    /**
    * Gets the enocder value of the elevator
    *
    * <p>The Encoder is connected to a TalonSRX
    *
    * @return the current position of the elevator as an integer
     */
        public int getMotorPos(){
            return _elevatorDriveMotor.getSelectedSensorPosition(0);
        }

    /**
    * Elevator Motor Joystick Control
    *
    * <p>Drives the motor according to the joystick
    *
    * @param joystick controller
        */
        public void manualControl(Joystick joystick){
            _elevatorDriveMotor.set(ControlMode.PercentOutput, -joystick.getY()/1.2);
        }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(null);
    }
    
}