
/**
 *
 * @author asus
 */
public class Fibonacii {

    public static void main(String[] args) {
        System.out.println("The 45 sequence fibonacci:");
        for (int i = 0; i < 5; i++) {
            System.out.print(fibonacci(i) + " ");
        }
//        int numberLoop = 5;
//        System.out.println("The " + numberLoop + " sequence fibonacci:");
//        for (int i = 0; i < numberLoop; i++) {
//            if (i < (numberLoop - 1)) {
//                System.out.print(fibonacci(i) + ", ");
//            } else {
//                System.out.println(fibonacci(i));
//            }
//
//        }
    }

    public static int fibonacci(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}



