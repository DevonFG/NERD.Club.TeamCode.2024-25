package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name="BasicDriveCode", group="9044.NERD.")
public class BasicDriveCode extends LinearOpMode {
  
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
        leftFrontWheel  = hardwareMap.get(DcMotor.class, "leftFront");
        leftBackWheel  = hardwareMap.get(DcMotor.class, "leftBack");
        rightFrontWheel = hardwareMap.get(DcMotor.class, "rightFront");
        rightBackWheel = hardwareMap.get(DcMotor.class, "rightBack");


      
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
            double min;

            // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
            double axial    = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value - Forward and Backward 
            double strafe   =  gamepad1.left_stick_x;  // Strafe - Left and Right - taking move right as positive
            double rotation =  gamepad1.right_stick_x;  // Rotation - ClockWise and CounterClockWise - taking turn right as positive

            // Left Front & Back is reversed
            // Combine the joystick requests for each axis-motion to determine each wheel's power.
            // Set up a variable for each drive wheel to save the power level for telemetry.
            // turn clockwise is being taken as positive, except for reversed motors
            double leftFrontPower  = - axial - strafe - rotation;
            double rightFrontPower = - axial + strafe + rotation;
            double leftBackPower   = - axial + strafe - rotation;
            double rightBackPower  = - axial - strafe + rotation;
          
            // Normalize the values so no wheel power exceeds 100%
            // This ensures that the robot maintains the desired motion.
            max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
            max = Math.max(max, Math.abs(leftBackPower));
            max = Math.max(max, Math.abs(rightBackPower));
            
            min = Math.min(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
            min = Math.min(min, Math.abs(leftBackPower));
            min = Math.min(min, Math.abs(rightBackPower));
            
            
            if (max > 1.0) {
                leftFrontPower  /= max;
                rightFrontPower /= max;
                leftBackPower   /= max;
                rightBackPower  /= max;
            }
            
            if (min < -1.0) {
              leftFrontPower    = -1.0;
              rightFrontPower   = -1.0;
              leftBackPower     = -1.0;
              rightBackPower    = -1.0;
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
