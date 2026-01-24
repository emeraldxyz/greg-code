package org.firstinspires.ftc.teamcode.tuning;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Launcher {



    private Servo doorMan;
    public DcMotorEx shooter;


    //double targetRPM = 0;     // actual shooter RPM target
    double Cannon_speed;

    Gamepad controler;
    Telemetry telemetry;
  //  public static final double TICKS_PER_REV = 28;

    public Launcher(Gamepad gamepad2, Telemetry tel, HardwareMap hardwareMap) {



        controler = gamepad2;
        telemetry = tel;
        doorMan = hardwareMap.get(Servo.class, "doorMan");
        shooter = hardwareMap.get(DcMotorEx.class, "shooter");
       // shooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       // shooter.setVelocity(0);
        shooter.setDirection(DcMotorEx.Direction.REVERSE);
    }

    public void tick() {
        telemetry.addData("Cannon speed :", Cannon_speed);
        telemetry.addData("actual speed", shooter.getVelocity());
        // telemetry.update();

        if (controler.left_bumper) {
            doorMan.setPosition(0.5);
        } else {
            doorMan.setPosition(0);
        }
        if (controler.dpadRightWasPressed()) {
            Cannon_speed += -100;
        }
        if (controler.dpadLeftWasPressed()) {
            Cannon_speed += 100;
        }
        if (controler.dpadUpWasPressed()) {
            ((DcMotorEx) shooter).setVelocity(-Cannon_speed);
        }
        if (controler.dpadDownWasPressed()) {
            ((DcMotorEx) shooter).setVelocity(0);
        }

       if (shooter.getVelocity()  == 1100){
           controler.rumble(100, 100,1000);


           telemetry.update();
       }

    }


}

