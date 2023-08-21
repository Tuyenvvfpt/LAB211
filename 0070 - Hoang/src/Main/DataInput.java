/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Lanh
 */
import java.util.Scanner;

/**
 *
 * @author dinhh
 */
public class DataInput {
    Scanner scanner = new Scanner(System.in);
     public int checkInt(String mess, int min, int max) {
        int result;
        while (true) {
            System.out.print(mess);
            try {
                result = Integer.parseInt(scanner.nextLine().trim());
                if (result >= min && result <= max) {
                    break; 
                }else {
                    System.err.println("Out of range! Please input in range "
                            + "[" + min + ", " + max + "]: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter a number!");
            }
        }
        return result;
    }
}