// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkLowLevel;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends SubsystemBase {

  // Creates rightside motor controllers & brings them together into a group
  private CANSparkMax FrontRightMotor = new CANSparkMax(1, MotorType.kBrushless);
  private CANSparkMax baclrightmotor = new CANSparkMax(2, MotorType.kBrushless);
  private MotorControllerGroup rightmotorgroup = new MotorControllerGroup(FrontRightMotor, baclrightmotor);
  
  // creates leftside motor controllers & brings them together into a group
  private CANSparkMax FrontLeftMotor = new CANSparkMax(3, MotorType.kBrushless);
  private CANSparkMax BackLeftMotor = new CANSparkMax(4, MotorType.kBrushless);
  private MotorControllerGroup leftmotorgroup = new MotorControllerGroup(FrontLeftMotor, BackLeftMotor);
  double offset;
  
  // brings motors into a drive group
  public DifferentialDrive drivegroup = new DifferentialDrive(rightmotorgroup, leftmotorgroup);
  
  // creates an arcadeDrive so that drivetrain motors can be controlled by a joystick
  public void arcadeDrive(double Rotation, double Speed){
  // may need to move around throttle and turnrate/add a subtraction symbol infront of varible name to get it in correct order
    drivegroup.arcadeDrive(Rotation, Speed, false);
  }

  /** Creates a new Drivetrain. */
  public Drivetrain() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
