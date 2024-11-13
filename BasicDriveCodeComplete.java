package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
//import the hardware file//
import org.firstinspires.ftc.teamcode.HardwareFile2024;

@TeleOp(name= "BasicDriveCodeComplete", group="Teamcode.")

  public class BasicDriveCodeComplete extends LinearOpMode {
    
    @Override
    public void runOpMode() {
        HardwareFile2024 robot = new HardwareFile2024(this);
        robot.init();

      double driveForwardBackwards = 0.0;
        double driveRightLeft        = 0.0;
        double rotateRightLeft       = 0.0;
        
        
        telemetry.addData("Status", "Ready To Roll!");
        telemetry.update();

 while (opModeIsActive()) {
            
            // get input from controller
   
            driveForwardBackwards = -gamepad1.left_stick_y;
            driveRightLeft = gamepad1.left_stick_x;
            rotateRightLeft = gamepad1.right_stick_x;
   
   telemetry.addData("Motors", "DriveForwardBackwards (%.2f)", driveForwardBackwards);
   telemetry.update();
            sleep(50);
        }
    }
}
   
