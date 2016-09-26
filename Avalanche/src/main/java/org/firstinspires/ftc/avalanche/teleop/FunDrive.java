package org.firstinspires.ftc.avalanche.teleop;

import android.media.MediaPlayer;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.avalanche.subsystems.DriveTrainController;
import org.firstinspires.ftc.avalanche.utilities.ScaleInput;

@TeleOp(name = "FunDrive", group = "TeleOp")
public class FunDrive extends LinearOpMode {


    DcMotor motorLeftFront;
    DcMotor motorRightFront;
    DcMotor motorLeftBack;
    DcMotor motorRightBack;
    DriveTrainController driveTrain;

    private final double CONSTANT_DRIVE_SPEED = 1;

    //Initialize and Map All Hardware
    private void hardwareMapping() throws InterruptedException {
        motorLeftBack = hardwareMap.dcMotor.get("LeftBack");
        motorLeftFront = hardwareMap.dcMotor.get("LeftFront");
        motorRightBack = hardwareMap.dcMotor.get("RightBack");
        motorRightFront = hardwareMap.dcMotor.get("RightFront");

        driveTrain = new DriveTrainController(motorLeftFront, motorRightFront, motorLeftBack, motorRightBack);

        // Reset encoders
        driveTrain.resetEncoders();

        playR2D2();
    }

    @Override
    public void runOpMode() throws InterruptedException {

        hardwareMapping();

        // Wait for the game to start
        waitForStart();

        //Test our media player
        //sanic.start();

        // Go go gadget robot!
        while (opModeIsActive()) {

            driveTrain.setLeftDrivePower(gamepad1.left_stick_y);

            driveTrain.setLeftDrivePower(gamepad1.right_stick_y);

            if (gamepad1.a)
            {
                playR2D2();
            }

            if (gamepad1.b)
            {
                //not yet implemented
            }

            if (gamepad1.x)
            {
                //not yet implemented
            }

            if (gamepad1.y)
            {
                //not yet implemented
            }

            if (gamepad1.dpad_down)
            {
                //not yet implemented
            }

            if (gamepad1.dpad_left)
            {
                //not yet implemented
            }

            if (gamepad1.dpad_right)
            {
                //not yet implemented
            }

            if (gamepad1.dpad_up) {
                //not yet implemented
            }

            idle();

        }
    }

    private void playR2D2()
    {
        MediaPlayer r2d2 = MediaPlayer.create(hardwareMap.appContext, org.firstinspires.ftc.avalanche.R.raw.r2d2a);

        int rand = (int)(Math.random()*5);

        switch (rand)
        {
            case 0:
                r2d2 = MediaPlayer.create(hardwareMap.appContext, org.firstinspires.ftc.avalanche.R.raw.r2d2a);
                break;
            case 1:
                r2d2 = MediaPlayer.create(hardwareMap.appContext, org.firstinspires.ftc.avalanche.R.raw.r2d2b);
                break;
            case 2:
                r2d2 = MediaPlayer.create(hardwareMap.appContext, org.firstinspires.ftc.avalanche.R.raw.r2d2c);
                break;
            case 3:
                r2d2 = MediaPlayer.create(hardwareMap.appContext, org.firstinspires.ftc.avalanche.R.raw.r2d2d);
                break;
            case 4:
                r2d2 = MediaPlayer.create(hardwareMap.appContext, org.firstinspires.ftc.avalanche.R.raw.r2d2e);
                break;
        }

        r2d2.start();
    }
}

