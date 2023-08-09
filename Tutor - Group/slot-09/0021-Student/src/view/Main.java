/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author PHAM KHAC VINH
 */
public class Main {

    public static void main(String[] args) {
        View_Student view = new View_Student();
        while (true) {
            displayMenu();

            int option = Utility.getInt("Option: ", "Wrong", "Wrong", "Wrong", 1, 6);
            switch (option) {
                case 1:
                    //create 
                    view.inputStudent();
                    break;
                case 2:
                    //find and sort
                    view.findAndSort();
                    break;
                case 3:
                    //update or delte
                    view.updateOrDelete();
                    break;
                case 4:
                    //report
                    view.report();
                    break;
                case 6: 
                     view.hienthi();
                     break;
                case 5:
                    System.exit(0);
                    break;

            }

        }

    }

    private static void displayMenu() {
        System.out.println("Menu");
        System.out.println("1. Create");
        System.out.println("2. Find and sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.println("==============================");
    }
}
