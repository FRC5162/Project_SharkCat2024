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


public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
      //2 neo spark max
      private CANSparkMax IntakeBottom = new CANSparkMax(5, MotorType.kBrushless);
      private CANSparkMax IntakeTop = new CANSparkMax(6, MotorType.kBrushless);
      private MotorControllerGroup IntakeGroup = new MotorControllerGroup(IntakeBottom, IntakeTop);

      public void IntakeSpeed(Double IntakeSpeed) {
        IntakeGroup.set(IntakeSpeed);
      }

      // create function to control intake in robot.java

  public Intake() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
