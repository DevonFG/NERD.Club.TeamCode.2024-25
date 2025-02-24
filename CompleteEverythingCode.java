package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

//import org.firstinspires.ftc.teamcode.HardwareFile2024;


/*
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When a selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 */



@TeleOp(name="Main Code USE THIS", group="Linear OpMode")

public class CompleteEverythingCode extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private Servo screwServo;
    private CRServo sweeperLeft;
    private CRServo sweeperRight;
    private CRServo slidesLeft;
    private CRServo slidesRight;
    private DcMotor screwSpin;
    private DcMotor screwLift;
    private DcMotor footLeft;
    private DcMotor footRight;
    public DcMotor leftFrontWheel;
    public DcMotor leftBackWheel;
    public DcMotor rightFrontWheel;
    public DcMotor rightBackWheel;
    
    
    private TouchSensor brushExtended;
    private TouchSensor brushRetracted;
    private boolean brushMoving = false;
    
    public void driveRobot(double axial, double strafe, double rotation) {
        
        double leftFrontPower  = - axial - strafe - rotation;
        double rightFrontPower = - axial + strafe + rotation;
        double leftBackPower   = - axial + strafe - rotation;
        double rightBackPower  = - axial - strafe + rotation;
                
        // Scale the values so neither exceed +/- 1.0          
        double max;
        double min;
        
        // Normalize the values so no wheel power exceeds 100%
        // This ensures that the robot maintains the desired motion.
        max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
        max = Math.max(max, Math.abs(leftBackPower));
        max = Math.max(max, Math.abs(rightBackPower));
                
        min = Math.min(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
        min = Math.min(min, Math.abs(leftBackPower));
        min = Math.min(min, Math.abs(rightBackPower));
    
        if (max > 1.0) {
            leftFrontPower  = 1.0;
            rightFrontPower = 1.0;
            leftBackPower   = 1.0;
            rightBackPower  = 1.0;
        } else if (min < -1.0) {
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
    }

    public void checkEverything() {
        if (brushExtended.isPressed() && brushMoving) {
            brushMoving = false;
            servo1.setPower(0.5);
            servo2.setPower(0.5);
        } else if (brushRetracted.isPressed() && brushMoving) {
            brushMoving = false;
            servo1.setPower(0.5);
            servo2.setPower(0.5);
        } else {
            brushMoving = true;
        }
    }
    
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
    
        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).

        screwServo = hardwareMap.get(Servo.class, "screwDoor");
        slidesLeft = hardwareMap.get(CRServo.class, "left_servo");
        slidesRight = hardwareMap.get(CRServo.class, "right_servo");
        sweeperLeft = hardwareMap.get(CRServo.class, "fingers_servo");
        sweeperRight = hardwareMap.get(CRServo.class, "");
        screwSpin = hardwareMap.get(DcMotor.class, "archimedes");
        footLeft = hardwareMap.get(DcMotor.class, "motor0");
        footRight = hardwareMap.get(DcMotor.class, "motor3");
        screwLift = hardwareMap.get(DcMotor.class, "arch_up");
        leftFrontWheel = hardwareMap.get(DcMotor.class, "leftFront");
        leftBackWheel = hardwareMap.get(DcMotor.class, "leftBack");
        rightFrontWheel = hardwareMap.get(DcMotor.class, "rightFront");
        rightBackWheel = hardwareMap.get(DcMotor.class, "rightBack");
        brushExtended      = hardwareMap.get(TouchSensor.class, "touchSensor1");
        brushRetracted     = hardwareMap.get(TouchSensor.class, "touchSensor2");
     
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        //change motor 2 direction
        //motor2.setDirection(DcMotor.Direction.REVERSE);
        
        // Wait for the game to start (driver presses START)
        waitForStart();
        runtime.reset();
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            if (gamepad2.a) {
                slidesLeft.setPower(0.5);
                slidesRight.setPower(-0.5);
                telemetry.addData("A",  "TRUE");
                checkEverything();
            } else if (gamepad1.b) {
                slidesRight.setPower(0.5);
                slidesLeft.setPower(-0.5);
                telemetry.addData("B",  "TRUE");
                checkEverything();
            } else {
                slidesLeft.setPower(0.0);
                slidesRight.setPower(0.0);
                checkEverything();
            }
            
            sweeperLeft.setPower(gamepad2.left_stick_y);
            sweeperRight.setPower(gamepad2.left_stick_y);

            // if (gamepad1.dpadup) {
            // motor4.setPower (0.5);
            // } else if (gamepad1.dpadright) {
            // motor4.setPower (-0.5);
            //}
            init();
            waitForStart();
            //runtime.reset();
            
            double axial;
            double strafe;
            double rotation;
            
            // run until the end of the match (driver presses STOP)
          
            // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
            axial    =   -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value - Forward and Backward 
            strafe   =   gamepad1.left_stick_x;  // Strafe - Left and Right - taking move right as positive
            rotation =   gamepad1.right_stick_x;  // Rotation - ClockWise and CounterClockWise - taking turn right as positive
            
            driveRobot(axial, strafe, rotation);
        }
    }
}

    
}
