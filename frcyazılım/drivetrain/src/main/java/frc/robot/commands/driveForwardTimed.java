// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.drivetrain;

public class driveForwardTimed extends CommandBase {

  drivetrain drivetrain;
  private boolean finish = false;
  Timer timer;



  /** Creates a new driveForwardTimed. */
  public driveForwardTimed(drivetrain dt) {
    drivetrain = dt;
    addRequirements(drivetrain);
    timer = new Timer();




    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    while(timer.get() < Constants.DRIVE_FORWARD_TIME)
    {
      drivetrain.driveForward(Constants.AUTONOMOUS_SPEED);
    }
    finish = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finish;
  }
}
