
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author admin
 */
public class Utility {

    public static String inputStr(int len, boolean isIncludeLetter, boolean isIncludeDigit, boolean isIncludeSpecialChar) {
        Scanner scanner = new Scanner(System.in);
        // isIncludeDigits là để kiểm tra xem có chữ số từ 0-9 không?
        // isIncludeAlphabet là để kiểm tra xem có chữ cáia-zA-Zkhông?
        // isIncludeSpecialChars là để kiểm tra xem có chứa kí tự đặc biệt không
        String result;
        while (true) {
            //..viết tiếpởđây
            result = inputStr(len);
            if (isIncludeDigit != isIncludeDigits(result)) {
                System.out.println("Must input digit !!!");
            } else if (isIncludeLetter != isIncludeAlphabet(result)) {
                System.out.println("Must input letter !!!");
            } else if (isIncludeSpecialChar != isIncludeSpecialChars(result)) {
                System.out.println("Must input special character !!");
            } else {
                break;
            }
        }

        return result;
    }

    public static String inputStr(int length) {
        String result;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter a string with length " + length + " char(s): ");
            result = scanner.nextLine();
            if (result.length() == length) {
                break;
            } else {
                System.out.println("Wrong input !! You just input a string with length " + result.length());
            }
        }
        return result;
    }

    public static boolean isIncludeDigits(String input) {
        String temp = input.replaceAll("\\d+", "");
        return temp.equals(input) ? true : false;

    }

    public static boolean isIncludeAlphabet(String input) {
        String temp = input.replaceAll("[a-zA-Z]+", "");
        return temp.equals(input) ? true : false;
    }

    public static boolean isIncludeSpecialChars(String input) {
        String temp = input.replaceAll("[^a-zA-Z0-9 ]+", "");
        return temp.equals(input) ? true : false;
    }

    public static int inputInt() {
        Scanner scanner = new Scanner(System.in);

        //Exception : dai dien cho moi loai loi ... 
        //tioen doan duoc cai loi la se xay ra loi nao
        while (true) {
            try {
                System.out.print("Input integer number: ");
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);
                return number;
            } catch (NumberFormatException e) {
                System.out.println("It must be integer number !!!");
            }
        }
    }

    public static double inputDouble() {
        Scanner scanner = new Scanner(System.in);

        //Exception : dai dien cho moi loai loi ... 
        //tioen doan duoc cai loi la se xay ra loi nao
        while (true) {
            try {
                System.out.print("Input double number: ");
                String input = scanner.nextLine();
                double number = Double.parseDouble(input);
                return number;
            } catch (NumberFormatException e) {
                System.out.println("It must be double number !!!");
            }
        }
    }

}
