
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author asus
 */
public class LinearSearch {

    int array[];

    /**
     * Constructor
     *
     * @param numberOfArray Khi mac dinh, tien hanh khoi tao moi doi tuong
     * linear search - constructor tien hanh tao moi mang, tao moi doi tuong
     */
    public LinearSearch(int numberOfArray) {
        array = new int[numberOfArray];
    }

    /**
     * generate random integer in number range for each array element
     */
    void generateRandomInteger() {
        if (array.length == 0) {
            System.out.println("Array is empty");
        } else {
            Random random = new Random();
            //iterate from 0 -> length of array
            for (int i = 0; i < array.length; i++) {
                //generate random numbers
                int randomNumber = random.nextInt(array.length);
                //assign random numbers to array element
                array[i] = randomNumber;
            }
        }
    }

    /**
     * display the array
     */
    void displayArray() {
        if (array.length > 0) {
            System.out.print("The array: [");
            for (int i = 0; i < array.length - 1; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.println(array[array.length - 1] + "]");
        }
    }

    /**
     * display the index of search number in array
     *
     * @param searchNumber
     */
    void displayIndexOfSearchNumber(int searchNumber) {
        if (array.length > 0) {
            //perform linear search algorithm to find the index of the element want to search 
            int index = linearSearch(searchNumber);
            //display 
            //if index = -1 => not found
            if (index == -1) {
                System.out.println("NOT FOUND");
                //else find and display        
            } else {
                System.out.println("Found " + searchNumber + " at index: " + index);
            }
        }
    }

    private int linearSearch(int searchNumber) {
        // iterate through all the elements in the array
        for (int i = 0; i < array.length; i++) {
            //if element is equal to searchNumber => return index of that element
            if (array[i] == searchNumber) {
                return i;
            }
        }
        return -1;
    }

}
