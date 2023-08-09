
public class Fibonacci {

    int array[];

    public Fibonacci() {
        array = new int[10];
    }

    public void writeNumbersFibonacci(int count) {
        //first two numbers of Fibonacci sequence 
        if (count == 0 || count == 1) {
            array[count] = count;
        } //the next numbers 
        else {
            array[count] = array[count - 1] + array[count - 2];
        }
        count++;
        //After the array is full, get out of the method 
        if (count == array.length) {
            return;
        }
        writeNumbersFibonacci(count);
    }

    public void displaySequence() {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println(array[array.length - 1]);

    }
}
