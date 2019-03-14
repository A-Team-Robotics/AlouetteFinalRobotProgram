/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class RollersSpeed extends InstantCommand {

  int state = 1;
  /**
 * 1 is forward 2 is reverse 3 is stop
 */
  public RollersSpeed(int state) {
      this.state=state;
    requires(Robot.arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      if(state==3){
          Robot.arm.stopRollers();
      }
      if(state==2){
          Robot.arm.setRollersReverse();
      }
      if(state==1){
          Robot.arm.setRollersForward();
      }
  }
}
