package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    static final String REGEX_DATE = "\\d{2}[-]\\d{2}[-]\\d{4}";
    static final String REGEX_STRING = "[a-zA-Z0-9 ]+";

    public static int getInt(String message, String firstError,
            String secondError, String thirdError, int min, int max) {
        //Exception : dai dien cho moi loai loi ... 
        //tioen doan duoc cai loi la se xay ra loi nao
        while (true) {
            try {
                System.out.print(message);
                int number = Integer.parseInt(scanner.nextLine());
                if (number < min) {
                    System.out.println(firstError);
                } else if (number > max) {
                    System.out.println(secondError);
                } else {
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
                double number = Double.parseDouble(scanner.nextLine());
                if (number < min) {
                    System.out.println(firstError);
                } else if (number > max) {
                    System.out.println(secondError);
                } else {
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
                float number = Float.parseFloat(scanner.nextLine());
                if (number < min) {
                    System.out.println(firstError);
                } else if (number > max) {
                    System.out.println(secondError);
                } else {
                    return number;
                }
            } catch (Exception e) {
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

    public static String getDate(String messageString, String firstError,
            String secondError, String thirdError) {

        while (true) {

            System.out.println(messageString);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            //input date
            String dateInput = scanner.nextLine();
            if (dateInput.matches(REGEX_DATE) == false) {
                System.out.println(firstError);
            } //check date exist
            else if (checkDateExist(dateInput, dateFormat) == false) {
                System.out.println(secondError);
            }//check date greater or equal to current date
            else if (checkDateGreaterThanCurrentDate(dateInput, dateFormat) == false) {
                System.out.println(thirdError);
            }else {
                return dateInput;
            }
        }
    }

    private static boolean checkDateExist(String dateInput, SimpleDateFormat dateFormat
    ) {
        dateFormat.setLenient(false);

        try {
            Date date = dateFormat.parse(dateInput);
            return true;
        } catch (ParseException ex) {
            return false;
        }

    }

    private static boolean checkDateGreaterThanCurrentDate(String dateInput, SimpleDateFormat dateFormat) {
        
        try {
            Date currentDate = new Date();
            String current =  dateFormat.format(currentDate);
            currentDate = dateFormat.parse(current);
            
            Date inputDate = dateFormat.parse(dateInput);
            
            if (inputDate.before(currentDate)) {
                return false;
            }else {
                return true;
            }
            
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        
    }
}
