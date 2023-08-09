/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.Order;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        List<Fruit> listFruit = new ArrayList<>();
        List<Order> listOrder = new ArrayList<Order>();
        ViewFruit view = new ViewFruit();
        while (true) {
            displayMenu();
            int option = Ultility.getInt("Enter your option: ", 1, 4);
            switch (option) {
                case 1:
                    //input fruit
                    view.inputFruit(listFruit);
                    break;
                case 2:
                    //View orders
                    view.viewOrder(listOrder);
                    break;
                case 3:
                    //shopping for buyer
                    view.shopping(listFruit,listOrder);
                    break;
                case 4:
                    //
                    
                    System.exit(0);
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("==========================");
        System.out.println("FRUIT SHOP SYSTEM\n"
                + "1. Create Fruit\n"
                + "2. View orders\n"
                + "3. Shopping (for buyer)\n"
                + "4. Exit");
        System.out.println("==========================");
    }
}
