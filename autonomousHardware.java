import org.firstinspires.ftc.teamcode.HardwareFile2024;

public class autonomousHardware {
  // Declare paremeters to be used for all autonomous movement.  
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
}
