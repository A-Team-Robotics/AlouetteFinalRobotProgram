/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.RobotMap.PnuematicArm;

/**
 * An example command.  You can replace me with your own command.
 */
public class ArmPnuematics extends InstantCommand {

  PnuematicArm a = PnuematicArm.CLOSE;
  public ArmPnuematics(PnuematicArm a) {
      this.a=a;
    requires(Robot.arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    switch(a){
      case CLOSE:
      Robot.arm.closeArms();
      break;
      case OPEN:
      Robot.arm.openArms();
      break;
    }
  }
}
