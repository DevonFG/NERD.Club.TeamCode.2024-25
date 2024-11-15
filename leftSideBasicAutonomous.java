import org.firstinspires.ftc.teamcode.HardwareFile2024;

@Autonomous(name="LeftSideBasicAutonomous", group="9044.NERD.")
public class Autonomous extends LinearOpMode {
  
    // Declare OpMode members.
    // private ElapsedTime runtime = new ElapsedTime();
    
  // only parameter is direction, give either string of f or b.    
    public void forwardAndBackward(String direction) {
      if (direction == "f") {
        setMotorPower(leftFrontWheel,   1.0);
        setMotorPower(leftBackWheel,    1.0);
        setMotorPower(rightFrontWheel,  1.0);
        setMotorPower(rightBackWheel,   1.0);
      } else if (direction == "b") {
        setMotorPower(leftFrontWheel,  -1.0);
        setMotorPower(leftBackWheel,   -1.0);
        setMotorPower(rightFrontWheel, -1.0);
        setMotorPower(rightBackWheel,  -1.0);              
      }
    }

    // only parameter is direction, give either string of r or l.
    private void sideways (String direction) {
      if (direction == "r") {
        setMotorPower(leftFrontWheel,   1.0);
        setMotorPower(leftBackWheel,   -1.0);
        setMotorPower(rightFrontWheel, -1.0);
        setMotorPower(rightBackWheel,   1.0);
      } else if (direction == "l") {
        setMotorPower(leftFrontWheel,  -1.0);
        setMotorPower(leftBackWheel,    1.0);
        setMotorPower(rightFrontWheel,  1.0);
        setMotorPower(rightBackWheel,  -1.0);
      }
    }

    // no parameters, just sets all motors to power 0
     private void reset() {
        setMotorPower(leftFrontWheel,   0.0);
        setMotorPower(leftBackWheel,    0.0);
        setMotorPower(rightFrontWheel,  0.0);
        setMotorPower(rightBackWheel,   0.0);
    }

    @Override
    public void runOpMode() {
      
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
      /*    
          
          */

          forwardAndBackward("f");
          sleep(2000);
          reset();
          sideways("r");
          sleep(1000);
          reset();
          forwardAndBackward("f");
          sleep(1000);
          reset();
          
          
          }
        }
     }
