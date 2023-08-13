
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
public class ValidationData {

    public static void main(String[] args) {

        inputPhone();

        inputEmail();

        inputDate();
    }

    private static void inputPhone() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("====== Validate Progaram ======");
        while (true) {
            System.out.print("Phone number: ");
            String phone = scanner.nextLine().trim();
            String result = checkPhoneFormat(phone);
            if (result.isEmpty()) {
                break;
            } else {
                System.out.println(result);
            }

        }
    }

    /**
     * check phone format
     *
     * @param scanner
     * @return true or false
     */
    public static String checkPhoneFormat(String phone) {
        String errorMessage;
        while (true) {
            if (phone.isEmpty()) {
                errorMessage = "Phone cannot be empty!";
            } else if (phone.matches("[a-zA-Z]+")) {
                errorMessage = "Phone number must is number";
            } else if (!phone.matches("[0-9]{10}")) {
                errorMessage = "Phone number must be 10 digits";
            } else {
                errorMessage = "";
            }
            return errorMessage;
        }
    }

    /**
     * check email format
     *
     * @param scanner
     * @return true or false
     */
    private static void inputEmail() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Email: ");
            String email = scanner.nextLine().trim();

            String result = checkEmailFormat(email);

            if (result.isEmpty()) {
                break;
            } else {
                System.out.println(result);
            }
        }
    }

    public static String checkEmailFormat(String email) {
        String errorMessage;
        while (true) {
            if (email.isEmpty()) {
                errorMessage = "Email cannot be empty !!";
            } else if (!email.matches("[a-zA-Z0-9]+[@][a-zA-Z]+[.][a-zA-Z]+")) {
                errorMessage = "Email must is correct format";
            } else {
                errorMessage = "";
            }
            return errorMessage;
        }
    }

    /**
     * check date format
     *
     * @param scanner
     * @return true or false
     */
    private static void inputDate() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Date: ");
            String date = scanner.nextLine().trim();

            //C1
            String result = checkDateFormat(date);
//            String result = checkDateFormatExist(date);

            if (result.isEmpty()) {
                break;
            } else {
                System.out.println(result);
            }
        }
    }

    public static String checkDateFormat(String date) {

        String errorMessage;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            if (date.isEmpty()) {
                errorMessage = "Date cannot be empty";
            } else {
                try {
                    Date dateInput = simpleDateFormat.parse(date);
                    if (date.isEmpty()) {
                        errorMessage = "Date cannot be empty";
                    } else if (checkDateExist(date, simpleDateFormat)) {
                        errorMessage = "Date does not exist!!!";
                    } else if (isDateFuture(dateInput)) {
                        errorMessage = "Date cannot be in the future!";
                    } else {
                        errorMessage = "";
                    }
                } catch (ParseException e) {
                    errorMessage = "Date to correct format(dd/mm/yyyy)";
                }
            }
            return errorMessage;
        }
    }

    private static boolean checkDateExist(String date, SimpleDateFormat simpleDateFormat) {
        simpleDateFormat.setLenient(false);
        try {
            Date dateExist = simpleDateFormat.parse(date);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    private static boolean isDateFuture(Date dateInput) {
        Date currentDate = new Date();
        return dateInput.after(currentDate);
    }

//    public static String checkDateFormatExist(String date) {
//
//        String errorMessage;
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        simpleDateFormat.setLenient(false);
//        while (true) {
//            try {
//                Date dateInput = simpleDateFormat.parse(date);
//                if (isDateFuture(dateInput)) {
//                    errorMessage = "Date cannot be in the future!";
//                } else {
//                    errorMessage = "";
//                }
//            } catch (ParseException e) {
//                errorMessage = "Date to correct format(dd/mm/yyyy)";
//            }
//
//            return errorMessage;
//        }
//    }
}
