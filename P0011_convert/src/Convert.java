/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author asus
 */
import java.util.Scanner;

/**
 *
 * @author dinhnam_ddn
 */
public class Convert {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] baseRegex = {"[0-1]+", "[0-9]+", "[0-9a-f]+"};

        System.out.println("Choose the base system:");
        System.out.println("1. Binary");
        System.out.println("2. Decimal");
        System.out.println("3. Hexadecimal");

        //choose base
        int inputBase = checkInput("Enter the base input: ", 1, 4);
        int outputBase = checkInput("Enter the base output: ", 1, 4);
        //enter number
        String inputNumber = checkBase("Enter input number: ", inputBase, baseRegex);

        if (inputBase == outputBase) {
            System.out.println("Output number: " + inputNumber);
            return;
        }
        String output = Manager.convertBase(inputBase, outputBase, inputNumber);
        System.out.println("Output number: " + output);
    }

    final static Scanner SC = new Scanner(System.in);

    /**
     * check input base and output base
     *
     * @param Mess
     * @param min
     * @param max
     * @return
     */
    public static int checkInput(String Mess, int min, int max) {

        while (true) {
            System.out.print(Mess);
            try {
                int result = Integer.parseInt(SC.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * check input number
     *
     * @param Mess
     * @param inputBase
     * @param Regex
     * @return string input number
     */
    public static String checkBase(String Mess, int inputBase, String[] Regex) {
        String st;
        do {
            System.out.print(Mess);
            st = SC.nextLine();
            st = st.toLowerCase().trim();
            if (st.matches(Regex[inputBase - 1])) {
                return st;
            }
            System.out.println("Wrong input number, try gain!");
        } while (true);
    }

}
