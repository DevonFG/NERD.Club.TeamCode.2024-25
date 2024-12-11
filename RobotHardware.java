//Need to program limit switches to stop the brush

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class RobotHardware {
    
    public LinearOpMode myOpMode = null;
    
    // Declare OpMode members
    public ElapsedTime runtime = new ElapsedTime();
    
    public DcMotor leftFrontWheel = null; //Motors to control all wheels
    public DcMotor leftBackWheel = null;
    public DcMotor rightFrontWheel = null;
    public DcMotor rightBackWheel = null;

    public DcMotor leftLeg = null; //Motors for the feet
    public DcMotor rightLeg = null;
    
    public DcMotor spiralLift = null; //Motors for the archimedes screw
    public DcMotor spiralBrush = null;

    public CRServo highBrush = null; //Servos for the brush
    public CRServo lowBrush = null;
    public CRServo leftSweepOutServo = null;
    public CRServo rightSweepOutServo = null;

    public TouchSensor brushExtended;
    public TouchSensor brushRetracted;

    private double BRUSH_SPEED = 0.5; //Set betwwen 0.0 and 0.5
    private double REACH_SPEED = 0.3;
    private boolean BRUSH_MOVING = false;
    // Define a constructor that allows the OpMode to pass a reference to itself.


    /**
     * Initialize all the robot's hardware.
     * This method must be called ONCE when the OpMode is initialized.
     * <p>
     * All of the hardware devices are accessed via the hardware map, and initialized.
     */
     
    public RobotHardware (LinearOpMode opmode) {
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

        leftFoot        = myOpMode.hardwareMap.get(DcMotor.class, "myLeftFoot");
        rightFoot       = myOpMode.hardwareMap.get(DcMotor.class, "myRightFoot");

        spiralLift      = myOpMode.hardwareMap.get(DcMotor.class, "archimedes");
        spiralBrush     = myOpMode.hardwareMap.get(DcMotor.class, "brush");

        highBrush           = myOpMode.hardwareMap.get(CRServo.class, "highArmBrush");
        lowBrush            = myOpMode.hardwareMap.get(CRServo.class, "lowArmBrush");
        leftSweepOutServo   = myOpMode.hardwareMap.get(CRServo.class, "leftSweepOut");
        rightSweepOutServo  = myOpMode.hardwareMap.get(CRServo.class, "rightSeepOut");
        
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
     
    double drive;
    double strafe;
    double turn;
     
    public void driveRobot(double drive, double strafe, double turn) {
    // Combine drive and turn and strafe for blended motion.
        double leftFrontPower  = - drive - strafe - turn;
        double rightFrontPower = - drive + strafe + turn;
        double leftBackPower   =   drive + strafe - turn;
        double rightBackPower  =   drive - strafe + turn;
        
    // Scale the values so neither exceed +/- 1.0          
        double max;
        double min;
        
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

        myOpMode.telemetry.addData("Status", "Run Time: " + runtime.toString());
        myOpMode.telemetry.addData("Front left/Right", "%4.2f, %4.2f", leftFrontPower, rightFrontPower);
        myOpMode.telemetry.addData("Back  left/Right", "%4.2f, %4.2f", leftBackPower, rightBackPower);
        myOpMode.telemetry.update();
    }

    public void activateSweeper() { 
        highArmBrush.setPower(0.5 + BRUSH_SPEED);
        lowArmBrush.setPower (0.5 - BRUSH_SPEED);
    }
    public void deactivateSweeper() { 
        highArmBrush.setPower(0.5);
        lowArmBrush.setPower (0.5);
    }
    public void brushReach() { 
        if (!BRUSH_MOVING){
            if (brushExtended.isPressed()){
                leftSweepOut.setPower  (0.5 + REACH_SPEED);
                rightSweepOut.setPower (0.5 - REACH_SPEED);
            } else {
                leftSweepOut.setPower  (0.5 - REACH_SPEED);
                rightSweepOut.setPower (0.5 + REACH_SPEED);
            }
            brushMoving = true;
        }
        // We need to write in the opmode: if 
    }
    public void standUp(double inches) {
    
    }
    
    public void liftScrew(double inches) {

    }
    
    public void toggleSweeper() {
      
    }
    
    public void setScrewPower(double spin) {

    }
    
    public void toggleDepositDoor() {

    }
}
