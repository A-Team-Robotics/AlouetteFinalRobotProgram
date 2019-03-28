/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commandGroups.BallReady;
import frc.robot.commandGroups.Climb;
import frc.robot.commandGroups.ClimbStep2;
import frc.robot.commandGroups.CollectBall;
import frc.robot.commandGroups.DeliverCargo;
import frc.robot.commandGroups.HatchLoad;
import frc.robot.commandGroups.HatchReady;
import frc.robot.commandGroups.Home;
import frc.robot.commandGroups.RetractCollector;
import frc.robot.commandGroups.DeliverCargo.Side;
import frc.robot.commands.*;
import frc.robot.triggers.PovButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public static Joystick xboxController = new Joystick(RobotMap.driveController);
  public static Joystick joystickController = new Joystick(RobotMap.joystickController);

  //Xbox Controller
  Button speed = new JoystickButton(xboxController, RobotMap.changeSpeed);
  Button deliverPayload = new JoystickButton(xboxController, RobotMap.deliverPayload);
  Button deployBallCollector = new JoystickButton(xboxController, RobotMap.deployCollector);
  Button retractBallCollector = new JoystickButton(xboxController, RobotMap.retractCollector);
  Button climb = new JoystickButton(xboxController, RobotMap.climb);
  Button climb2 = new JoystickButton(xboxController, RobotMap.climb);
  Button driveMode = new JoystickButton(xboxController, RobotMap.driveMode);

  //Joystick Controller
  Button closeGripper = new JoystickButton(joystickController, RobotMap.closeGripper);
  Button recieveBall = new JoystickButton(joystickController, RobotMap.recieveBall);
  Button recieveHatch = new JoystickButton(joystickController, RobotMap.recieveHatch);
  Button slideControl = new JoystickButton(joystickController, RobotMap.slideControl);
  Button slideFront = new JoystickButton(joystickController, RobotMap.slideFront);
  Button slideBack = new JoystickButton(joystickController, RobotMap.slideBack);
  Button elevatorBase = new JoystickButton(joystickController, RobotMap.elevatorLevel1);
  Button elevatorLevel2 = new JoystickButton(joystickController, RobotMap.elevatorLevel2);
  Button elevatorLevel3 = new JoystickButton(joystickController, RobotMap.elevatorLevel3);
  Button elevatorHumanRecieve = new JoystickButton(joystickController, RobotMap.elevatorHumanRecieve);
  Button moveSlide = new JoystickButton(joystickController, 1);
  // public PovButton moveSlideForward = new PovButton(joystickController, 0);
  // public PovButton moveSlideBackward = new PovButton(joystickController, 180);
  PovButton turretCenter = new PovButton(joystickController, 0);
  PovButton turretLeft = new PovButton(joystickController, 270);
  PovButton turretRight = new PovButton(joystickController, 90);
  PovButton turret45left = new PovButton(joystickController, 315);
  PovButton turret45Right = new PovButton(joystickController, 45);
  PovButton turretManualRight = new PovButton(joystickController, 135);
  PovButton turretManualLeft = new PovButton(joystickController, 225);
  
    
  public OI(){
    slideBack.whenPressed(new SlideBack());
    //
    slideFront.whenPressed(new SlideFront());
    //
    slideControl.whileHeld(new SlideControl());
    //
    slideControl.whenReleased(new StopSlide());
    //
    speed.whenPressed(new SpeedControl());
    //
    recieveBall.whenPressed(new BallReady());
    //
    recieveHatch.whenPressed(new HatchReady());
    //
    closeGripper.whenPressed(new CloseGripper());
    //
    deliverPayload.whenPressed(new DeliverPayload());
    //
    climb.whenPressed(new Climb());
    //
    climb2.whenPressed(new ClimbStep2());
    //
    elevatorBase.whenPressed(new ElevatorPosition(RobotMap.elevatorPos1));
    //
    elevatorLevel2.whenPressed(new ElevatorPosition(RobotMap.elevatorPos2));
    //
    elevatorLevel3.whenPressed(new ElevatorPosition(RobotMap.elevatorPos3));
    //
    elevatorHumanRecieve.whenPressed(new ElevatorPosition(RobotMap.elevatorHumanLoad));
    //
    deployBallCollector.whenPressed(new CollectBall());
    //
    retractBallCollector.whenPressed(new RetractCollector());
    //
    moveSlide.whileHeld(new SlideControl());
    moveSlide.whenReleased(new StopSlide());
    // moveSlideForward.whenActive(new SlideMoveForward());
    // moveSlideBackward.whenActive(new SlideMoveBackward());
    //
    //turretCenter.whenActive(new TurretPosition(RobotMap.turret90));
    //turretLeft.whenActive(new TurretPosition(RobotMap.turret0));
    //turretRight.whenActive(new TurretPosition(RobotMap.turret180));
    //turret45left.whenActive(new TurretPosition(RobotMap.turret45));
    //turret45Right.whenActive(new TurretPosition(RobotMap.turret135));
    //turretManualRight.whileActive(new MoveTurret());
    //turretManualLeft.whileActive(new MoveTurret());

    SmartDashboard.putData("Deliver Cargo Left", new DeliverCargo(Side.LEFT));
    SmartDashboard.putData("Deliver Cargo Right", new DeliverCargo(Side.RIGHT));
    SmartDashboard.putData("Seq Load Hatch", new HatchLoad());
    SmartDashboard.putData(new Home());
    SmartDashboard.putBoolean("Turret Control", false);
  }
}
