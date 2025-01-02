import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.HardwareFile2024;

@TeleOp(name="BasicDriveCode", group="9044.NERD.")
public class BasicDriveCode extends LinearOpMode {
  
    @Override
    public void runOpMode() {
        
        HardwareFile2024 robot = new HardwareFile2024(this);
        robot.init();
        waitForStart();
        //runtime.reset();
        
        double axial;
        double strafe;
        double rotation;
        
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
          
            // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
            axial    = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value - Forward and Backward 
            strafe   =  gamepad1.left_stick_x;  // Strafe - Left and Right - taking move right as positive
            rotation =  gamepad1.right_stick_x;  // Rotation - ClockWise and CounterClockWise - taking turn right as positive
          
            robot.driveRobot(axial, strafe, rotation);
          
        }
    }}
