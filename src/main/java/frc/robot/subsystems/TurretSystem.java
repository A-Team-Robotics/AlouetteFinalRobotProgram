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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.MoveTurret;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class TurretSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_TalonSRX _turretMotor = new WPI_TalonSRX(RobotMap.TURRET_TURN_MOTOR);

  private DigitalInput _leftTurretSwitch = new DigitalInput(RobotMap.TURRET_LEFT_LIMIT);
  private DigitalInput _rightTurretSwitch = new DigitalInput(RobotMap.TURRET_RIGHT_LIMIT);
  
  @Override
  public void initDefaultCommand() {
     setDefaultCommand(new MoveTurret());
  }

  public void log() {
      SmartDashboard.putBoolean("Turret Left Limit j", _leftTurretSwitch.get());
      SmartDashboard.putBoolean("Turret Right Limit j", _rightTurretSwitch.get());
      SmartDashboard.putNumber("Turret Value", getPosition());
  }

  public void init() {
  }

  /**
 * Set the Speed of the Turret Motor
 *
 * <p>Will automaticly stop when a limit switch is hit.
 *
 * @param speed Set the speed of the motor. Value should be 1.0 to -1.0
 */
  public void setTurretMotor(double speed){
      _turretMotor.set(speed);
  }

  /**
 * Stop the Turret Motor
 */
  public void stopMotor(){
      _turretMotor.set(ControlMode.Disabled, 0.0);
      _turretMotor.stopMotor();
      _turretMotor.disable();
  }

  public void resetEncoderLeft(){
    _turretMotor.setSelectedSensorPosition(0);
  }

  public void resetEncoderRight(){
    _turretMotor.setSelectedSensorPosition(0);
    _turretMotor.setSensorPhase(true);
  }

  /**
 * Get the status of the Left Turret Limit Switch
 * 
 * @return get the current state of the limit switch. boolean true or false 
 */
  public boolean getLeftLimitSwitch(){
    return _leftTurretSwitch.get();
  }

  /**
 * Get the status of the Right Turret Limit Switch
 *
 * @return get the current state of the limit switch. boolean true or false 
 */
  public boolean getRightLimitSwitch(){
      return _rightTurretSwitch.get();
  }

  /**
 * Get the current position from the encoder
 *
 * <p>
 *
 * @return The currect position of the turret as a double
 */
  public int getPosition(){
     return _turretMotor.getSelectedSensorPosition();
  }

  public void setTurretPos(int pos){
      _turretMotor.set(ControlMode.Position, pos);
  }

  /**
   * Map Value Range Function
   *
   * <p>Calculates an output based on an input and predefined max and min of the output and the desired range of the output.
   *
   * @param x Source Input
   * @param in_min Source Min
   * @param in_max Source Max
   * @param out_min Output Min
   * @param out_max Source Max
   * 
   * @return calculated double value
   */
  public static double map(double x, double in_min, double in_max, double out_min, double out_max){
    return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
}
}
