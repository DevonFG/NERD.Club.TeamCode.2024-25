import org.firstinspires.ftc.teamcode.HardwareFile2024;
import org.firstinspires.ftc.teamcode.AutonomousHardware;
@Autonomous(name="RightSideBasicAutonomous", group="9044.NERD.")
public class Autonomous extends LinearOpMode {

    @Override
    public void runOpMode() {
      
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // arch screw spin normal
            // arch screw spin off
            robot.driveRobot(1.0, 0.0, 0.0);
            delay(PANEL*0.6);
            // strafe left 1 
            // arch scew spin inverse
            // arch scew spin off
            // strafe right 1.5 panels (leftmost sample)
            // arm forward
            robot.toggleFingers("normal");
            // arm back
            // arch screw spin normal
            // arch screw spin off
            robot.toggleFingers("off");
            // strafe left 1.5 panels
            // arch scew spin inverse
            // arch scew spin off
            // strafe right 1.75 panels (middle sample)
            // arm forward
            // fingers spin normal
            // arm back
            // arch screw spin normal
            // arch screw spin off
            // fingers off
            // strafe left 1.75 panels
            // arch scew spin inverse
            // arch scew spin off
            // strafe right 1.5 panels (rightmost sample)
            // forward 1 panel
            // turn CW 90 deg
            // DO NOT MOVE ARM
            // spin fingers normal
            // arch screw spin normal
            // arch screw spin off
            // fingers off
            // turn CCW 90 deg
            // backward 1 panel
            // strafe left 1.5 panels
            // arch scew spin inverse
            // arch scew spin off
            // strafe right 2 panels
            // backward 0.6 panels
            // Flash lights or something
            
        }
    }
}
