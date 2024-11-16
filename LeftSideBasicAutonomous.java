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
          
          }
        }
     }
