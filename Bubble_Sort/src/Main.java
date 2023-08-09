
/**
 *
 * @author asus
 */
public class Main {

    public static void main(String[] args) {
        //enter number of array
        int numberOfArray = GetInput.getInteger("Enter number of array: ",
                "Number of array must be integer", 1, Integer.MAX_VALUE);
//        //enter a search number
//        int searchNumber = GetInput.getInteger("Enter search number: ",
//                "Search value must be integer", 0, Integer.MAX_VALUE);

        Sort sort = new Sort(numberOfArray);

        //generate random integer in number range for each array element
        sort.generateRandomInteger();
        System.out.println("Unsorted array: ");
        sort.displayArray();

//        sort.bubbleSort();
//        sort.selectionSort();
        sort.insertionSort();

        //display the array
        System.out.println("Sorted array: ");
        sort.displayArray();

    }
}
