/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p0008;

import java.util.Scanner;

/**
 *
 * @author asus
 */
class Utility {

    static String inputString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your content: ");
        String result;
        while (true) {
            result = scanner.nextLine();
            result = result.toLowerCase();
            if (result.length() == 0) {
                System.out.println("Not null");
                
                //check for case: 
            } else if (!result.matches(".*[a-zA-Z0-9].*")) {
                System.out.println("Contains at least 1 character");
            } else {
                return result;
            }
        }
    }
}
