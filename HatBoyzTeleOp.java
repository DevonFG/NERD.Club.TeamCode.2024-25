package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.teamcode.RobotHardware;

@TeleOp(name="Rotate_right_stick", group="Linear OpMode");
public class HatBoyzTeleOp extends LinearOpMode {

  private RobotHardware robot = new RobotHardware(this);
  private ElapsedTime runtime = new ElapsedTime();

  @Override
  public void runOpMode() {
    robot.init();
    telemetry.addData("Status", "Initialized");
    telemetry.update();

    waitForStart();
    runtime.reset();

    while (opModeIsActive()) {

      
    }
  }
}
