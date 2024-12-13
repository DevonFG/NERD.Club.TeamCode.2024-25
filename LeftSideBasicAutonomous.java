import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.HardwareFile2024;
// import org.firstinspires.ftc.teamcode.AutonomousHardware;

@Autonomous(name="LeftSideBasicAutonomous", group="9044.NERD.")
public class Autonomous extends LinearOpMode {

    @Override
    public void runOpMode() {
        
        HardwareFile2024 robot = new HardwareFile2024(this);
        robot.init();
        waitForStart();
        runtime.reset();

        int AUTO_SCORING = 4;

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // robot.driveRobot(axial, strafe, rotation);
            // axial - pos is forward, neg is backward
            // strafe - pos is right, neg is left
            // rotation - pos is clockwise, neg is counterclockwise

            //instructions
            for (int scores = 0; scores = <AUTO_SCORING; scores++;) {
                //code to score 
            }
            //instructions like what is below
            
            robot.driveRobot(1.0, 0.0, 0.0);
            sleep(2000);
            robot.driveRobot(0.0, 0.0, 0.0);
            robot.driveRobot(0.0, 1.0, 0.0);
            sleep(2000);
            robot.driveRobot(0.0, 0.0, 0.0);
            robot.driveRobot(1.0, 0.0, 0.0);
            sleep(2000);
            robot.driveRobot(0.0, 0.0, 0.0);

            robot.telemetryUpdate();
            
        }
    }
}
