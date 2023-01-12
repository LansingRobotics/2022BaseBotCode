// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoMode.PixelFormat;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class GUI extends SubsystemBase {
  /** Creates a new GUI. */
  // This sets up the fields that we can add selectable values to
  // It also sets up a camera object to be plugged into the Roborio's USB port
  private static UsbCamera theCamera = CameraServer.startAutomaticCapture("USB Camera", RobotMap.CAMERA_PORT);
  private static SendableChooser<Integer> drivingType = new SendableChooser<>();
  private static SendableChooser<Integer> autonomousCommand = new SendableChooser<>();
  private static SendableChooser<Double> drivingPower = new SendableChooser<>();
  private static SendableChooser<Double> clawPower = new SendableChooser<>();
  private static SendableChooser<Double> armLifterPower = new SendableChooser<>();
  private static SendableChooser<Boolean> resettingGyroscope = new SendableChooser<>();

  // I call this method in the Robot's initialize. It will just push all that
  // values to the choosers on the gui
  public void startGui() {
    SmartDashboard.putData("Driving Type", drivingType);
    drivingType.setDefaultOption("Tank Drive", RobotMap.TANK_DRIVE_DRIVING);
    drivingType.addOption("Video Game Driving", RobotMap.VIDEO_GAME_DRIVING);
    drivingType.addOption("Double Tank Drive", RobotMap.DOUBLE_TANK_DRIVING);
    drivingType.addOption("Double Video Game Drive", RobotMap.DOUBLE_VIDEO_GAME_DRIVING);

    SmartDashboard.putData("Driving Power", drivingPower);
    drivingPower.setDefaultOption("100%", 1.0);
    drivingPower.addOption("90%", 0.9);
    drivingPower.addOption("80%", 0.8);
    drivingPower.addOption("70%", 0.7);
    drivingPower.addOption("60%", 0.6);
    drivingPower.addOption("50%", 0.5);
    drivingPower.addOption("40%", 0.4);
    drivingPower.addOption("30%", 0.3);
    drivingPower.addOption("20%", 0.2);
    drivingPower.addOption("10%", 0.1);
    drivingPower.addOption("Off", 0.0);

    SmartDashboard.putData("Claw Power", clawPower);
    clawPower.setDefaultOption("100%", 1.0);
    clawPower.addOption("90%", 0.9);
    clawPower.addOption("80%", 0.8);
    clawPower.addOption("70%", 0.7);
    clawPower.addOption("60%", 0.6);
    clawPower.addOption("50%", 0.5);
    clawPower.addOption("40%", 0.4);
    clawPower.addOption("30%", 0.3);
    clawPower.addOption("20%", 0.2);
    clawPower.addOption("10%", 0.1);
    clawPower.addOption("Off", 0.0);

    SmartDashboard.putData("Arm Lifter", armLifterPower);
    armLifterPower.setDefaultOption("100%", 1.0);
    armLifterPower.addOption("90%", 0.9);
    armLifterPower.addOption("80%", 0.8);
    armLifterPower.addOption("70%", 0.7);
    armLifterPower.addOption("60%", 0.6);
    armLifterPower.addOption("50%", 0.5);
    armLifterPower.addOption("40%", 0.4);
    armLifterPower.addOption("30%", 0.3);
    armLifterPower.addOption("20%", 0.2);
    armLifterPower.addOption("10%", 0.1);
    armLifterPower.addOption("Off", 0.0);

    SmartDashboard.putData("Reset Gyroscope", resettingGyroscope);
    resettingGyroscope.setDefaultOption("Off", false);
    resettingGyroscope.addOption("On", true);
  }

  // The following methods are just public methods that can be used to see what
  // percent power the drive team wants the motors at
  public double getDrivingPower() {
    return drivingPower.getSelected();
  }

  public double getArmLifterPower() {
    return armLifterPower.getSelected();
  }

  public double getClawPower() {
    return clawPower.getSelected();
  }

  public int getDrivingType() {
    return drivingType.getSelected();
  }

  public int getAutonomousCommand() {

    if (autonomousCommand.getSelected() == null) {
      return 0;
    } else {
      return autonomousCommand.getSelected();
    }
  }

  public boolean getResettingGyroscope() {
    return resettingGyroscope.getSelected();
  }

  public String sayCurrentCommand() {
    switch (getDrivingType()) {
      case RobotMap.TANK_DRIVE_DRIVING:
        return "Tank Driving";
      case RobotMap.VIDEO_GAME_DRIVING:
        return "Video Game Driving";
      case RobotMap.DOUBLE_TANK_DRIVING:
        return "Double Tank Driving";
      case RobotMap.DOUBLE_VIDEO_GAME_DRIVING:
        return "Double Video Game Driving";
      default:
        return "Nothing";
    }
  }

  // This starts up the camera and creates the way that it is compatible with the
  // gui formatting
  public void startCamera() {
    theCamera.setVideoMode(PixelFormat.kMJPEG, 150, 75, 20);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
