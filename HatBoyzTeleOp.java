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

      
      //movement controller
      driveRobot(gamepad1.left_stick_y,gamepad1.left_stick_x,gamepad1.right_stick_x);
      //(axial,strafe,rotation)

      //Finger controll
      if (gamepad2.right_bumper) {
        toggleFingers("on");
      }
      if (gamepad2.left_bumper) {
        toggleFingers("off");
      }

      //standing code
      standUp(Math.abs(gamepad2.right_stick_y)/gamepad2.right_stick_y);

      //arm reach code
      if (gamepad2.a){
        armExpand();
      }

      //screw lift
      liftScrew(Math.abs(gamepad2.left_stick_y)/gamepad2.left_stick_y);
      
    }
  }
}
