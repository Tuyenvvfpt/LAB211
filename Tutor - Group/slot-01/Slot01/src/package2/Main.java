package package2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {            
            System.out.print("Input: ");
            String input = scanner.nextLine();
            input = input.replaceAll("\\s+", " ");
            System.out.println(input);
        }

    }
}
