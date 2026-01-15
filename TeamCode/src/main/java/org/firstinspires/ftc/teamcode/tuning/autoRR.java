package org.firstinspires.ftc.teamcode.tuning;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.MecanumDrive;
@Autonomous(name = "autoRR")
public class autoRR extends LinearOpMode {
    @Override




        public void runOpMode(){

            Pose2d startPose = new Pose2d(12, 60, Math.toRadians(90));
            MecanumDrive drive = new MecanumDrive(HardwareMap,startPose);

            Action goTO = drive.actionBuilder(startPose)
                    .strafeTo(new Vector2d(12,12))
                    .build();

            waitForStart();
            if (isStopRequested())return;


            Actions.runBlocking(goTO);
            }
        }
    }
