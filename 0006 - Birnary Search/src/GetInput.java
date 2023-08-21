
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author asus
 */
public class GetInput {

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
                //display message, request user
                System.out.println(messageString);
                //allow user to input
                Scanner scanner = new Scanner(System.in);
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
