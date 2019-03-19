/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class SlideSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private final DigitalInput _slideForward = new DigitalInput(RobotMap.TURRET_SLIDE_FORWARD);

  private final DigitalInput _slideReverse = new DigitalInput(RobotMap.TURRET_SLIDE_BACKWARD);

  private WPI_TalonSRX _slideMotor = new WPI_TalonSRX(RobotMap.TURRET_SLIDE_MOTOR);

  @Override
  public void initDefaultCommand() {
     setDefaultCommand(null);
  }

  public void init(){
    _slideMotor.setSensorPhase(RobotMap.slideSensorPhase);
  }

  public void stopMotor(){
    _slideMotor.set(ControlMode.Disabled, 0.0);
    _slideMotor.stopMotor();
  }

  public void moveFront(){
    _slideMotor.set(RobotMap.slideSpeed);
  }

  public void moveReverse(){
      _slideMotor.set(-RobotMap.slideSpeed);
  }

  public void setPID(int pos){
    _slideMotor.set(ControlMode.Position, pos);
  }

  public void setMotorSpeed(double speed){
    _slideMotor.set(speed);
  }
  
  public void disablePID(){
    _slideMotor.disable();
  }

  public boolean getReverseLimit(){
    return _slideReverse.get();
  }

  public boolean getForwardLimit(){
    return _slideForward.get();
  }

  public void joyControl(double percent){
    _slideMotor.set(percent);
  }

  public void setPosition(int pos){
    _slideMotor.set(ControlMode.Position, pos);
  }

  public int getPosition(){
    return _slideMotor.getSelectedSensorPosition();
  }
}
