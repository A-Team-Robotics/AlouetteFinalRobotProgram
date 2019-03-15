/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.RobotMap.RollerSpeed;

/**
 * An example command.  You can replace me with your own command.
 */
public class RollersSpeed extends InstantCommand {

    RollerSpeed state = RollerSpeed.STOP;
  /**
 * 1 is forward 2 is reverse 3 is stop
 */
  public RollersSpeed(RollerSpeed state) {
      this.state=state;
    requires(Robot.arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      if(state == RollerSpeed.STOP) {
          Robot.arm.stopRollers();
      }
      if(state == RollerSpeed.FORWARD){
          Robot.arm.setRollersReverse();
      }
      if(state == RollerSpeed.REVERSE){
          Robot.arm.setRollersForward();
      }
  }
}
