package org.firstinspires.ftc.avalanche.teleop;

import android.media.MediaPlayer;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.avalanche.utilities.ScaleInput;
import org.firstinspires.ftc.avalanche.subsystems.DriveTrainController;

@TeleOp(name = "BasicDrive", group = "TeleOp")
public class BasicDrive extends LinearOpMode {


    DcMotor motorLeftFront;
    DcMotor motorRightFront;
    DcMotor motorLeftBack;
    DcMotor motorRightBack;
    DriveTrainController driveTrain;
    
    //Initialize and Map All Hardware
    private void hardwareMapping() throws InterruptedException {
        motorLeftBack = hardwareMap.dcMotor.get("LeftBack");
        motorLeftFront = hardwareMap.dcMotor.get("LeftFront");
        motorRightBack = hardwareMap.dcMotor.get("RightBack");
        motorRightFront = hardwareMap.dcMotor.get("RightFront");


        driveTrain = new DriveTrainController(motorLeftFront, motorRightFront, motorLeftBack, motorRightBack);


        // Reset encoders
        driveTrain.resetEncoders();

        sanic = MediaPlayer.create(hardwareMap.appContext, org.firstinspires.ftc.avalanche.R.raw.sanic);
    }

    @Override
    public void runOpMode() throws InterruptedException {

        hardwareMapping();

        waitForStart();

        //Test our media player
        sanic.start();

        // Go go gadget robot!
        while (opModeIsActive()) {


            if (ScaleInput.scale(gamepad1.left_trigger + gamepad1.right_trigger) > 0) {
                if (gamepad1.left_trigger > gamepad1.right_trigger) {
                    driveTrain.manualDrive(-gamepad1.left_trigger, -gamepad1.left_trigger);
                } else {
                    driveTrain.manualDrive(gamepad1.right_trigger, gamepad1.right_trigger);
                }
            }


            //turn right
            if (gamepad1.right_bumper) {
                driveTrain.setLeftDrivePower(.2);
                driveTrain.setRightDrivePower(-.2);
            }

            //turn left
            if (gamepad1.left_bumper) {
                driveTrain.setLeftDrivePower(-.2);
                driveTrain.setRightDrivePower(.2);
            }

            if (!gamepad1.left_bumper && !gamepad1.right_bumper && !(ScaleInput.scale(gamepad1.left_trigger + gamepad1.right_trigger) > 0)) {
                driveTrain.setLeftDrivePower(0);
                driveTrain.setRightDrivePower(0);
            }

            idle();

        }
    }
}

