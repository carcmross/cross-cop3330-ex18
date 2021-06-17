package base;

import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright Marc-Anthony Cross
 */

/*
 * You’ll often need to determine which part of a program is run based on user input or other events.
 *
 * Create a program that converts temperatures from Fahrenheit to Celsius or from Celsius to Fahrenheit. Prompt for
 * the starting temperature. The program should prompt for the type of conversion and then perform the conversion.
 *
 * The formulas are
 *
 * C = (F − 32) × 5 / 9
 *
 * and
 *
 * F = (C × 9 / 5) + 32
 *
 * Example Output
 *
 * Press C to convert from Fahrenheit to Celsius.
 * Press F to convert from Celsius to Fahrenheit.
 * Your choice: C
 * Please enter the temperature in Fahrenheit: 32
 * The temperature in Celsius is 0.
 * Constraints
 *
 *     Ensure that you allow upper or lowercase values for C and F.
 *     Use as few output statements as possible and avoid repeating output strings.
 *
 * Challenges
 *
 *     Revise the program to ensure that inputs are entered as numeric values. Don’t allow the user to proceed if the
 *     value entered is not numeric.
 *     Break the program into functions that perform the computations.
 *     Implement this program as a GUI program that automatically updates the values when any value changes.
 *     Modify the program so it also supports the Kelvin scale.
 *
 */

public class App {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String convertTo = getScale();
        String orig_temp = getOrigTemp(convertTo);
        String conversion = convertTemp(orig_temp, convertTo);
        String outputString = generateOutput(convertTo, conversion);
        System.out.println(outputString);
    }

    public static String generateOutput(String scale, String conversion) {
        if (isFarhenheit(scale))
            return "The temperature in Farhenheit is " + conversion + ".";
        else if (isCelsius(scale))
            return "The temperature in Celsius is " + conversion + ".";
        return "";
    }

    public static String getOrigTemp(String scale) {
        if (isCelsius(scale)) {
            System.out.print("Enter the temperature in Farhenheit: ");
            return in.nextLine();
        }
        else if (isFarhenheit(scale)) {
            System.out.print("Enter the temperature in Celsius: ");
            return in.nextLine();
        }
        return "";
    }

    public static String getScale() {
        System.out.printf("Press C to convert from Farhenheit to Celcius.\nPress F to convert from Celsius to " +
                                "Farhenheit\nYour choice: ");
        return in.nextLine();
    }

    public static boolean isFarhenheit(String scale) {
        if (scale.equals("F") || scale.equals("f"))
            return true;
        return false;
    }

    public static boolean isCelsius(String scale) {
        if (scale.equals("C") || scale.equals("c"))
            return true;
        return false;
    }

    public static String convertTemp(String temperature, String scale) {
        if (isFarhenheit(scale)) {
            int val_celsius = Integer.parseInt(temperature);
            int val_farhenheit = (val_celsius * 9) / 5 + 32;
            return String.valueOf(val_farhenheit);
        } else if (isCelsius(scale)) {
            int val_farhenheit = Integer.parseInt(temperature);
            int val_celsius = ((val_farhenheit - 32) * 5) / 9;
            return String.valueOf(val_celsius);
        }
        return "";
    }
}
