package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import java.util.List;
import java.util.ArrayList;



@TeleOp(name="BasicWheelsCode", group="2024Op")
@Disabled
  
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    
    private DcMotor leftFrontWheel = null; //Motors to control all wheels
    private DcMotor leftBackWheel = null;
    private DcMotor rightFrontWheel = null;
    private DcMotor rightBackWheel = null;


    @Override
    public void runOpMode() {

      
        // Initialize the hardware variables. Note that the strings used here must correspond
        // to the names assigned during the robot configuration step on the DS or RC devices.
        leftFrontWheel  = hardwareMap.get(DcMotor.class, "left_front_drive");
        leftBackWheel  = hardwareMap.get(DcMotor.class, "left_back_drive");
        rightFrontWheel = hardwareMap.get(DcMotor.class, "right_front_drive");
        rightBackWheel = hardwareMap.get(DcMotor.class, "right_back_drive");


      
        leftFrontWheel.setDirection(DcMotor.Direction.REVERSE);
        leftBackWheel.setDirection(DcMotor.Direction.REVERSE);
        rightFrontWheel.setDirection(DcMotor.Direction.FORWARD);
        rightBackWheel.setDirection(DcMotor.Direction.FORWARD);

      

        // Wait for the game to start (driver presses START)
        telemetry.addData("High Five", "We Roboted! Woohoo!!!");
        telemetry.update();

        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
          
            double max;

            // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
            double axial   = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value - Forward and Backward -------------
            double lateral =  gamepad1.right_stick_x;  // Strafe - Left and Right --------------
            double yaw     =  gamepad1.left_stick_x;  // Rotation - ClockWise and CounterClockWise ------------

          
            // Combine the joystick requests for each axis-motion to determine each wheel's power.
            // Set up a variable for each drive wheel to save the power level for telemetry.
            double leftFrontPower  = axial + lateral + yaw;
            double rightFrontPower = axial - lateral - yaw;
            double leftBackPower   = axial - lateral + yaw;
            double rightBackPower  = axial + lateral - yaw;

            // Normalize the values so no wheel power exceeds 100%
            // This ensures that the robot maintains the desired motion.
            max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
            max = Math.max(max, Math.abs(leftBackPower));
            max = Math.max(max, Math.abs(rightBackPower));
            
            if (max > 1.0) {
                leftFrontPower  /= max;
                rightFrontPower /= max;
                leftBackPower   /= max;
                rightBackPower  /= max;
            }

          
            // Send calculated power to wheels
            leftFrontWheel.setPower(leftFrontPower);
            rightFrontWheel.setPower(rightFrontPower);
            leftBackWheel.setPower(leftBackPower);
            rightBackWheel.setPower(rightBackPower);

          
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Front left/Right", "%4.2f, %4.2f", leftFrontPower, rightFrontPower);
            telemetry.addData("Back  left/Right", "%4.2f, %4.2f", leftBackPower, rightBackPower);
            telemetry.update();
        }
    }}
