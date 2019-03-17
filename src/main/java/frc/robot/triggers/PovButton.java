/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.triggers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * A custom button that is triggered when two buttons on a Joystick are
 * simultaneously pressed.
 */
public class PovButton extends Trigger {
  private final Joystick m_joy;
  private final int check;

  /**
   * Create a new double button trigger.
   * @param joy The joystick
   * @param button1 The first button
   * @param button2 The second button
   */
  public PovButton(Joystick joy,int check) {
    this.m_joy = joy;
    this.check=check;
  }

  @Override
  public boolean get() {
    return (m_joy.getPOV()==check);
  }
}
