package org.firstinspires.ftc.avalanche.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by Keith on 9/11/2016.
 *
 */
@TeleOp(name = "Color Sensor Tester")
public class ColorSensorTester extends LinearOpMode {

    ColorSensor colorSensor;

    //Initialize and Map All Hardware
    private void hardwareMapping() throws InterruptedException {
        colorSensor = hardwareMap.colorSensor.get("colorSensor");
    }

    @Override
    public void runOpMode() throws InterruptedException {


        hardwareMapping();

        telemetry.addData( "Finished mapping", "");
        telemetry.update();

        waitForStart();

        // Go go gadget robot!
        while (opModeIsActive())
        {
            colorSensor.argb();

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


