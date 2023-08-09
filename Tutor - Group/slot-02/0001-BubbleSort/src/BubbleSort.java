
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author PHAM KHAC VINH
 */
public class BubbleSort {

    public static void main(String[] args) {
        //1. input a positive decimal number
        int sizeArray = getInt("Enter number of array: ", "Size of array must be"
                + "postive decimal number", 1, Integer.MAX_VALUE);

        //2. Create array by generate random integer in range
        int[] array = createArray(sizeArray);

        //3. Display array before sort
        displayArray("Unsorted Array: ", array);

        //4. Sorting
        bubbleSort(array);

        //5. Display array after sort
        displayArray("Unsorted Array: ", array);

    }

    public static int getInt(String message, String error, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(message);
                int number1 = scanner.nextInt();
                if (number1 >= min && number1 <= max) {
                    return number1;
                } else {
                    System.out.println("Input must in range from [" + min + "-" + max + "]");
                }

            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    private static int[] createArray(int sizeArray) {
        int[] array = new int[sizeArray];

        Random random = new Random();
        //loop from first to last element of array to assign random value 
        for (int i = 0; i < sizeArray; i++) {
            array[i] = random.nextInt(sizeArray);
        }

        return array;
    }

    private static void displayArray(String message, int[] array) {
        System.out.println(message + Arrays.toString(array));
    }

    private static void bubbleSort(int[] array) {
        /*Loop use to accessed from the first to last element of array, 
        after each loop, one element is sorted*/
        for (int i = 0; i < array.length; i++) {
            /*Loop use to accessed first unsorted element to the element 
            stand before the last sorted element*/
            for (int j = 0; j < array.length - i - 1; j++) {
                //compare each pair adjacent elements
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

}
