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
    public static final String REGEX_UD = "[uUdD]";
    
    public static int getInt(String message, String firstError,
            String secondError, String thirdError, int min, int max) {
        //Exception : dai dien cho moi loai loi ... 
        //tioen doan duoc cai loi la se xay ra loi nao
        while (true) {
            try {
                System.out.print(message);
                int number = Integer.parseInt(scanner.nextLine()) ;
                if (number < min ) {
                    System.out.println(firstError);
                }else if (number > max) {
                    System.out.println(secondError);
                }else {
                    return number;
                }
            } catch (Exception e) {
                System.out.println(thirdError);
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
    public static double getDouble(String message, String firstError,
            String secondError, String thirdError, double min, double max) {
        //loop unti get number double
        while (true) {
            try {
                System.out.print(message);
                double number = Double.parseDouble(scanner.nextLine()) ;
                if (number < min ) {
                    System.out.println(firstError);
                }else if (number > max) {
                    System.out.println(secondError);
                }else {
                    return number;
                }
            } catch (Exception e) {
                System.out.println(thirdError);
            }
        }
    }
    
    public static float getFloat(String message, String firstError,
            String secondError, String thirdError, float min, float max) {
        //loop unti get number double
        while (true) {
            try {
                System.out.print(message);
                float number = Float.parseFloat(scanner.nextLine()) ;
                if (number < min ) {
                    System.out.println(firstError);
                }else if (number > max) {
                    System.out.println(secondError);
                }else {
                    return number;
                }
            } catch (Exception e) {
                System.out.println(thirdError);
            }
        }
    }

    public static String getString(String message,String regex,  String error ) {
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
