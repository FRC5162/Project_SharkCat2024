// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Add your docs here. */
public class Constants {

    public final static int ArmLimitDIO = 0;
    public final static double IntakeSpeed = 0.95;
    public final static double ArmSpeed = 0.5;

    public class ControllerConfig{
        public final static double deadzone = 0.2;
        public final static int DriverPort =  0;
        public final static int DriverYAxis = 1;  //xbox controller left stick y
        public final static int DriverXAxis = 4;  //xbox controller right stick X

        public final static int OperPort = 1;
        public final static int ArmDown = 2; //xbox ltrigger
        public final static int ArmUp = 3; //xbox rtrigger
        public final static int IntakeBottom = 1; //xbox left stick y
        public final static int IntakeTop = 5; //xbox right stick y

    }
}
