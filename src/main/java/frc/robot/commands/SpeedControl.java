/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * An example command.  You can replace me with your own command.
 */
public class SpeedControl extends InstantCommand {

  int speed = 1;
  int lastSpeed = 1;
  public SpeedControl() {
    requires(Robot.drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if(RobotMap.driveSpeed==1){
      speed = 2;
      RobotMap.driveSpeed = speed;
    }else if(RobotMap.driveSpeed == 2){
      speed = 3;
      RobotMap.driveSpeed = speed;
    }else {
      speed = 1;
      RobotMap.driveSpeed = speed;
    }
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }
}
