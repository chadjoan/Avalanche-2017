package org.firstinspires.ftc.avalanche.utilities;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by Keith on 9/11/2016.
 *
 */
@TeleOp(name = "Color Sensor Tester", group = "Utilities")
public class ColorSensorTester extends LinearOpMode {

    ColorSensor colorSensor;

    //Initialize and Map All Hardware
    private void hardwareMapping() throws InterruptedException {
        colorSensor = hardwareMap.colorSensor.get("colorSensor");
    }

    @Override
    public void runOpMode() throws InterruptedException {

        hardwareMapping();

        telemetry.addData("Finished mapping", "");
        telemetry.update();

        waitForStart();

        // Go go gadget robot!
        while (opModeIsActive()) {

            if (gamepad1.a) {
                colorSensor.enableLed(true);
            }
            if (gamepad1.b) {
                colorSensor.enableLed(false);
            }

            telemetry.addData("Alpha:", colorSensor.alpha());
            telemetry.addData("Red:", colorSensor.red());
            telemetry.addData("Green:", colorSensor.green());
            telemetry.addData("Blue:", colorSensor.blue());
            telemetry.addData("ARGB:", colorSensor.argb());
            telemetry.update();

            idle();
        }
    }
}


