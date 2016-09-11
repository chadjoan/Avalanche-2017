package org.firstinspires.ftc.avalanche.teleop;

/**
 * Basic drive system used to test drive trains.
 * Currently has sound, which is a feature being tested.
 */

import android.media.MediaPlayer;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.avalanche.utilities.ScaleInput;
import org.firstinspires.ftc.avalanche.autonomous.ghostauto.MyApplication;
import org.firstinspires.ftc.avalanche.subsystems.DriveTrainController;



@TeleOp(name = "BasicDrive")
public class BasicDrive extends LinearOpMode {


    DcMotor motorLeftFore;
    DcMotor motorRightFore;
    DcMotor motorLeftAft;
    DcMotor motorRightAft;
    DcMotor motorHarvest;
    DriveTrainController driveTrain;
    MediaPlayer sanic = MediaPlayer.create(MyApplication.getContext(), com.qualcomm.ftcrobotcontroller.R.raw.sanic);


    //Initialize and Map All Hardware
    private void hardwareMapping() throws InterruptedException {
        motorLeftAft = hardwareMap.dcMotor.get("LeftAft");
        motorLeftFore = hardwareMap.dcMotor.get("LeftFore");
        motorRightAft = hardwareMap.dcMotor.get("RightAft");
        motorRightFore = hardwareMap.dcMotor.get("RightFore");
        motorHarvest = hardwareMap.dcMotor.get("Harvest");
        motorHarvest.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        driveTrain = new DriveTrainController(motorLeftAft, motorRightAft, motorLeftFore, motorRightFore);


        // Reset encoders
        driveTrain.resetEncoders();

    }

    @Override
    public void runOpMode() throws InterruptedException {

        //   try {
        //       outputStreamWriter = new OutputStreamWriter(MyApplication.getContext().openFileOutput("auto.txt", Context.MODE_PRIVATE));
        //   }
        //   catch (IOException e) {
        //       Log.e("Exception", "File write failed: " + e.toString());
        //   }

        hardwareMapping();

        //telemetry.addData( "Finished mapping", new MyApplication().getApplicationContext());
        telemetry.update();

        sanic.start();

        waitForStart();

        if (sanic.isPlaying()) {
            sanic.stop();
        }


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

            if (gamepad1.a) {
                if (motorHarvest.getPower() != -.6) {
                    motorHarvest.setPower(-.6);
                } else {
                    motorHarvest.setPower(0);
                }
            }

            if (gamepad1.y) {
                if (motorHarvest.getPower() != .7) {
                    motorHarvest.setPower(.7);
                } else {
                    motorHarvest.setPower(0);
                }
            }

            idle();

        }
    }
}

