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
          
            // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
            drive    = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value - Forward and Backward 
            strafe   =  gamepad1.left_stick_x;  // Strafe - Left and Right - taking move right as positive
            turn     =  gamepad1.right_stick_x;  // Rotation - ClockWise and CounterClockWise - taking turn right as positive
            
            robot.driveRobot(drive, strafe, turn);
            
            if (gamepad2.start) {
                if (buttonsMode == "Fingers") {
                    buttonsMode = "ScrewBrush";
                    // add code to switch light color - Yellow
                } else if (buttonsMode == "ScrewBrush") {
                    buttonsMode = "Fingers";
                    // add code to switch light color - Green
                } else {
                    telemetry.addData("Mode Unknown SWAP ERROR", null);
                    telemetry.update();
                    // add code to switch light color - Flash Both
                }
            }

            if (gamepad2.a) {
              if (buttonsMode == "Fingers") {
                
              } else if (buttonsMode == "ScrewBrush") {
                
              } else {
                telemetry.addData("Mode Unknown BUTTON ERROR");
                telemetry.update();
                // add code to flash both light colors
            }

            if (gamepad2.b) {
              
            }

            if (gamepad2.y) {
              
            }
            // buttons coded: driving joysticks, swap
            // buttons to be coded: 
            // CONTROLLER 2
            // arch screw controls - dpad
            // arm forward backward - bumpers
            // door open - right trigger
            // code for modes that swap - a, b, y
            // manual screw controls - left joystick
            // CONTROLLER 1
            //stand up/down controls - dpad
            // stand up/down manual mode - triggers
            // finger off - y
            // brush off - x
            
        }
    
    }
    
}
