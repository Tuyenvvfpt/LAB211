
import java.util.Arrays;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author asus
 */
public class BirnarySearch {

    int array[];

    /**
     * Constructor
     *
     * @param numberOfArray Khi mac dinh, tien hanh khoi tao moi doi tuong
     * linear search - constructor tien hanh tao moi mang, tao moi doi tuong
     */
    public BirnarySearch(int numberOfArray) {
        array = new int[numberOfArray];
    }

    /**
     * generate random integer in number range for each array element
     */
    void generateRandomInteger() {
        if (array.length == 0) {
            System.out.println("Array is empty.");
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
            for (int i = 0; i < array.length - 1; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.println(array[array.length - 1] + "]");
        }
    }

    void displayIndexOfSearchNumber(int searchNumber) {
        if (array.length > 0) {
            //perform binary search algorithm to find the index of the element want to search 
            int index = findByBinarySearch(searchNumber);
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

    private int findByBinarySearch(int searchNumber) {
        int left = 0;
        int right = array.length - 1;
        boolean isIncreasing = array[left] < array[right];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == searchNumber) {
                //if searchNumber is found at position mid, return mid
                return mid;
                //            } else if (array[mid] < searchNumber) {
            } else if ((isIncreasing && array[mid] < searchNumber) || (!isIncreasing && array[mid] > searchNumber)) {
                //if the value at mid position is less than searchNumber, we continue to search to the right of mid
                left = mid + 1;
            } else {
                //if the value at mid position is greater than searchNumber, we continue to search to the left of mid
                right = mid - 1;
            }
        }
        //if searchNumber is not found in the array, return -1
        return -1;
    }

    void sortArray() {
        int n = array.length;
        // Vòng lặp ngoài cùng để duyệt qua toàn bộ mảng
        for (int j = 0; j < n; j++) {

            // Vòng lặp trong cùng để duyệt từ đầu mảng đến phần tử cuối cùng trừ đi số lần đã sắp xếp (j)
            for (int i = 0; i < n - j - 1; i++) {
                // Nếu phần tử hiện tại lớn hơn phần tử kế tiếp, thì hoán đổi chỗ 2 phần tử này
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }
}
