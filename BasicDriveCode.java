import org.firstinspires.ftc.teamcode.HardwareFile2024;

@TeleOp(name="BasicDriveCode", group="9044.NERD.")
public class BasicDriveCode extends LinearOpMode {
  
    @Override
    public void runOpMode() {

        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
          
            // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
            double axial    = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value - Forward and Backward 
            double strafe   =  gamepad1.left_stick_x;  // Strafe - Left and Right - taking move right as positive
            double rotation =  gamepad1.right_stick_x;  // Rotation - ClockWise and CounterClockWise - taking turn right as positive
            
            driveRobot(axial, strafe, rotation);
          
        }
    }}
