package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.XboxDrive;

public class DriveSystem extends Subsystem {
    

    private WPI_TalonSRX _backRightCIM = new WPI_TalonSRX(RobotMap.BACK_RIGHT_MOTOR);// Change to constant later
    private WPI_TalonSRX _frontRightCIM = new WPI_TalonSRX(RobotMap.FRONT_RIGHT_MOTOR);// Change to constant later
    private WPI_TalonSRX _backLeftCIM = new WPI_TalonSRX(RobotMap.BACK_LEFT_MOTOR);//Change to constant later
    private WPI_TalonSRX _frontLeftCIM = new WPI_TalonSRX(RobotMap.FRONT_RIGHT_MOTOR);//Change to constant later

    private SpeedControllerGroup right = new SpeedControllerGroup(_frontRightCIM,_backRightCIM);
    private SpeedControllerGroup left = new SpeedControllerGroup(_frontLeftCIM, _backLeftCIM);
    public DifferentialDrive _driveBase = new DifferentialDrive(right, left);
    

    //TODO set access modifiers and clean duplicate objects in origram
    NetworkTableEntry targetOffSet;
    NetworkTableEntry driveInput;
    NetworkTableInstance netTableInst = NetworkTableInstance.getDefault();
    NetworkTable visionTable = netTableInst.getTable("videoInfo");
    double targetOffSetNumber = 0.0;
    double driveInputNumber = 0.0;
    boolean driveModeLastPressed = false;
    int dashPrintFactor = 0;

    public PIDController m_tracker;

    private static DriveSystem _driveSystemInstance = null;

    public enum DriveMode{
        MANUAL,
        AUTO
    }

    public DriveSystem(){
        super("Drive");
    }

    public void init() {
        _driveBase.setSafetyEnabled(false);
    }

    public static DriveSystem getInstance(){
        if(_driveSystemInstance == null){
            _driveSystemInstance = new DriveSystem();
        }
        return _driveSystemInstance;
    }

     /**
   * Drive the Robot using arcade drive
   *
   * <p>Uses two axis values to drive the robot 
   *
   * @param driveController joystick controller object to get axis value from
   */
    public void arcadeDrive(Joystick driveController){
        _driveBase.arcadeDrive((driveController.getRawAxis(1))/RobotMap.driveSpeed, (driveController.getRawAxis(4))/RobotMap.driveSpeed, true);
    }

     /**
   * Drive the Robot using two speed values
   *
   * <p>Drives the robot by the speed forward and the turning amount
   *
   * @param directionalSpeed the robots left speed range from 1.0 - (-1.0)
   * @param rotationalSpeed the robots right speed range from 1.0 - (-1.0) for turning left and right
   */
    public void autoDriveArcade(double directionalSpeed, double rotationalSpeed) {
        _driveBase.arcadeDrive(directionalSpeed, rotationalSpeed);
    }
    /**
   * Drive the Robot using two speed values
   *
   * <p>Drives the robot by the speed forward and the turning amount
   *
   * @param directionalSpeed the robots left speed range from 1.0 - (-1.0)
   * @param rotationalSpeed the robots right speed range from 1.0 - (-1.0) for turning left and right
   */
    public void autoDriveTank(double left, double right) {
        _driveBase.tankDrive(left, right);
    }

//      /**
//    * Drive the Robot using two speed values
//    *
//    * <p>Drives the robots left side and right side
//    *
//    * @param leftSpeed the robots left speed range from 1.0 - (-1.0)
//    * @param rightSpeed the robots right speed range from 1.0 - (-1.0)
//    */
//     public boolean turnDrive(double degrees, boolean direction){
//         return true;
//     }

    /**
   * Drive the Robot to a set distance
   *
   * <p>Uses encoders 
   *
   * @param distance the distance in cm for the robot to travel
   * @param direction true to drive forward false to drive backward
   */
    public boolean distanceDrive(int distance, boolean direction){
        if(direction==true){
            while(distance < ((_backLeftCIM.getSelectedSensorPosition()+_backRightCIM.getSelectedSensorPosition())/2)){
                _driveBase.tankDrive(0.6, 0.6);
            }
        }else{
            while(distance < ((_backLeftCIM.getSelectedSensorPosition()+_backRightCIM.getSelectedSensorPosition())/2)){
                _driveBase.tankDrive(-0.6, -0.6);
            }
        }
        
        return true;
    }

    int lastPrinted = 0;
    public int getTemperature(){
        return (int)(_backLeftCIM.getTemperature()+_backRightCIM.getTemperature()+_frontLeftCIM.getTemperature()+_frontRightCIM.getTemperature())/4;
    }

    public void inittrackTargetDrive(){
        m_tracker = new PIDController(1.0,0.5, 0.5, new PIDSource() {
            PIDSourceType m_sourceType = PIDSourceType.kDisplacement;
      
            @Override
            public double pidGet() {
              return targetOffSetNumber;
            }
      
            @Override
            public void setPIDSourceType(PIDSourceType pidSource) {
              m_sourceType = pidSource;
            }
      
            @Override
            public PIDSourceType getPIDSourceType() {
              return m_sourceType;
            }
          }, d -> _driveBase.arcadeDrive(0.5, d));
          m_tracker.setAbsoluteTolerance(5);
          m_tracker.setInputRange(-180, 180);
          m_tracker.setSetpoint(0);
          m_tracker.reset();
        }

    public void trackTargetDrive(){
        SmartDashboard.putData(m_tracker);
        if(targetOffSet.exists()){
            targetOffSetNumber = targetOffSet.getValue().getDouble();
        }
        m_tracker.enable();
    }

    public int getDistance(){
        return ((-_backLeftCIM.getSelectedSensorPosition()+_backRightCIM.getSelectedSensorPosition())/2)/RobotMap.CM_CONVERSION;
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new XboxDrive());
    }

    //(DESIRED_TARGET_AREA - ta) * DRIVE_K

}
