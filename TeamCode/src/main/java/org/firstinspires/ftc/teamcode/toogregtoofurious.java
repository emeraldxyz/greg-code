

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "toogregtoofurious (Blocks to Java)")
public class toogregtoofurious extends LinearOpMode {

  private DcMotor leftFront;
  private DcMotor rightFront;
  private DcMotor leftBack;
  private DcMotor rightBack;
  private DcMotor shooter;
  /**
   * Describe this function...
   */
  private void go() {
    leftFront.setPower(gamepad1.left_stick_y);
    rightFront.setPower(gamepad1.left_stick_y);
    leftBack.setPower(gamepad1.left_stick_y);
    rightBack.setPower(gamepad1.left_stick_y);
  }

  /**
   * Describe this function...
   */
  private void stafe() {
  }

  /**
   * This sample contains the bare minimum Blocks for any regular OpMode. The 3 blue
   * Comment Blocks show where to place Initialization code (runs once, after touching the
   * DS INIT button, and before touching the DS Start arrow), Run code (runs once, after
   * touching Start), and Loop code (runs repeatedly while the OpMode is active, namely not
   * Stopped).
   */
  @Override
  public void runOpMode() {
    leftFront = hardwareMap.get(DcMotor.class, "leftFront");
    rightFront = hardwareMap.get(DcMotor.class, "rightFront");
    leftBack = hardwareMap.get(DcMotor.class, "leftBack");
    rightBack = hardwareMap.get(DcMotor.class, "rightBack");
    shooter = hardwareMap.get(DcMotor.class, "shooter");

    // Put initialization blocks here.
    rightFront.setDirection(DcMotor.Direction.REVERSE);
    rightBack.setDirection(DcMotor.Direction.REVERSE);
    double i;
    double Up = 0;;
    waitForStart();
    telemetry.update();
    if (opModeIsActive()) {
      // Put run blocks here.
      i = 0.5;;
      while (opModeIsActive()) {
        // Put loop blocks here.

          if (gamepad1.dpadDownWasPressed()) {
            Up += i;;
          }
          if (gamepad1.dpadUpWasPressed()) {
            Up += -i;;
          }
          shooter.setPower(Up);

      }
    }
  }

  /**
   * Describe this function...
   */
  private void turn() {
    leftFront.setPower(-gamepad1.right_stick_x);
    rightBack.setPower(gamepad1.right_stick_x);
    rightFront.setPower(gamepad1.right_stick_x);
    leftBack.setPower(-gamepad1.right_stick_x);
  }
}