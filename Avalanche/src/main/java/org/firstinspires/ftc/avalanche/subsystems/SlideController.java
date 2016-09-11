package org.firstinspires.ftc.avalanche.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.avalanche.utilities.ScaleInput;

/**
 * Drawer slide controller
 */
public class SlideController extends MotorController {
    MotorController motor;

    public SlideController(DcMotor motor) {
        this.motor = new MotorController();
        this.motor.add(motor);
    }

    public void manualControl(double input) {
        if (ScaleInput.scale(input) != 0) {
            motor.setPower(0, input);
        }
    }
}
