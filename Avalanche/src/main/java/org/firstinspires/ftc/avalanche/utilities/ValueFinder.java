package org.firstinspires.ftc.avalanche.utilities;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "Value Finder", group = "Utilities")
public class ValueFinder extends LinearOpMode {

    private Servo beaconTilt;
    private Servo beaconShuttle;


    private int currentIndex;
    private int totalDevices = 2;
    private boolean isServo;
    private String deviceName;

    //Initialize and Map All Hardware
    private void hardwareMapping() throws InterruptedException {
        currentIndex = 0;

        beaconTilt = hardwareMap.servo.get("beaconTilt");
        beaconShuttle = hardwareMap.servo.get("beaconShuttle");


        beaconTilt.setPosition(ValueStore.BUTTON_PRESSER_STORE_ANGLE);
        beaconShuttle.setPosition(ValueStore.BUTTON_PRESSER_RETRACTED);
    }

    @Override
    public void runOpMode() throws InterruptedException {

        hardwareMapping();

        waitForStart();

        // Go go gadget robot!
        while (opModeIsActive()) {

            Servo currentServo = null;
            DcMotor currentMotor = null;

            if (gamepad1.right_bumper) {
                currentIndex += 1;
                if (currentIndex >= totalDevices) {
                    currentIndex = 0;
                }
            }

            if (gamepad1.left_bumper) {
                currentIndex -= 1;
                if (currentIndex < 0) {
                    currentIndex = totalDevices - 1;
                }
            }


            if (currentIndex == 0) {
                currentServo = beaconShuttle;
                isServo = true;
                deviceName = "Beacon Shuttle";
            }

            if (currentIndex == 1) {
                currentServo = beaconTilt;
                isServo = true;
                deviceName = "Beacon Tilt";
            }



            if (isServo) {
                currentServo.setPosition(currentServo.getPosition() + (ScaleInput.scale(gamepad1.left_stick_y) / 30));
                telemetry.addData(deviceName, currentServo.getPosition());
            }
            else {
                currentMotor.setPower(ScaleInput.scale(gamepad1.left_stick_y));
                telemetry.addData(deviceName, currentMotor.getCurrentPosition());
            }

            telemetry.update();

            idle();
        }

    }
}

