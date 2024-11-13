package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

public class HardwareFile2024 {
    
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    
    private DcMotor leftFrontWheel = null; //Motors to control all wheels
    private DcMotor leftBackWheel = null;
    private DcMotor rightFrontWheel = null;
    private DcMotor rightBackWheel = null;
    
    // Define a constructor that allows the OpMode to pass a reference to itself.
    public Hardware (LinearOpMode opmode) {
        myOpMode = opmode;
        
    }

    /**
     * Initialize all the robot's hardware.
     * This method must be called ONCE when the OpMode is initialized.
     * <p>
     * All of the hardware devices are accessed via the hardware map, and initialized.
     */
    public void init()    {

        leftFrontWheel  = hardwareMap.get(DcMotor.class, "leftFront");
        leftBackWheel  = hardwareMap.get(DcMotor.class, "leftBack");
        rightFrontWheel = hardwareMap.get(DcMotor.class, "rightFront");
        rightBackWheel = hardwareMap.get(DcMotor.class, "rightBack");
       
        leftFrontWheel.setDirection(DcMotor.Direction.REVERSE);
        leftBackWheel.setDirection(DcMotor.Direction.REVERSE);
        rightFrontWheel.setDirection(DcMotor.Direction.FORWARD);
        rightBackWheel.setDirection(DcMotor.Direction.FORWARD);

        myOpMode.telemetry.addData(">", "Hardware Initialized");
        myOpMode.telemetry.update();
    }

    /**
     * Calculates the left/right motor powers required to achieve the requested
     * robot motions: Drive (Axial motion) and Turn (Yaw motion).
     * Then sends these power levels to the motors.
     *
     * @param Drive     Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
     * @param Turn      Right/Left turning power (-1.0 to 1.0) +ve is CW
     */
    public void driveRobot(double axial, double strafe, double rotation) {
        // Combine drive and turn for blended motion.
            double leftFrontPower  = - axial - strafe - rotation;
            double rightFrontPower = - axial + strafe + rotation;
            double leftBackPower   = - axial + strafe - rotation;
            double rightBackPower  = - axial - strafe + rotation;
// CONTINUE HERE=====================================================================================================================================================================
        // Scale the values so neither exceed +/- 1.0
        double max ;
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
        leftFrontDrive.setPower(leftFrontPower);
        rightFrontDrive.setPower(rightFrontPower);
        leftBackDrive.setPower(leftBackPower);
        rightBackDrive.setPower(rightBackPower);
        
    }
    
    public void setArmServos(double x, double y, double handAngle) {
        // all units are centimeters or radians
        double l1 = 36;
        double l2 = 35.5;
        
        // need to find this value
        double servoShoulderFlat = 0;
        
        double h = Math.sqrt(x + y);
        double w = Math.atan(y/x);
        double alpha = Math.acos((Math.pow(l1, 2) + Math.pow(h, 2) - Math.pow(l2, 2)) / (2 * l1 * h));
        double beta = Math.acos((Math.pow(l2, 2) + Math.pow(l1, 2) - Math.pow(h, 2)) / (2 * l2 * l1));
        
        double servoShoulderAngle = alpha + w;
        double servoElbowAngle = beta;
    }
    
    public double getArmShoulderAngle() {
        return armServoShoulder.getPosition();
    }
    
    public double getArmElbowAngle() {
        return armServoElbow.getPosition();
    }
    
    public double getArmWristAngle() {
        return armServoWrist.getPosition();
    }
    
    public double getArmFingerAngle() {
        return armServoFinger.getPosition();
    }
    
    public void setArmFingerAngle(double angle) {
        armServoFinger.setPosition(angle);
    }
    
    public void setArmWristAngle(double angle) {
        armServoWrist.setPosition(angle);
    }

    /**
     * Pass the requested wheel motor powers to the appropriate hardware drive motors.
     *
     * @param leftWheel     Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
     * @param rightWheel    Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
     */
  

    /**
     * Pass the requested arm power to the appropriate hardware drive motor
     *
     * @param power driving power (-1.0 to 1.0)
     */
    // public void setArmPower(double power) {
    //     armMotor.setPower(power);
    // }

    // /**
    //  * Send the two hand-servos to opposing (mirrored) positions, based on the passed offset.
    //  *
    //  * @param offset
    //  */
    // public void setHandPositions(double offset) {
    //     offset = Range.clip(offset, -0.5, 0.5);
    //     leftHand.setPosition(MID_SERVO + offset);
    //     rightHand.setPosition(MID_SERVO - offset);
    // }
}
