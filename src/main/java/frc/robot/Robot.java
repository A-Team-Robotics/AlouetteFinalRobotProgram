/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap.Driver;
import frc.robot.commands.MoveTurret;
import frc.robot.subsystems.ArmPneumatics;
import frc.robot.subsystems.BallCollectorArm2;
import frc.robot.subsystems.BallCollectorSystem;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.ElevatorSystem;
import frc.robot.subsystems.GripperSystem;
import frc.robot.subsystems.SlideSystem;
import frc.robot.subsystems.TurretSystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static ArmPneumatics arm = new ArmPneumatics();
  public static BallCollectorArm2 ballCollectorArm2 = new BallCollectorArm2();
  public static BallCollectorSystem ballCollector = new BallCollectorSystem();
  public static ElevatorSystem elevatorSystem = new ElevatorSystem();
  public static GripperSystem gripperSystem = new GripperSystem();
  public static SlideSystem slideSystem = new SlideSystem();
  public static DriveSystem drive = new DriveSystem();
  public static TurretSystem turret = new TurretSystem();
  public static OI m_oi;
  public static boolean gripperState = false;//true deliver ball false deliver hatch

  Compressor comp = new Compressor(RobotMap.COMPRESSOR);
  Solenoid led = new Solenoid(RobotMap.LED_RING_ONE);

  // Operator Controller Configuration Dropdown Dashboard Objects
  private SendableChooser<RobotMap.Driver> xboxControllerUser = new SendableChooser<RobotMap.Driver>();
  private SendableChooser<RobotMap.Driver> joystickControllerUser = new SendableChooser<RobotMap.Driver>();
  //private SendableChooser<Integer> subsystemTestSelector = new SendableChooser<Integer>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    xboxControllerUser.setDefaultOption("Xbox Controller - Standard", Driver.STANDARD);
    xboxControllerUser.addOption("Xbox Controller - Adam T", Driver.ADAMT);
    xboxControllerUser.addOption("Xbox Controller - Justin D", Driver.JUSTIND);
    joystickControllerUser.setDefaultOption("Joystick Controller - Standard", Driver.STANDARD);
    joystickControllerUser.setDefaultOption("Joystick Controller - Adam T", Driver.ADAMT);
    joystickControllerUser.setDefaultOption("Joystick Controller - Justin D", Driver.JUSTIND);
    SmartDashboard.putData("Select Xbox Operator", xboxControllerUser);
    SmartDashboard.putData("Select Joystick Operator", joystickControllerUser);
    Timer.delay(3);
    drive.init();
    ballCollectorArm2.init();
    ballCollector.init();
    turret.init();
    elevatorSystem.init();
    m_oi = new OI();
    RobotMap.arm1Max=ballCollectorArm2.getMotorTwoPos();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
    led.set(false);
    turret.stopTurretMotor();
    elevatorSystem.stopElevatormotor();
    slideSystem.stopMotor();
    gripperSystem.stopMotor();
    ballCollector.stopMotor();
    ballCollectorArm2.stopMotor();
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    led.set(true);
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    if(Robot.turret.getLeftLimitSwitch()==false){
      int currentPos = Robot.turret.getPosition();
      RobotMap.turretMin = currentPos;
      RobotMap.turretMax = currentPos+7610;
      Robot.turret.setTurretPos(currentPos+500);
      Scheduler.getInstance().add(new MoveTurret());
     }
     if(Robot.turret.getRightLimitSwitch()==false){
       int currentPos = Robot.turret.getPosition();
       RobotMap.turretMin = currentPos-7610;
       RobotMap.turretMax = currentPos;
       Robot.turret.setTurretPos(currentPos-500);
       Scheduler.getInstance().add(new MoveTurret());
      }
      elevatorSystem.log();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
