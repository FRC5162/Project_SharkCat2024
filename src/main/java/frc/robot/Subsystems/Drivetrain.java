// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends SubsystemBase {

  // Creates rightside motor controllers & brings them together into a group
  private CANSparkMax frontRightMotor = new CANSparkMax(1, MotorType.kBrushless);
  private CANSparkMax backRightMotor = new CANSparkMax(2, MotorType.kBrushless);
  //dont use motorcontrollergroup anymore, use follow
  // private MotorControllerGroup rightmotorgroup = new MotorControllerGroup(frontRightMotor, backRightmotor);
  
  // creates leftside motor controllers & brings them together into a group
  private CANSparkMax frontLeftMotor = new CANSparkMax(3, MotorType.kBrushless);
  private CANSparkMax backLeftMotor = new CANSparkMax(4, MotorType.kBrushless);
  //dont use motorcontrollergroup anymore, use follow
  // private MotorControllerGroup leftmotorgroup = new MotorControllerGroup(FrontLeftMotor, BackLeftMotor);
  double offset;
  
  // brings motors into a drive group
  public DifferentialDrive drivegroup = new DifferentialDrive(frontRightMotor, frontLeftMotor); //only control the front motors, the back are followers
  
  // creates an arcadeDrive so that drivetrain motors can be controlled by a joystick
  public void arcadeDrive(double Rotation, double Speed){
  // may need to move around throttle and turnrate/add a subtraction symbol infront of varible name to get it in correct order
    drivegroup.arcadeDrive(Rotation,- Speed, false);
  }

  
  /** Creates a new Drivetrain. */
  public Drivetrain() {
    // Do this instead of motor controller groups
    backRightMotor.follow(frontRightMotor);
    backLeftMotor.follow(frontLeftMotor);
  }
 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
