
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author asus
 */
public class Main {

    public static void main(String[] args) {
        //enter number of array
        int numberOfArray = GetInput.getInteger("Enter number of array: ",
                "Number of array must be integer", 0, Integer.MAX_VALUE);
        //enter a search number
        int searchNumber = GetInput.getSearch("Enter search number: ",
                "Search value must be integer", 0, Integer.MAX_VALUE);

        LinearSearch linearSearch = new LinearSearch(numberOfArray);

        //generate random integer in number range for each array element
        linearSearch.generateRandomInteger();
        //display the array
        linearSearch.displayArray();
        //display the index of search number in array
        linearSearch.displayIndexOfSearchNumber(searchNumber);
    }
}
