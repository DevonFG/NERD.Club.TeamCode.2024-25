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

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
/*
          forwardAndBackward("f");
          sleep(1000);
          reset();
          sideways("r");
          sleep(1000);
          reset();
          forwardAndBackward("f");
          sleep(1000);
          reset();
            */
            
            // robot.driveRobot(axial, strafe, rotation);
            // axial - pos is forward, neg is backward
            // strafe - pos is right, neg is left
            // rotation - pos is clockwise, neg is counterclockwise
            
            robot.driveRobot(1.0, 0.0, 0.0);
            sleep(2000);
            robot.driveRobot(0.0, 0.0, 0.0);
            robot.driveRobot(0.0, 1.0, 0.0);
            sleep(2000);
            robot.driveRobot(0.0, 0.0, 0.0);
            robot.driveRobot(1.0, 0.0, 0.0);
            sleep(2000);
            robot.driveRobot(0.0, 0.0, 0.0);
            
        }
    }
}
