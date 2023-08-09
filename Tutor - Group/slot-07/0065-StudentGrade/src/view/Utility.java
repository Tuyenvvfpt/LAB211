package view;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PHAM KHAC VINH
 */
public class Utility {
    static Scanner scanner = new Scanner(System.in);
    public static final String REGEX_STRING = "[a-zA-Z0-9 ]+";
    public static final String REGEX_YN = "[yYnN]";
    

    // / + shift ** + enter
    /**
     * get number double
     *
     * @param message
     * @param error
     * @param min
     * @param max
     * @return number double
     */
    public static double getDouble(String message, String firstError,String secondError, 
            String thirdError,double min, double max) {
        //loop unti get number double
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                double number = Double.parseDouble(input);
                //if number in range => return number
                //else => tell error
                 if (number > max) {
                     System.out.println(firstError);
                }else if (number <  min){
                     System.out.println(secondError);
                }else {
                    return number;
                }

            } catch (NumberFormatException e) {
                System.out.println(thirdError);
            }
        }
    }
    
    

    public static String getString(String message, String error, String regex) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
           
             if (input.matches(regex)) {
                return input;
            } else {
                System.out.println(error);
            }
        }

    }
}
