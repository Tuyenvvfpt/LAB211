
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
        int searchNumber = GetInput.getInteger("Enter search number: ",
                "Search value must be integer", 0, Integer.MAX_VALUE);

        BirnarySearch birnarySearch = new BirnarySearch(numberOfArray);

        //generate random integer in number range for each array element
        birnarySearch.generateRandomInteger();
        System.out.print("       Array: [");
        birnarySearch.displayArray();

        //sort array
        birnarySearch.sortArray();
        //display the array
        System.out.print("Sorted array: [");
        birnarySearch.displayArray();
        //display the index of search number in array
        birnarySearch.displayIndexOfSearchNumber(searchNumber);
    }
}
