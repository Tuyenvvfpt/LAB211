/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author PC
 */
public class Main {
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) throws Exception {
        ViewFruit view = new ViewFruit();
        while (true) {
            //display user menu
            view.displayMenu();
            //allow user to chose a function
            int choice = Utility.getInt("Enter your choice: ", "Invalid choice!", 1, 4);
            switch (choice) {
                case 1:
                    //create a new fruit
                    view.createFruit();
                    break;
                case 2:
                    //view orders
                    view.viewOrders();
                    break;
                case 3:
                    //shopping for buyer
                    view.shopping();
                    break;
                case 4:
                    //exit system
                    System.exit(0);
                    break;
            }
        }
    }
}
