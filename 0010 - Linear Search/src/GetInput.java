
import java.util.Scanner;

public class GetInput {

    static Scanner scanner = new Scanner(System.in);

    /**
     * get an integer from the input
     *
     * @param messageString
     * @param error
     * @param min
     * @param max
     * @return number input
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
                if (number == min) {
                    System.out.println("Enter again");
                } else if (min <= number && number <= max) {
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

    public static int getSearch(String messageString, String error, int min, int max) {
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

}
