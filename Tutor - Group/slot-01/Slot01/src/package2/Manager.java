package package2;

import java.util.Scanner;

public class Manager {

    private static final Scanner in = new Scanner(System.in);

    //display menu
    public int mennu() {
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = checkInputInt();
        return choice;
    }

    //check user input number limit
    public int checkInputInt() {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < 1 || result > 3) {
                    System.err.println("Out of range, pls re-enter ");

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Input must be digit");
                System.out.print("Enter again: ");
            }
        }
    }

    //allow user input number double
    public double checkInputDouble() {
        //loop until user input correct
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Input must be digit");
                System.out.print("Enter again: ");
            }
        }
    }

    //allow user input operator
    public String checkInputOperator() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
            } else if (result.equalsIgnoreCase("+") || result.equalsIgnoreCase("-")
                    || result.equalsIgnoreCase("*") || result.equalsIgnoreCase("/")
                    || result.equalsIgnoreCase("^") || result.equalsIgnoreCase("=")) {
                return result;
            } else {
                System.err.println("Please input (+, -, *, /, ^)");
            }
            System.out.print("Enter again: ");
        }
    }

    //allow user input number
    public double inputNumber() {
        System.out.print("Enter number: ");
        double number = checkInputDouble();
        return number;
    }

    //allow user calculator normal
    public void normalCalculator() {
        double memory;
        System.out.print("Enter number: ");
        memory = checkInputDouble();

        while (true) {
            try {

                System.out.print("Enter operator: ");
                String operator = checkInputOperator();
                if (operator.equalsIgnoreCase("+")) {
                    memory += inputNumber();
                    System.out.println("Memory: " + memory);
                }
                if (operator.equalsIgnoreCase("-")) {
                    memory -= inputNumber();
                    System.out.println("Memory: " + memory);
                }
                if (operator.equalsIgnoreCase("*")) {
                    memory *= inputNumber();
                    System.out.println("Memory: " + memory);
                }
                if (operator.equalsIgnoreCase("/")) {
                    double number = inputNumber();
                    if (number == 0) {
                        throw new ArithmeticException("Cannot divide to 0");
                    }
                    memory /= number;
                    System.out.println("Memory: " + memory);
                }
                if (operator.equalsIgnoreCase("^")) {
                    memory = Math.pow(memory, inputNumber());
                    System.out.println("Memory: " + memory);
                }
                if (operator.equalsIgnoreCase("=")) {
                    System.out.println("Result: " + memory);
                    return;
                }
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    //display result BMI status
    public String BMIStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard.";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }

    //allow user BMI calculator
    public void BMICalculator() {
        try {
            System.out.print("Enter Weight(kg): ");
            double weight = checkInputDouble();
            System.out.print("Enter Height(cm): ");
            double height = checkInputDouble();
            if (height == 0) {
                throw new ArithmeticException("Cannot divide to zero !!!");
            }
            double bmi = (weight / (int) (height * height)) * 10000;
            System.out.printf("BMI number: %.2f\n", bmi);
            System.out.println("BMI Status: " + BMIStatus(bmi));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
