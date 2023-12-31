
import java.util.Scanner;

public class Utility {

    public static String REGEX_USERNAME = "\\d{10}";
    public static String REGEX_PASSWORD = "(?=.*\\d)(?=.*[a-zA-Z])\\S{8,31}";
    public static String REGEX_CAPCHA = "[a-zA-Z0-9]+";

    static Scanner scanner = new Scanner(System.in);

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
}
