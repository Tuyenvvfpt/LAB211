/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Ultility {

    public static final Scanner scanner = new Scanner(System.in);
    public static final String REGEX_STRING = "[a-zA-Z0-9 ]+";
    public static final String REGEX_YN = "[yYnN]";
 
    public static int getInt(String message, int min, int max) {

        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!");
                } else {
                    int number = Integer.parseInt(input);
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.out.println("must in range " + min + " <= number <= " + max);
                    }
                }
            } catch (NumberFormatException exception) {
                System.out.println("Input must be a integer number");
            }

        }

    }

    public static double getDouble(String message, double min, double max) {

        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!");
                } else {
                    double number = Double.parseDouble(input);
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.out.println("must in range " + min + " <= number <= " + max);
                    }
                }
            } catch (NumberFormatException exception) {
                System.out.println("Input must be a integer number");
            }

        }

    }

    public static float getFloat(String message, float min, float max) {

        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!");
                } else {
                    float number = Float.parseFloat(input);
                    if (number > min && number <= max) {
                        return number;
                    } else {
                        System.out.println("must in range " + min + " <= number <= " + max);
                    }
                }
            } catch (NumberFormatException exception) {
                System.out.println("Input must be a integer number");
            }

        }

    }

//    public static double getDouble() {
//    }
//    public static String getString() {
//
//        
//    }
    public static String getString(String message, String regex, String error) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty");
            } else {
                //if input matches regex => return input
                // else print error
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.out.println(error);
                }
            }
        }

    }
  
}
