// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkLowLevel;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Arm extends SubsystemBase {
  /** Creates a new Arm. */
  // one neo spark max
  private CANSparkMax ArmMotor = new CANSparkMax(7, MotorType.kBrushless);
  //create function to raise/lower arm in robot.java
  public void ArmSpeed(double ArmSpeed){
    ArmMotor.set(ArmSpeed);
  }


  public Arm() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
