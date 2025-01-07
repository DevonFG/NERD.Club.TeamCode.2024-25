package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Concept: Robot Hardware Class", group="Robot")
public class AutoWithHardware extends LinearOpMode {

    // Create a RobotHardware object to be used to access robot hardware.
    // Prefix any hardware functions with "robot." to access this class.
    RobotHardware   robot       = new RobotHardware(this);

    @Override
    public void runOpMode() {
        double drive        = 0;
        double strafe       = 0;
        double turn         = 0;
        
        double INCH_TO_TICK = 100.0 // Untested value
        double FOOT_TO_TICK = INCH_TO_TICK*12
        
        double TICK_TO_INCH = 0.05; // Untested value
        double DEGREE_TO_TICK = 0.15*INCH_TO_TICK  // Degrees of turn at full speed turned to ticks of time if: 
                                                   // robot diameter from wheel to wheel is 16" and INCH_TO_TICK time is correct

        // double arm          = 0;
        // double handOffset   = 0;

        // initialize all the hardware, using the hardware class. See how clean and simple this is?
        robot.init();

        // Send telemetry message to signify robot waiting;
        // Wait for the game to start (driver presses START)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            robot.spinScrew(1.0); // Whatever full speed is
            sleep(100);
            
            robot.driveRobot(0.0, 1.0, 0.0); // (drive, strafe, turn) Get away from wall
            sleep(2*INCH_TO_TICK);
            driveRobot(0.0, 0.0, 0.0); 
            sleep(100);
                
            robot.driveRobot(1.0, 0.0, 0.0); // Drive to net Zone/baskets.  Can change based on where the robot starts. Currently 12 inches from front of robot
            sleep(12*INCH_TO_TICK);
            driveRobot(0.0, 0.0, 0.0); 
            sleep(100);
                
            robot.standUp("FullUp"); 
            robot.liftScrew("FullUp");  
            sleep(100);

            robot.toggleDepositDoor("on")  // Open (Hopefully)
            sleep(1000);
            robot.toggleDepositDoor("off")  // Close

            robot.spinScrew(0.0); // Stop screw spinning

            robot.standUp("RestFromFull");  // Drop down
            robot.liftScrew("RestFromFull");  
            sleep(100);

            robot.driveRobot(0.0, 0.0, 0.0) // Will be spinning toward the observation zone
            sleep()
        }
    }
}
