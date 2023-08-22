/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author ADMIN
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    static final String REGEX_DATE = "\\d{2}[-]\\d{2}[-]\\d{4}";
    public static final String REGEX_STRING = "[a-zA-Z0-9 ]+";

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
            String secondError) {

        while (true) {

            System.out.print(messageString);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            //input date
            String dateInput = scanner.nextLine();
            if (dateInput.matches(REGEX_DATE) == false) {
                System.out.println(firstError);
            } //check date exist
            else if (checkDateExist(dateInput, dateFormat) == false) {
                System.out.println(secondError);
            } else {
                return dateInput;
            }
        }
    }

    private static boolean checkDateExist(String dateInput,
            SimpleDateFormat dateFormat) {
        dateFormat.setLenient(false);

        try {
            Date date = dateFormat.parse(dateInput);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    //input data
    public static String getRequirementName() {
        String requirement = Utility.getString("Requirement Name: ",
                "Requirement Name must be letters or digits",
                Utility.REGEX_STRING);
        return requirement;
    }

    public static int getTaskType() {
        int result = Utility.getInt("Enter task type: ",
                "It must be from 1-4",
                "It must be from 1-4",
                "It must be digits", 1, 4);
        return result;
    }

    public static String getDate() {
        String date = Utility.getDate("Enter date: ",
                "date must be format dd-MM-yyyy",
                "Date does not exist");
        return date;
    }

    public static double getFrom() {
        double from = Utility.getDouble("Enter from: ", "Wrong",
                "Wrong", "Wrong",
                8, 17);  //de bai co
        return from;
    }

    public static double getTo(double from) {
        double to = Utility.getDouble("Enter to: ",
                "Wrong", "Wrong", "Wrong",
                from + 0.5, 17.5);
        return to;
    }

    public static String getAssignee() {
        String assignee = Utility.getString("Enter assignee: ",
                "Wrong",
                Utility.REGEX_STRING);
        return assignee;
    }

    public static String getReviewer() {
        String reviewer = Utility.getString("Enter reviewer: ",
                "Wrong",
                Utility.REGEX_STRING);
        return reviewer;
    }

}
