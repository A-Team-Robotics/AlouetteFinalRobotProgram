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
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commandGroups.*;
import frc.robot.commandGroups.DeliverCargo.side;
import frc.robot.commands.*;

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
  POVButton turret0 = new POVButton(joystickController, 0);
  POVButton turret45 = new POVButton(joystickController, 45);
  POVButton turret90 = new POVButton(joystickController, 90);
  POVButton turret135 = new POVButton(joystickController, 135);
  POVButton turret180 = new POVButton(joystickController, 180);
  POVButton turret270 = new POVButton(joystickController, 270);
    
  public OI(){
    slideBack.whenPressed(new SlideBack());//Slide Back Until Limit
    //
    slideFront.whenPressed(new SlideFront());//Slide Front Unitl Limit
    //
    slideControl.whileHeld(new SlideControl());//Joystick Slide Control
    //
    slideControl.whenReleased(new StopSlide());//Stop Slide Motor
    //
    speed.whenPressed(new SpeedControl());//Set Max Drive Speed
    //
    recieveBall.whenPressed(new BallReady());//Get A Ball From Human Station
    //
    recieveHatch.whenPressed(new HatchReady());
    //
    closeGripper.whenPressed(new CloseGripper());
    //
    deliverPayload.whenPressed(new DeliverPayload());
    //
    climb.whenPressed(new Climb());
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
    turret0.whenActive(new TurretPosition(RobotMap.turret0));
    turret45.whenActive(new TurretPosition(RobotMap.turret45));
    turret90.whenActive(new TurretPosition(RobotMap.turret90));
    turret135.whenActive(new TurretPosition(RobotMap.turret135));
    turret180.whenActive(new TurretPosition(RobotMap.turret180));
    turret270.whenActive(new MoveTurret());
    //
    SmartDashboard.putData("Deliver Cargo Left", new DeliverCargo(side.LEFT));
    SmartDashboard.putData("Deliver Cargo Right", new DeliverCargo(side.RIGHT));
    SmartDashboard.putData("Seq Load Hatch", new HatchLoad());
    SmartDashboard.putData("E-Stop", new EStop());
  }
}
