
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class P0053 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = null;
        while (true) {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    array = inputElement();
                    break;
                case 2:
                    if (array == null) {
                        System.out.println("Array is empty. Enter element at STEP 1");
                        System.out.println("NOW ADD INPUT ELEMENT");
                        array = inputElement();
                    }

                    //check xem array da co gia tri chua
                    System.out.println(array.length);
                    System.out.println("--ASCENDING---");
                    sortAscending(array);
                    displayArray(array, choice);
                    break;

                case 3:
                    if (array == null) {
                        System.out.println("Array is empty. Enter element at STEP 1");
                        break;
                    }
                    System.out.println("--DESCENDING---");
                    sortAscending(array);
                    displayArray(array, choice);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Pls choose input choice from 1-4");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("=========Bubble Sort program========");
        System.out.println("1. Input element");
        System.out.println("2. Sort asc");
        System.out.println("3. Sort des");
        System.out.println("4. Exit");
        System.out.println("Pls choose one choice");
    }

    private static int[] inputElement() {

        System.out.println("----Input Element----");
        System.out.println("Input length of array:");
        int sizeOfArray = inputSizeOfArray();
        int array[] = new int[sizeOfArray];

        if (array.length == 0) {
            System.out.println("Aray is empty. Cannot add number");
        }
//        for (int i = 0; i < array.length; i++) {
//            System.out.println("Enter number " + (i + 1) + "th : ");
//            array[i] = inputIntNumber();
//        }

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(sizeOfArray + 1);
        }

        return array;
    }

    private static int inputSizeOfArray() {

        int number;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                number = Integer.parseInt(scanner.nextLine());

                if (number < 0) {
                    throw new NullPointerException();
                }
                return number;
            } catch (Exception e) {
                System.out.println("Unvalid. Input a positive decimal number");
                System.out.println("Input length of array again:");
            }
        }
    }

    /**
     * not use
     *
     * @return
     */
    private static int inputIntNumber() {

        int number;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                number = Integer.parseInt(scanner.nextLine());

                return number;
            } catch (NumberFormatException e) {
                System.out.println("Unvalid. Input a int  number");
                System.out.println("Enter number again:");
            }
        }
    }

    private static void sortAscending(int[] array) {

        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < (array.length - i - 1); j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void displayArray(int[] array, int choice) {
        String stringArray = null;
        if (choice == 2) {
            stringArray = "->";
        }
        if (choice == 3) {
            stringArray = "<-";
        }
        for (int i = 0; i < array.length; i++) {

            System.out.print("[" + array[i] + "]");

            if (i != array.length - 1) {
                System.out.print("" + stringArray);
            }
        }
        System.out.println("");
    }
}
