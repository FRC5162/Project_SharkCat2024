// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Add your docs here. */
public class Constants {

    // creates an offset that will be used as a dead zone for the controller
    public double deadzone = 0.2;

    public static class ControllerConfig{
        public final int DriverPort =  0;
        public final int DriverYAxis = 1;
        public final int DriverXAxis = 2;

        public double ThrottleSpeed;
        public double TurningSpeed;
    }
}
