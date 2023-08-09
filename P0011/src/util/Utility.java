package util;

import java.util.Scanner;

public class Utility {

    static Scanner scanner = new Scanner(System.in);
       public static int getNumber(String messageString, String error, int min, int max) {
        while (true) {
            try {
                //hien thi ra thong bao, yeu cau nguoi dung
                System.out.println(messageString);
                //cho nguoi dung nhap vao
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);
                //kiem tra xem gia tri dau vao co trong doan min-max
                //if number in range => return number
                if (min <= number && number <= max) {
                    return number;
                    //else tell error
                } else {
                    System.out.println("number must in range " + min + " and " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println(error);
            }

        }
    }   public static int getSearch(String messageString, String error, int min, int max) {
        while (true) {
            try {
                //hien thi ra thong bao, yeu cau nguoi dung
                System.out.println(messageString);
                //cho nguoi dung nhap vao
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);
                //kiem tra xem gia tri dau vao co trong doan min-max
                //if number in range => return number
                if (min <= number && number <= max) {
                    return number;
                    //else tell error
                } else {
                    System.out.println("number must in range " + min + " and " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println(error);
            }

        }
    }

    /**
     *
     * @param messageString
     * @param error
     * @param min
     * @param max
     * @return
     */
    public static int getInteger(String messageString, String error, int min, int max) {
        while (true) {
            try {
                //hien thi ra thong bao, yeu cau nguoi dung
                System.out.println(messageString);
                //cho nguoi dung nhap vao
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);
                //kiem tra xem gia tri dau vao co trong doan min-max
                //if number in range => return number
                if (min <= number && number <= max) {
                    return number;
                    //else tell error
                } else {
                    System.out.println("number must in range " + min + " and " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println(error);
            }

        }
    }

    public static String getString(String messageString, String errorString, String regex) {
        while (true) {
            System.out.println(messageString);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input can not be empty");
            } else if (input.matches(regex)) {
                System.out.println("Hop le");
                return input;
            } else {
                System.out.println(errorString);
            }

        }
    }

    public static String getValue(int baseInput) {

        String input = null;
        switch (baseInput) {
            case 1:
//if base input = 1: nhap vao birnany
                input = getBinaryNumber();
                break;
            case 2:
//if base input = 2: nhap vao decimal
                input = getDecimalNumber();
                break;
            case 3:
//if base input = 3: nhap vao hexa
                input = getHexaNumber();
                break;
        }
        return input;
    }

    private static String getBinaryNumber() {
        String input = Utility.getString("Enter birnary (only contain 0 & 1): ", "Wrong ", "[01]+");
        return input;
    }

    private static String getDecimalNumber() {
        String input = Utility.getString("Enter deici (only contain 0-9): ", "Wrong ", "\\d+");
        return input;
    }

    private static String getHexaNumber() {
        String input = Utility.getString("Enter birnary (only contain 0-9 A-F): ", "Wrong ", "[0-9A-F]+");
        return input;
    }
}
