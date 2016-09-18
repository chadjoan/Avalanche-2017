package org.firstinspires.ftc.avalanche.utilities;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by Keith on 9/11/2016.
 * Change by Austin on 9/17/2016: Modified ColorSensorTester to work with and test new algorithms
 */
@TeleOp(name = "Color Sensor Tester", group = "Utilities")
public class ColorSensorTester extends LinearOpMode {

    ColorSensor colorSensorBeacon;
    ColorSensor colorSensorFloor;

    int initialLight;

    //Initialize and Map All Hardware
    private void hardwareMapping() throws InterruptedException {
        //Initialize and setup color sensors
        colorSensorBeacon = hardwareMap.colorSensor.get("colorSensorBeacon");
        colorSensorFloor = hardwareMap.colorSensor.get("colorSensorFloor");
        colorSensorBeacon.enableLed(false);
        colorSensorFloor.enableLed(true);
        initialLight = colorSensorFloor.red() + colorSensorFloor.green() + colorSensorFloor.blue();
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
                colorSensorFloor.enableLed(true);
            }
            if (gamepad1.b) {
                colorSensorFloor.enableLed(false);
            }

            if (gamepad1.x) {
                colorSensorBeacon.enableLed(false);
            }

            if (gamepad1.y) {
                colorSensorBeacon.enableLed(true);
            }

            int currentLight = colorSensorFloor.red() + colorSensorFloor.green() + colorSensorFloor.blue();

            telemetry.addData("Beacon Red:", colorSensorBeacon.red());
            telemetry.addData("Beacon Green:", colorSensorBeacon.green());
            telemetry.addData("Beacon Blue:", colorSensorBeacon.blue());
            telemetry.addData("Floor Red:", colorSensorBeacon.red());
            telemetry.addData("Floor Green:", colorSensorBeacon.green());
            telemetry.addData("Floor Blue:", colorSensorBeacon.blue());
            telemetry.addData("Is Red",
                    ColorReader.isRed(colorSensorBeacon.red(), colorSensorBeacon.green(), colorSensorBeacon.blue()));
            telemetry.addData("Is Blue",
                    ColorReader.isBlue(colorSensorBeacon.red(), colorSensorBeacon.green(), colorSensorBeacon.blue()));
            telemetry.addData("Is White",
                    ColorReader.isWhite(initialLight, currentLight));
            telemetry.update();

            idle();
        }
    }
}


