// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import digital input library

import javax.sound.midi.ControllerEventListener;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import frc.robot.Subsystems.Arm;
import frc.robot.Subsystems.Drivetrain;
import frc.robot.Subsystems.Intake;
import frc.robot.Constants;
import frc.robot.Constants.ControllerConfig;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  // Stuff for Autonomous selections
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  //create limit switch with digital input alligned with port on roborio
  public DigitalInput ArmLimit = new DigitalInput(0);

  public static Drivetrain drivetrain;
  //create arm and intake refernces
  private static Intake intake;
  private static Arm arm;

  public Constants constants;
  public ControllerConfig controllerConfig;
  
  // Creates a joystick for the driver controller
  private Joystick Driver;
  // create operater joystick
  private Joystick Operator;


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Stuff for Autonomous
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    // Allows joystick in port 0 on the driverstation to be used as the Driver controller
    Driver = new Joystick(controllerConfig.DriverPort);
    //create new instance of operator joystick with port 1
    Operator = new Joystick(1);

    drivetrain = new Drivetrain();
    // create new instences of arm and intake
    intake = new Intake();
    arm = new Arm();


  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    //these are basically adding our deadzone to our joysticks in a way that will make them drive the motors


    if(Math.abs(Driver.getRawAxis(controllerConfig.DriverYAxis)) > constants.deadzone ){
      controllerConfig.ThrottleSpeed = Math.pow(controllerConfig.DriverYAxis, 3);
    } else{
    controllerConfig.ThrottleSpeed=0;
    }

    if(Math.abs(Driver.getRawAxis(controllerConfig.DriverXAxis)) > constants.deadzone ){
      controllerConfig.TurningSpeed = Math.pow(controllerConfig.DriverXAxis, 3);
    }else{
      controllerConfig.TurningSpeed = 0;
    }

    drivetrain.arcadeDrive(controllerConfig.TurningSpeed, -controllerConfig.ThrottleSpeed);

    if (Operator.getRawAxis(4) > 0.01) {
      intake.IntakeSpeed(0.75);
    } else if (Operator.getRawAxis(3) > 0.01) {
      intake.IntakeSpeed(-0.75);
    } else{
      intake.IntakeSpeed(0.0);
    }

    if(Operator.getRawAxis(1) < constants.deadzone){
      arm.ArmSpeed(1.0);
    }
    else if (Operator.getRawAxis(1) > constants.deadzone) {
      arm.ArmSpeed(-0.5);
    } else if (ArmLimit.get() == true) {
      arm.ArmSpeed(0.0);
    } else {
      arm.ArmSpeed(0.0);
    }



  }

  //create button to raise and lower arm

  //create button to intake/output the intake wheels
  
    
  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
