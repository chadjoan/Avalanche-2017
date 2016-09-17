package org.firstinspires.ftc.avalanche.utilities;

/**
 * Created by Keith on 9/14/2016.
 * Change by Austin on 9/17/2016: Modified detection algorithm for color detection to be based
 * off of %RGB instead of static RGB values. - Needs calibration
 */
public class ColorReader {

    // LED must be OFF
    public static boolean isRed(int red, int green, int blue)
    {
        //Percentage of total light required to be red to be considered red
        int percentageThreshold = 40;


        return isColor(percentageThreshold, 15, red, green, blue);
    }

    // LED must be OFF
    public static boolean isBlue(int red, int green, int blue)
    {
        //Percentage of total light required to be blue to be considered blue
        int percentageThreshold = 40;


        return isColor(percentageThreshold, 15, blue, green, red);
    }

    // LED must be ON
    // Different algorithm due to measuring change in total amount of light, not color.
    // originalLight is the light value at initialization.
    // currentLight is the light value at the current time.
    public static boolean isWhite(int originalLight, int currentLight)
    {
        //Change this value to calibrate program
        int percentIncreaseThreshold = 200;



        if (originalLight == 0) {
            originalLight = 1;
        }

        int percentIncrease = ((currentLight * 100) / (originalLight)) - 100;

        return percentIncrease > percentIncreaseThreshold;
    }


    //Algorithm for deciding color
    private static boolean isColor(int percentageThreshold, int minimumLight, int targetColor, int firstColor, int secondColor) {
        int totalLight = targetColor + firstColor + secondColor;

        if (minimumLight > totalLight) {
            return false;
        }

        int percentageTarget = (targetColor * 100) / totalLight;
        return (percentageTarget >= percentageThreshold);
    }

}
