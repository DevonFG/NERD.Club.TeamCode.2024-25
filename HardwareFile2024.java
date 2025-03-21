
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

public class HardwareFile2024 {
    
    public LinearOpMode myOpMode = null;
    
    // Declare OpMode members
    public ElapsedTime runtime = new ElapsedTime();
    
    public DcMotor leftFrontWheel = null; //Motors to control all wheels
    public DcMotor leftBackWheel = null;
    public DcMotor rightFrontWheel = null;
    public DcMotor rightBackWheel = null;
    
    // Define a constructor that allows the OpMode to pass a reference to itself.


    /**
     * Initialize all the robot's hardware.
     * This method must be called ONCE when the OpMode is initialized.
     * <p>
     * All of the hardware devices are accessed via the hardware map, and initialized.
     */
     
    public HardwareFile2024 (LinearOpMode opmode) {
        myOpMode = opmode;
    }
     
    public void init()    {

        leftFrontWheel  = myOpMode.hardwareMap.get(DcMotor.class, "leftFront");
        leftBackWheel   = myOpMode.hardwareMap.get(DcMotor.class, "leftBack");
        rightFrontWheel = myOpMode.hardwareMap.get(DcMotor.class, "rightFront");
        rightBackWheel  = myOpMode.hardwareMap.get(DcMotor.class, "rightBack");
       
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
     
     double axial;
     double strafe;
     double rotation;
     
    public void driveRobot(double axial, double strafe, double rotation) {
        // Combine drive and turn for blended motion.
            double leftFrontPower  = - axial - strafe - rotation;
            double rightFrontPower = - axial + strafe + rotation;
            double leftBackPower   =   axial + strafe - rotation;
            double rightBackPower  =   axial - strafe + rotation;
        
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

            myOpMode.telemetry.addData("Status", "Run Time: " + runtime.toString());
            myOpMode.telemetry.addData("Front left/Right", "%4.2f, %4.2f", leftFrontPower, rightFrontPower);
            myOpMode.telemetry.addData("Back  left/Right", "%4.2f, %4.2f", leftBackPower, rightBackPower);
            myOpMode.telemetry.update();
    }
}
