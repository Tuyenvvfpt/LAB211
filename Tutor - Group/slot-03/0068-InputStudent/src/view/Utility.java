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
    public static final String REGEX_NAME = "[a-zA-Z ]+";
    public static final String REGEX_CLASSES = "[a-zA-Z0-9 ]+";
    public static final String REGEX_YN = "[yYnN]";
    
    public static int getInt(String message, String error, int min, int max) {
        //Exception : dai dien cho moi loai loi ... 
        //tioen doan duoc cai loi la se xay ra loi nao
        while (true) {
            try {
                System.out.print(message);
                int number1 = scanner.nextInt();
                if (number1 >= min && number1 <= max) {
                    return number1;
                } else {
                    System.out.println("Input must in range from [" + min + "-" + max + "]");
                }

            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

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
    public static double getDouble(String message, String error, double min, double max) {
        //loop unti get number double
        while (true) {
            try {
                System.out.print(message);
                double number1 = scanner.nextDouble();
                //if number in range => return number
                //else => tell error
                if (number1 >= min && number1 <= max) {
                    return number1;
                } else {
                    System.out.println("Input must in range from [" + min + "-" + max + "]");
                }

            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }
    
     public static float getFloat(String message, String error, float min, float max) {
        //loop unti get number double
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                float number = Float.parseFloat(input);
                //if number in range => return number
                //else => tell error
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println("Mark must be greater or equal to 0");
                }

            } catch (NumberFormatException e) {
                System.out.println(error);
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
