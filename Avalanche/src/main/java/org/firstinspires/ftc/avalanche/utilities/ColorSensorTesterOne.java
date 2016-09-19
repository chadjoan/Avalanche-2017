package org.firstinspires.ftc.avalanche.utilities;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;

/**
 * Created by Keith on 9/11/2016.
 * Change by Austin on 9/17/2016: Modified ColorSensorTester to work with and test new algorithms
 */
@TeleOp(name = "Color Sensor Tester One", group = "Utilities")
public class ColorSensorTesterOne extends LinearOpMode {

    ColorSensor colorSensorBeacon;

    int initialLight;

    //Initialize and Map All Hardware
    private void hardwareMapping() throws InterruptedException {
        //Initialize and setup color sensors
        colorSensorBeacon = hardwareMap.colorSensor.get("colorLeft");


        colorSensorBeacon.enableLed(false);

        colorSensorBeacon.setI2cAddress(new I2cAddr(0x03c/2));

        telemetry.addData("i2c address", colorSensorBeacon.getI2cAddress().get8Bit());
    }

    @Override
    public void runOpMode() throws InterruptedException {

        hardwareMapping();

        telemetry.addData("Finished mapping", "");
        telemetry.update();

        waitForStart();

        // Go go gadget robot!
        while (opModeIsActive()) {


            if (gamepad1.x) {
                colorSensorBeacon.enableLed(false);
            }

            if (gamepad1.y) {
                colorSensorBeacon.enableLed(true);
            }


            telemetry.addData("Beacon Red:", colorSensorBeacon.red());
            telemetry.addData("Beacon Green:", colorSensorBeacon.green());
            telemetry.addData("Beacon Blue:", colorSensorBeacon.blue());
            telemetry.addData("Is Red",
                    ColorReader.isRed(colorSensorBeacon.red(), colorSensorBeacon.green(), colorSensorBeacon.blue()));
            telemetry.addData("Is Blue",
                    ColorReader.isBlue(colorSensorBeacon.red(), colorSensorBeacon.green(), colorSensorBeacon.blue()));
            telemetry.update();

            idle();
        }
    }
}


