import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.HardwareFile2024;

@TeleOp(name="AdvancedDriveCode", group="9044.NERD.")
public class AdvancedDriveCode extends LinearOpMode {
  
    @Override
    public void runOpMode() {
        
        HardwareFile2024 robot = new HardwareFile2024(this);
        robot.init();
        telemetry.addData(">", "Hardware Initialized");
        telemetry.update();
  
        waitForStart();
        //runtime.reset();
        
        double drive;
        double strafe;
        double turn;
        String power;
        String buttonsMode = "Fingers";
        
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
          
        }
    
    }
    
}
