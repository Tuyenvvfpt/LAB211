package pkg0074;

import java.util.Scanner;

/**
 *
 * @author asus
 */
public class Main {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main m = new Main();
        while (true) {
            displayMenu();
            int choice = inputChoice();
            switch (choice) {
                case 1:
                    m.choiceAdditionMatrix();
                    break;
                case 2:
                    m.choiceSubtractionMatrix();
                    break;
                case 3:
                    m.choiceMultiplicationMatrix();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Please input choice range 1 -> 4");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("==== Calculation Program ====");
        System.out.println("1. addition matrix");
        System.out.println("2. subtraction matrix");
        System.out.println("3. multiplication matrix");
        System.out.println("4. exit");
        System.out.println("Enter choice : ");
    }

    private static int inputChoice() {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(inputString());
                if (choice <= 4 || choice >= 1) {
                    return choice;
                } else {
                    System.out.println("Please input choice range 1 -> 4");
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Pls input choice range 1 -> 4");
                System.out.println("Pls choice one option: ");
            }
        }
    }

    private static String inputString() {
        while (true) {
            try {

                String value = scanner.nextLine().trim();
                if (value.isEmpty()) {
                    System.out.println("Not Empty");
                    System.out.println("Enter again:");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Pls enter only number");
            }
        }
    }

    public int inputPositiveNumber() {
        int number;
        while (true) {
            try {
                number = Integer.parseInt(inputString());
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Enter positive number");
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter positive number");
            }
        }
    }

    private boolean checkRowColMatrix(int value1, int value2) {
        return value1 == value2;
    }

    /**
     * input matrix tu 1 toi = row + 1
     *
     * @param str
     * @param row
     * @param col
     * @return
     */
    private int[][] inputMatrix(String str, int row, int col) {
        //Mục đích của việc thêm 1 đơn vị vào số hàng và số cột là để có thể sử dụng
        //chỉ số từ 1 thay vì chỉ số mảng 0-based khi nhập giá trị từ người dùng.
        //vd: matrix[2,2] => mang [2,2] gom 0,1 => de i va j co the hien thi 1 va 2 
        int matrix[][] = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                //nhan gia tri va hien thi
                System.out.println("Enter " + str + "[" + i + "]" + "[" + j + "]:");
                matrix[i][j] = inputValueMatrix();
            }
        }
        return matrix;
    }

    public int inputValueMatrix() {
        int number;
        while (true) {
            try {

                number = Integer.parseInt(inputString());
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Value matrix must be digit");
                }
            } catch (NumberFormatException e) {
                System.out.println("Pls enter only number");
            }
        }
    }

    /**
     * display matrix 1 toi row
     *
     * @param matrix
     */
    private void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[1].length;
        //vd: matrix[2,2] => row/col = 2 => i = 1 j = 1&2 i = 2 j = 1&2
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }

    private void choiceAdditionMatrix() {
        System.out.println("--Addtion--");
        System.out.println("Enter row matrix 1: ");
        int row1 = inputPositiveNumber();
        System.out.println("Enter col matrix 1: ");
        int col1 = inputPositiveNumber();
        int matrix1[][] = inputMatrix("Matrix1", row1, col1);

        System.out.println("");
        System.out.println("Enter row matrix 2: ");
        int row2 = inputPositiveNumber();
        System.out.println("Enter col matrix 2: ");
        int col2 = inputPositiveNumber();
        int matrix2[][] = inputMatrix("Matrix2", row2, col2);

        System.out.println("----Result----");

        //neu cong, check 2 matrix co cung kich thuoc
        if (checkRowColMatrix(row1, row2)
                && checkRowColMatrix(col1, col2)) {
            displayMatrix(matrix1);
            System.out.println(" + ");
            displayMatrix(matrix2);
            System.out.println(" = ");

            int matrix[][] = additionMatrix(matrix1, matrix2);
            displayMatrix(matrix);
        } else {
            System.out.println("matrix 1 dont add matrix 2");
        }
    }

    private int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[1].length;

        int matrix[][] = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                matrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return matrix;
    }

    private void choiceSubtractionMatrix() {
        System.out.println("--Subtraction--");
        System.out.println("enter row matrix 1: ");
        int row1 = inputPositiveNumber();
        System.out.println("Enter col matrix 1: ");
        int col1 = inputPositiveNumber();

        int matrix1[][] = inputMatrix("Matrix1", row1, col1);

        System.out.println("");
        System.out.println("enter row matrix 2: ");
        int row2 = inputPositiveNumber();
        System.out.println("Enter col matrix 2: ");
        int col2 = inputPositiveNumber();

        int matrix2[][] = inputMatrix("Matrix2", row2, col2);

        System.out.println("----Result----");

        //neu tru, check 2 matrix co cung kich thuoc
        if (checkRowColMatrix(row1, row2)
                && checkRowColMatrix(col1, col2)) {
            displayMatrix(matrix1);
            System.out.println(" - ");
            displayMatrix(matrix2);
            System.out.println(" = ");

            int matrix[][] = subtractionMatrix(matrix1, matrix2);
            displayMatrix(matrix);
        } else {
            System.out.println("matrix 1 dont sub matrix 2");
        }
    }

    private int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[1].length;
//        int row2 = matrix2.length;
//        int col2 = matrix2[1].length;

        int matrix[][] = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                matrix[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return matrix;
    }

    private void choiceMultiplicationMatrix() {
        System.out.println("--Multiplication--");
        System.out.println("enter row matrix 1: ");
        int row1 = inputPositiveNumber();
        System.out.println("Enter col matrix 1: ");
        int col1 = inputPositiveNumber();

        int matrix1[][] = inputMatrix("Matrix1", row1, col1);

        System.out.println("");
        System.out.println("enter row matrix 2: ");
        int row2 = inputPositiveNumber();
        System.out.println("Enter col matrix 2: ");
        int col2 = inputPositiveNumber();

        int matrix2[][] = inputMatrix("Matrix2", row2, col2);

        System.out.println("----Result----");

        //neu nham, check matrix1' col == matrix2' row
        if (checkRowColMatrix(col1, row2)) {

            displayMatrix(matrix1);
            System.out.println(" * ");
            displayMatrix(matrix2);
            System.out.println(" = ");

            int matrix[][] = multiplicationMatrix(matrix1, matrix2);
            displayMatrix(matrix);
        } else {
            System.out.println("matrix 1 dont mul matrix 2");
        }
    }

    private int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[1].length;
        int col2 = matrix2[1].length;

        //tao ra matrix moi voi hang matrix1 cot matrix2
        int matrix[][] = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                matrix[i][j] = 0;
                for (int k = 0; k < col1; k++) {
                    matrix[i][j] += (matrix1[i][k] * matrix2[k][j]);
                }
            }
        }
        return matrix;
    }
}
