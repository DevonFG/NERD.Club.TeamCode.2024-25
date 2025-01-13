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

      
      // Movement controller
      driveRobot(gamepad1.left_stick_y,gamepad1.left_stick_x,gamepad1.right_stick_x);
      //(axial,strafe,rotation)

      // Finger control
      if (gamepad2.right_bumper) {
        toggleFingers("on");
      }
      if (gamepad2.left_bumper) {
        toggleFingers("off");
      }

      // Standing code
      standUp(Math.abs(gamepad2.right_stick_y)/gamepad2.right_stick_y);

      // Arm reach code
      if (gamepad2.a || gamepad2.y){
        armExpand();
      }

      // Screw spin
      if (gamepad2.left_trigger > 0.25){
        screwTurnPower(gamepad2.left_trigger);
      }
      
      // Screw lift
      liftScrew(Math.abs(gamepad2.left_stick_y)/gamepad2.left_stick_y);

      // Deposit door
      if (gamepad2.right_trigger > 0.5){
        toggleDepositDoor("on");
      }
      else{
        toggleDepositDoor("off");
      }

      // Telemetry update
      telemetryUpdate();
    }
  }
}
