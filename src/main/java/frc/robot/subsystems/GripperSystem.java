/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class GripperSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static DoubleSolenoid lowerGripper = new DoubleSolenoid(RobotMap.LOWER_GRIPPER_SOLENOID[0], RobotMap.LOWER_GRIPPER_SOLENOID[1]);
  private DoubleSolenoid upperGripper = new DoubleSolenoid(RobotMap.UPPER_GRIPPER_SOLENOID[0], RobotMap.UPPER_GRIPPER_SOLENOID[1]);

  private DigitalInput buttonBallStop = new DigitalInput(RobotMap.GRIPPER_BUTTON_STOP);

  private VictorSPX gripperMotor = new VictorSPX(RobotMap.GRIPPER_MOTOR);
  

  @Override
  public void initDefaultCommand() {
     setDefaultCommand(null);
  }

  public boolean getButton(){
    return buttonBallStop.get();
  }

  public void stopMotor(){
    gripperMotor.set(ControlMode.Disabled, 0.0);
  }

  public void setMotorSpeed(double speed){
    gripperMotor.set(ControlMode.PercentOutput, speed);
  }

  public void openUpperGripper(){
    upperGripper.set(Value.kForward);
  }

  public void closeUpperGripper(){
    upperGripper.set(Value.kReverse);
  }

  public void openLowerGripper(){
    lowerGripper.set(Value.kReverse);
  }
  
  public void closelowerGripper(){
    lowerGripper.set(Value.kForward);
  }

  public void releasePressure(){
    upperGripper.set(Value.kOff);
  }

}
