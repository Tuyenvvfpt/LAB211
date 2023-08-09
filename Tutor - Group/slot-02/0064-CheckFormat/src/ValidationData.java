
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
        Scanner scanner = new Scanner(System.in);
        //check phone format
        //checkPhoneFormat(scanner);

        //check email format
        checkEmailFormat(scanner);

        //check date format
        //checkDateFormat(scanner);
    }

    /**
     * check phone format
     *
     * @param scanner
     * @return true or false
     */
    private static boolean checkPhoneFormat(Scanner scanner) {
        System.out.println("====== Validate Progaram ======");
        while (true) {
            System.out.print("Phone number: ");
            String phone = scanner.nextLine().trim();
            //if input is empty => tell error
            if (phone.isEmpty()) {
                System.out.println("Phone cannot be empty !!");
            } // check phone must be number
            else if (phone.matches("[0-9]+") == false) {
                System.out.println("Phone number must is number");
            } //check phone must contain 10 digits
            else if (phone.matches("[0-9]{10}") == false) {
                System.out.println("Phone number must be 10 digits");
            } else {
                return false;
            }

        }

    }

    /**
     * check email format
     *
     * @param scanner
     * @return true or false
     */
    private static boolean checkEmailFormat(Scanner scanner) {
        while (true) {
            System.out.print("Email: ");
            String email = scanner.nextLine().trim();
            //if input is empty => tell error
            if (email.isEmpty()) {
                System.out.println("Email cannot be empty !!");
            } // check phone must be number
            else if (email.matches("\\w+[@](\\w+[.])+\\w+") == false) {
                System.out.println("Email must is correct format");
            } else {
                return false;
            }

        }
    }

    /**
     * check date format
     *
     * @param scanner
     * @return true or false
     */
    private static boolean checkDateFormat(Scanner scanner) {
        while (true) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                System.out.print("Date: ");
                String dateInput = scanner.nextLine();
                Date date = dateFormat.parse(dateInput);

                //check date exist
                //if date exist => return true;
                if (checkDateExist(dateInput, dateFormat)) {
                    return true;
                }
            } catch (ParseException ex) {
                System.out.println("Date to correct format(dd/mm/yyyy)");
            }
        }

    }
    
    /**
     * check date exist 
     * @param dateInput
     * @param dateFormat
     * @return true or false
     */
    private static boolean checkDateExist(String dateInput, SimpleDateFormat dateFormat) {
        dateFormat.setLenient(false);
        
        try {
            Date date = dateFormat.parse(dateInput);
            return true;
        } catch (ParseException ex) {
            System.out.println("Date does not exist!!!");
            return false;
        }
        
    }

}
