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
  // Button slideFront = new JoystickButton(joystickController, 5);
  // Button slideBack = new JoystickButton(joystickController, 6);
  Button elevatorBase = new JoystickButton(joystickController, RobotMap.elevatorLevel1);
  Button elevatorLevel2 = new JoystickButton(joystickController, RobotMap.elevatorLevel2);
  Button elevatorLevel3 = new JoystickButton(joystickController, RobotMap.elevatorLevel3);
  Button elevatorHumanRecieve = new JoystickButton(joystickController, RobotMap.elevatorHumanRecieve);
    
  public OI(){
    speed.whenPressed(new SpeedControl());
    recieveBall.whenPressed(new BallReady());
    recieveHatch.whenPressed(new HatchReady());
    closeGripper.whenPressed(new CloseGripper());
    climb.whenPressed(new Climb());
    elevatorBase.whenPressed(new ElevatorPosition(RobotMap.elevatorPos1));
    elevatorLevel2.whenPressed(new ElevatorPosition(RobotMap.elevatorPos2));
    elevatorLevel3.whenPressed(new ElevatorPosition(RobotMap.elevatorPos3));
    elevatorHumanRecieve.whenPressed(new ElevatorPosition(RobotMap.elevatorHumanPos));
    deployBallCollector.whenPressed(new CollectBall());
    retractBallCollector.whenPressed(new RetractCollector());
  }
}
