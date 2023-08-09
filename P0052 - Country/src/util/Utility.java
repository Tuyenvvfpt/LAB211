package util;

import java.util.Scanner;

public class Utility {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        /*
          //yeu cau nguoi dung nhap tuoi con meo
        int catAge = getInteger("Hay nhap vao so tuoi cua con meo",
                "tuoi cua con meo phai la so nguyen", 0, 10);
        System.out.println(catAge);

        //yeu cau nguoi ding nhap vao so luong phan tu cua mang
        int sizeArray = getInteger("Hay nhap vao so luong phan tu cua mang",
                "so luong phan tu cua mang phai la so nguyen", 0, 10);
        System.out.println(sizeArray);
         */
        String name = getString("Enter name: ", "Name must be string",
                "[a-zA-Z]+");
        System.out.println(name);
    }

    /*    //scanner

        //tao ra doi tuong scanner de su dung: new
        Scanner scanner = new Scanner(System.in);

        //doc du lieu dau vao la 1 so nguyen, so thuc, chuoi/ xau (String)
        try {
            //nhap vao 1 so nguyen
            System.out.println("Nhap vao mot so nguyen: ");
            int number = scanner.nextInt();
            System.out.println(number);
        } catch (Exception e) {
            System.out.println("Ban dang bi loi: " + e);
        }
        System.out.println("Khong he co loi");
        //debug: tim ra loi
        //dat breakpoint
         
     */
    /**
     *
     * @param message
     * @param error
     * @param min
     * @param max
     * @return
     */
    public static int getInteger(String message, String error, int min, int max) {
        while (true) {
            try {
                //hien thi ra thong bao, yeu cau nguoi dung
                System.out.println(message);
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
                return input;
            } else {
                System.out.println(errorString);
            }

        }
    }

    public static float getFloat(String message, String error, float min, float max) {
        while (true) {
            try {
                //hien thi ra thong bao, yeu cau nguoi dung
                System.out.println(message);
                //cho nguoi dung nhap vao
                String input = scanner.nextLine();
                float number = Float.parseFloat(input);
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
}
