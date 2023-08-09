/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Utility {

    static Scanner scanner = new Scanner(System.in);
    public static String REGEX_STRING = "[a-zA-Z0-9 ]+";
    public static final String REGEX_DATE = "\\d{1,2}[/]\\d{1,2}[/]\\d{4}";
    public static final String REGEX_YN = "[yYnN]";
        static final String REGEX_UD = "[uUdD]";
   /**
    * 
    * @param mess
    * @param error
    * @param min
    * @param max
    * @return 
    */
    public static int getInt(String mess, String error, int min, int max) {
        while (true) {
            String Regex = "[0-9]+";
            System.out.print(mess);
            String input = scanner.nextLine();
            //if input is empty, print out message
            if (input.isEmpty()) {
                System.out.println("Input Field Can Not Be Empty!");
            //if input not matches required regex, print out error message
            } else if (input.matches(Regex) == false) {
                System.out.println(error);
            } else {
                try {
                    int number = Integer.parseInt(input);
                    //if number is in valid range, return number
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.out.println("Number Is Not In Range ( From " + min + " To " + max + ")");
                    }
                } catch (NumberFormatException e) {
                    System.out.println(error);
                }
            }
        }

    }
    
    public static int getPrice(String mess, String error, int min) {
        while (true) {
            String Regex = "[0-9]+";
            System.out.print(mess);
            String input = scanner.nextLine();
            //if input is empty, print out message
            if (input.isEmpty()) {
                System.out.println("Input Field Can Not Be Empty!");
            //if input not matches required regex, print out error message
            } else if (input.matches(Regex) == false) {
                System.out.println(error);
            } else {
                try {
                    int number = Integer.parseInt(input);
                    //if number is in valid range, return number
                    if (number > min) {
                        return number;
                    } else {
                        System.out.println("Price must be greater than zero!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println(error);
                }
            }
        }

    }

   

    public static String getString(String mess, String error, String regex) {
        while (true) {
            System.out.print(mess);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input Field Can Not Be Empty!");
            } else if (input.matches(regex) == false) {
                System.out.println(error);
            } else {
                return input;
            }
        }

    }

    
}
