package util;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PHAM KHAC VINH
 */
public class Utility {
    static Scanner scanner = new Scanner(System.in);
    

    public static String getString(String message, String error) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            
            return input;
        }

    }
}
