// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.Talon;

public class drivetrain extends SubsystemBase {


  Talon leftBack;
  Talon rightBack;
  PWMVictorSPX leftFront;
  PWMVictorSPX rightFront;
  MotorControllerGroup leftMotors;
  MotorControllerGroup rightMotors;
  DifferentialDrive drive;

  public drivetrain() {
    leftFront = new PWMVictorSPX(Constants.LEFT_FRONT);
    leftFront.setInverted(false);
    rightFront = new PWMVictorSPX(Constants.RIGHT_FRONT);
    rightFront.setInverted(true);
    leftBack = new Talon(Constants.LEFT_BACK);
    leftFront.setInverted(false);
    rightBack = new Talon(Constants.RIGHT_BACK);
    rightBack.setInverted(true);

    leftMotors = new MotorControllerGroup(leftFront, leftBack);
    rightMotors = new MotorControllerGroup(rightBack, rightFront);
    drive = new DifferentialDrive(leftMotors, rightMotors);





  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driveWithJoysticks(XboxController controller, double speed)
  {
    drive.arcadeDrive(controller.getRawAxis(Constants.XBOX_LEFT_Y_AXIS)*speed, controller.getRawAxis(Constants.XBOX_LEFT_X_AXIS)*speed);
  }

  public void driveStraightForward(double speed)
  {
    drive.tankDrive(speed, speed);

  }

  public void stop()
  {
    drive.stopMotor();
  }

  public void driveForward(double autonomousSpeed) {
  }

}
