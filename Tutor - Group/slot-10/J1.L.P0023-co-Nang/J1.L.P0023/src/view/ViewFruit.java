/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.FruitController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Fruit;
import model.Order;

/**
 *
 * @author PC
 */
public class ViewFruit {

    FruitController control = new FruitController();

    //display user menu
    void displayMenu() {
        System.out.println("========= Fruit Shop =========\n"
                + "1.	Create Fruit\n"
                + "2.	View orders\n"
                + "3.	Shopping (for buyer)\n"
                + "4.	Exit");
    }

    //create a new fruit
    void createFruit() throws Exception {
        //continue to add fruit until user chose to stop
        while (true) {
            String id;
            //enter fruit id until it's not duplicated

            id = getId();
            //check if fruit id exist or not
            if (control.checkDuplicated(id)) {
                //System.out.println("You've entered exist fruit - " + control.getFruitByID(id, control.getListFruit()).getName() + "!");
                //control.getFruitByID(id, control.getListFruit()).setQuantity(control.getFruitByID(id, control.getListFruit()).getQuantity() + getQuantity());
                System.out.println("You've entered exist fruit - "
                        + control.getFruitByID(id).getName() + "!");
               control.getFruitByID(id).setQuantity(control.getFruitByID(id).getQuantity() + getQuantity());

                if (!checkYesNo("continue")) {
                    displayListFruit(control.getListFruit());
                    break;
                }

            } else {

                String name = getName();
                double price = getPrice();
                int quantity = getQuantity();
                String origin = getOrigin();

                //add a new fruit to the list
                Fruit fruit = new Fruit(id, name, origin, quantity, price);
                control.addFruit(fruit);
                System.out.println("Succesfully Added!");

                //ask user whether if they want to add more fruit or not
                if (!checkYesNo("continue")) {
                    displayListFruit(control.getListFruit());
                    break;
                }
            }
        }
    }

    /**
     * view all orders
     */
    void viewOrders() {
        //if no one order yet, display empty message
        if (control.getListOrder().isEmpty()) {
            System.out.println("No Order Have Been Created!");
        }
        ArrayList<Order> listOrder = control.getListOrder();
        Collections.sort(listOrder, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return Double.compare(o1.getTotal(), o2.getTotal());
            }
        });
        
        
        //else display all orders
        for (Order order : listOrder) {
            System.out.println("Customer: " + order.getCustomerName());
            displayListOrderedFruit(order.getListFruit());
            System.out.printf("Total: %s$\n", order.getTotal());
            System.out.println("");
        }
    }

    //allow user to buy fruit
    void shopping() throws Exception {
        Order order = new Order();

        //check if the shop still have fruit or not
        if (control.getListFruit().isEmpty()) {
            System.out.println("NO FRUITS HAVE BEEN IMPORTED YET!");
            return;
        }
        while (true) {
            //display all fruit in the shop
            displayListFruit(control.getListFruit());
            Fruit pickedFruit;
            //loop until user get fruit they want
            while (true) {
                String id = getId();
                pickedFruit = control.getFruitByID(id);
                if (pickedFruit == null) {
                    System.out.println("Not a valid fruit id!");
                } else {
                    //display selected fruit name
                    System.out.println("You selected: " + pickedFruit.getName());
                    break;
                }
            }
            //allow user to enter number of fruit they want to order
            int orderQuantity;
            while (true) {
                orderQuantity = getQuantity();
                //print out a message if the number of fruit they order bigger than the remaining
                if (orderQuantity > pickedFruit.getQuantity()) {
                    System.out.println("We only have " + pickedFruit.getQuantity() + " left!");
                } else {
                    break;
                }
            }

            //create an ordered fruit to add to the order list later
            Fruit orderedFruit = new Fruit();
            orderedFruit.setId(pickedFruit.getId());
            orderedFruit.setName(pickedFruit.getName());
            orderedFruit.setOrigin(pickedFruit.getOrigin());
            orderedFruit.setQuantity(orderQuantity);
            orderedFruit.setPrice(pickedFruit.getPrice());

            //set remaining quantity of a fruit after user ordered
            pickedFruit.setQuantity(pickedFruit.getQuantity() - orderQuantity);

            //if a fruit have nothing left means there nothing to order
            //then we gonna delete that fruit in the list
            if (pickedFruit.getQuantity() == 0) {
                control.removeFruit(pickedFruit);
            }

            //add a fruit to the customer order
            //control.addFruitToOrder(orderedFruit, order);
            order.addFruitToOrder(orderedFruit);
            //ask user if they want to continue to shopping or not
            //if yes, continue to shop else stop
            if (checkYesNo("order now")) {
                break;
            }
            //if all product were bought, display message
            if (control.getListFruit().isEmpty()) {
                System.out.println("SOLD OUT!");
                break;
            }
        }

        //display user order after they finish shopping
        displayListOrderedFruit(order.getListFruit());
        //display total price
        System.out.println("Total: " + order.getTotal() + "$");
        String customerName = Utility.getString("Input your name: ", "Wrong", Utility.REGEX_STRING);
        //set customer name
        order.setCustomerName(customerName);
        //add an order to the list after all required information is entered
        control.addOrder(order);
        System.out.println("Order Successful!");
    }

    /**
     *
     * @return fruit id
     */
    private String getId() {
        String id = Utility.getString("Enter Fruit Id: ", "Invalid Fruit Id!", Utility.REGEX_STRING);
        return id;
    }

    /**
     *
     * @return fruit name
     */
    private String getName() {
        String name = Utility.getString("Enter Fruit Name: ", "Invalid Fruit Name!", Utility.REGEX_STRING);
        return name;
    }

    /**
     *
     * @return fruit price
     */
    private double getPrice() {
        double price = Utility.getPrice("Enter Fruit Price: ", "Invalid Fruit Price", 0);
        return price;
    }

    /**
     *
     * @return fruit quantity
     */
    private int getQuantity() {
        int quantity = Utility.getInt("Enter Fruit Quantity: ", "Invalid Fruit Quantity!", 0, 10000);
        return quantity;
    }

    /**
     *
     * @return fruit origin
     */
    private String getOrigin() {
        String origin = Utility.getString("Enter Fruit Origin: ", "Invalid Fruit Origin!", Utility.REGEX_STRING);
        return origin;
    }

    /**
     * check user decision
     *
     * @param message
     * @return
     */
    private boolean checkYesNo(String message) {
        String choice = Utility.getString("Do you want to " + message + " (Y/N)?: ", "You must enter Y/y or N/n!", Utility.REGEX_YN);
        if (choice.equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }

    /**
     * display list of all fruit
     *
     * @param listFruit
     */
    private void displayListFruit(ArrayList<Fruit> listFruit) {
        System.out.printf("%-10s|%-14s|%-10s|%-12s|%-10s\n", "++Item++", " ++Fruit Name++ ", " ++Origin++ ", " ++Quantity++ ", " ++Price++ ");
        for (Fruit fruit : listFruit) {
            System.out.println(fruit);
        }
    }

    /**
     * display all fruit in an order
     *
     * @param listOrderedFruit
     */
    private void displayListOrderedFruit(ArrayList<Fruit> listOrderedFruit) {
        System.out.printf("%-11s|%-11s|%-11s|%-11s\n", "Product", "Quantity", "Price", "Amount");
        for (int i = 1; i <= listOrderedFruit.size(); i++) {
            System.out.printf("%-12s%-12s%-12s%-12s\n", +i + "." + listOrderedFruit.get(i - 1).getName(),
                    listOrderedFruit.get(i - 1).getQuantity(),
                    listOrderedFruit.get(i - 1).getPrice() + "$",
                    listOrderedFruit.get(i - 1).getAmount() + "$");
        }
    }

}
