package org.firstinspires.ftc.avalanche.utilities;

/**
 * Created by Keith on 9/14/2016.
 */
public class ColorReader {

    // LED must be OFF
    public static boolean isRed(int red, int green, int blue)
    {
        return red > 10 && blue < 10 && green < 10;
    }

    // LED must be OFF
    public static boolean isBlue(int red, int green, int blue)
    {
        return red < 10 && blue > 10 && green < 10;
    }

    // LED must be ON
    public static boolean isFloor(int red, int green, int blue)
    {
        return red < 5 && green < 5 && blue < 5;
    }

}
