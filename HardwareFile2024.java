package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
/*
 * This file works in conjunction with the External Hardware Class sample called: ConceptExternalHardwareClass.java
 * Please read the explanations in that Sample about how to use this class definition.
 *
 * This file defines a Java Class that performs all the setup and configuration for a sample robot's hardware (motors and sensors).
 * It assumes three motors (left_drive, right_drive and arm) and two servos (left_hand and right_hand)
 *
 * This one file/class can be used by ALL of your OpModes without having to cut & paste the code each time.
 *
 * Where possible, the actual hardware objects are "abstracted" (or hidden) so the OpMode code just makes calls into the class,
 * rather than accessing the internal hardware directly. This is why the objects are declared "private".
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with *exactly the same name*.
 *
 * Or... In OnBot Java, add a new file named RobotHardware.java, select this sample, and select Not an OpMode.
 * Also add a new OpMode, select the sample ConceptExternalHardwareClass.java, and select TeleOp.
 *
 */
public class HardwareFile2024 {
    /* Declare OpMode members. */
    private LinearOpMode myOpMode = null;   // gain access to methods in the calling OpMode.
    // Define Motor and Servo objects  (Make them private so they can't be accessed externally)
    private ElapsedTime runtime = new ElapsedTime(); //Starts a timer for the runtime.
    //
    private DcMotor leftFrontWheel  = null; //Motors that control all wheels
    private DcMotor leftBackWheel   = null;
    private DcMotor rightFrontWheel = null;
    private DcMotor rightBackWheel  = null;
    // Define Drive constants.  Make them public so they CAN be used by the calling OpMode

    
    // Define a constructor that allows the OpMode to pass a reference to itself.
    public RobotHardware (LinearOpMode opmode) {
        myOpMode = opmode;
    }
    /*
     * Initialize all the robot's hardware.
     * This method must be called ONCE when the OpMode is initialized.
     * <p>
     * All of the hardware devices are accessed via the hardware map, and initialized.
     */
    public void init()    {
        // Define and Initialize Motors (note: need to use reference to actual OpMode).
        leftFrontWheel  = hardwareMap.get(DcMotor.class, "leftFront");
        leftBackWheel   = hardwareMap.get(DcMotor.class, "leftBack");
        rightFrontWheel = hardwareMap.get(DcMotor.class, "rightFront");
        rightBackWheel  = hardwareMap.get(DcMotor.class, "rightBack");
        
        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        
        leftFrontWheel.setDirection(DcMotor.Direction.REVERSE);
        leftBackWheel.setDirection(DcMotor.Direction.REVERSE);
        rightFrontWheel.setDirection(DcMotor.Direction.FORWARD);
        rightBackWheel.setDirection(DcMotor.Direction.FORWARD);

        // If there are encoders connected, switch to RUN_USING_ENCODER mode for greater accuracy
        // leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Define and initialize ALL installed servos.
        // leftHand = myOpMode.hardwareMap.get(Servo.class, "left_hand");
        // rightHand = myOpMode.hardwareMap.get(Servo.class, "right_hand");
        // leftHand.setPosition(MID_SERVO);
        // rightHand.setPosition(MID_SERVO);

        telemetry.addData(">", "Hardware Initialized");
        telemetry.update();
    }

    /**
     * Calculates the left/right motor powers required to achieve the requested
     * robot motions: Drive (Axial motion) and Turn (Yaw motion).
     * Then sends these power levels to the motors.
     *
     * @param Drive     Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
     * @param Turn      Right/Left turning power (-1.0 to 1.0) +ve is CW
     */
    public void driveRobot(double Drive, double Turn, double strafe ) {
        // Combine drive and turn for blended motion.
        double axial  = Drive + Turn;
        double strafe = Drive - Turn;
        double rotation = Drive + Turn 

        // Scale the values so neither exceed +/- 1.0
        double max = Math.max(Math.abs(left), Math.abs(right));
        if (max > 1.0)
        {
            left /= max;
            right /= max;
        }

        // Use existing function to drive both wheels.
        // setDrivePower(left, right);
    }

    /**
     * Pass the requested wheel motor powers to the appropriate hardware drive motors.
     *
     * @param leftWheel     Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
     * @param rightWheel    Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
     */
    // public void setDrivePower(double leftWheel, double rightWheel) {
    //     // Output the values to the motor drives.
    //     leftDrive.setPower(leftWheel);
    //     rightDrive.setPower(rightWheel);
    }

    /**
     * Pass the requested arm power to the appropriate hardware drive motor
     *
     * @param power driving power (-1.0 to 1.0)
     */
    // public void setArmPower(double power) {
    //     armMotor.setPower(power);
    }

    /**
     * Send the two hand-servos to opposing (mirrored) positions, based on the passed offset.
     *
     * @param offset
     */
    // public void setHandPositions(double offset) {
    //     offset = Range.clip(offset, -0.5, 0.5);
    //     leftHand.setPosition(MID_SERVO + offset);
    //     rightHand.setPosition(MID_SERVO - offset);
    }
}
