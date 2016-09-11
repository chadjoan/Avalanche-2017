package org.firstinspires.ftc.avalanche.autonomous.intelligentauto;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.hardware.GyroSensor;

import org.firstinspires.ftc.avalanche.subsystems.DriveTrainController;
import org.firstinspires.ftc.robotcore.external.Telemetry;


/**
 * Created by austinzhang on 8/13/16.
 */
public class Store {
    long startTime;
    int drift;
    int offset;
    static Location STARTING_POSITION = new Location(0,0);
    static final double WHEEL_DIAMETER = 10.16; //IN CM
    static final int TICKS_PER_ROTATION = 1120;    Cell[][] field;
    static final double TICKS_PER_CM = 35.09;

    Location lastPosition;

    DriveTrainController driveTrain;
    GyroSensor gyro;
    ModernRoboticsI2cRangeSensor range;
    AStarPathfinder pathfinder;
    ParsePath pathrover;
    Scanner scanner;

    Telemetry telemetry;

    byte[] rangeReadings;

}
