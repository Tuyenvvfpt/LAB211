package util;

import java.util.Scanner;

public class Utility {

    public static void main(String[] args) {
        String userOption = Utility.getString("Please give me your choice (eg: 1 10): ",
                "Must be in format (X X) (X is digit and have space between them)",
                "\\d+[ ]\\d*");
        System.out.println(userOption);

    }

    static Scanner scanner = new Scanner(System.in);

    /**
     * lấy về một số nguyên từ đầu vào
     *
     * @param message
     * @param error
     * @param min
     * @param max
     * @return number input
     */
    public static int getInteger(String message, String error, int min, int max) {
        while (true) {
            try {
                //hiển thị thông báo, yêu cầu người dùng
                System.out.print(message);
                //cho người dùng nhập vào
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);
                //kiểm tra xem giá trị đầu vào có trong đoạn min - max
                //if number in range => return number
                if (number >= min && number <= max) {
                    return number;
                    //else tell error
                } else {
                    System.out.println("Number must in range " + min + " - " + max);
                }

            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
    }

    /**
     * lấy về một số nguyên từ đầu vào
     *
     * @param message
     * @param error
     * @param min
     * @param max
     * @return number input
     */
    public static float getFloat(String message, String error, int min, int max) {
        while (true) {
            try {
                //hiển thị thông báo, yêu cầu người dùng
                System.out.print(message);
                //cho người dùng nhập vào
                String input = scanner.nextLine();
                float number = Float.parseFloat(input);
                //kiểm tra xem giá trị đầu vào có trong đoạn min - max
                //if number in range => return number
                if (number >= min && number <= max) {
                    return number;
                    //else tell error
                } else {
                    System.out.println("Number must in range " + min + " - " + max);
                }

            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
    }

    public static String getString(String message, String error, String regex) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.print("Input cannot be empty");
            } else if (input.matches(regex)) {
                return input;
            } else {
                System.out.println(error);
            }
        }

    }

    public static String getValue(int baseInput) {
        String input = null;

        switch (baseInput) {
            case 1:
                //neu baseInput = 1 : nhap vao binary
                input = getBinaryNumber();
                break;
            case 2:
                //neu base input = 2 : nhap vao decimal
                input = getDecimalNumber();
                break;
            case 3:
                //neu base input = 3 : nhap vao hexadecimal
                input = getHexaDecimalNumber();
                break;
        }
        return input;
    }

    private static String getBinaryNumber() {
        String input = getString("Enter binary number (only contain 0, 1): ", "Wrong", "[-01.]+");
        return input;
    }

    private static String getDecimalNumber() {
        String input = getString("Enter decimal number (only contain 0 - 9): ", "Wrong", "[\\d.]+");
        return input;
    }

    private static String getHexaDecimalNumber() {
        String input = getString("Enter hexadecimal number (only contain 0-9 A-F): ",
                "Wrong", "[0-9A-F.]+");
        return input;
    }
}
