/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Manage;
import java.util.List;
import model.Fruit;
import model.Order;

/**
 *
 * @author Admin
 */
public class ViewFruit {

    Manage manage = new Manage();

    void inputFruit(List<Fruit> listFruit) {
        while (true) {
            String id;
            while (true) {
                id = getId();
                //
                if (manage.checkDuplicate(id, listFruit)) {
                    System.out.println("Duplicate !");
                } else {
                    break;
                }

            }
            String name = getName();
            double price = getPrice();
            int quantity = getQuantity();
            String origin = getOrigin();

            Fruit fruit = new Fruit(name, origin, id, price, quantity);
            listFruit.add(fruit);

            if (checkYesNo() == false) {
                break;
            }
        }

    }

    private String getId() {
        String id = Ultility.getString("Enter ID: ", Ultility.REGEX_STRING, "Input must be string !");
        return id;
    }

    private String getName() {
        String name = Ultility.getString("Enter Name: ", Ultility.REGEX_STRING, "Input must be string !");
        return name;
    }

    private double getPrice() {
        double price = Ultility.getDouble("Enter Price: ", 1, Double.MAX_VALUE);
        return price;
    }

    private int getQuantity() {
        int quantity = Ultility.getInt("Enter Quantity: ", 1, Integer.MAX_VALUE);
        return quantity;
    }

    private String getOrigin() {
        String origin = Ultility.getString("Enter Origin: ", Ultility.REGEX_STRING, "Input must be string !");
        return origin;
    }

    private boolean checkYesNo() {
        String message = Ultility.getString("Do you want to continue (Y/N) ? : ",
                Ultility.REGEX_YN, "Input must be [Y or N]");
        if (message.equalsIgnoreCase("Y")) {
            return true;
        } else {
            return false;
        }
    }

    void shopping(List<Fruit> listFruit, List<Order> listOrder) {
        Order order = new Order();

        while (true) {

            displayMenuFruit(listFruit);
            //from item get fruit by id
            String item;
            Fruit fruitPicked;
            while (true) {
                item = getId();
                fruitPicked = manage.getFruitById(item, listFruit);
                if (fruitPicked == null) {
                    System.out.println("NOT FOUND !!!");
                } else {
                    System.out.println("You selected: " + fruitPicked.getName());
                    break;
                }
            }
            int quantityOrder;
            while (true) {
                quantityOrder = getQuantity();
                // gia su trong kho co 120 qua. ma quantity order nhap vao la 130 qua
                //else: neu nhu trong kho co 120 qua. ma quantity nhap vao la 100 qua
                //set lai quantity trong kho. gia tri moi = 120 - 100 = 20
                if (quantityOrder > fruitPicked.getQuantity()) {
                    System.out.println("You only can buy [1 - " + fruitPicked.getQuantity() + "]");
                } else {
                    fruitPicked.setQuantity(fruitPicked.getQuantity() - quantityOrder);
                    break;
                }
                //
            }
            if (fruitPicked.getQuantity() == 0) {
                listFruit.remove(fruitPicked);
            }

            Fruit fruitOrder = new Fruit();
            fruitOrder.setId(fruitPicked.getId());
            fruitOrder.setName(fruitPicked.getName());
            fruitOrder.setOrigin(fruitPicked.getOrigin());
            fruitOrder.setPrice(fruitPicked.getPrice());
            fruitOrder.setQuantity(quantityOrder);

            manage.addFruitToOrder(fruitOrder, order);
            //if customer input Y or N. Y to continue. N to return to List of Fruit
            if (checkOrderNow()) {
                break;
            }

        }
        displayInvoiceList(order);
        String customer = Ultility.getString("Input your name: ", Ultility.REGEX_STRING, "Input must be string");
        order.setCustomer(customer);
        listOrder.add(order);
    }

    private void displayMenuFruit(List<Fruit> listFruit) {
        System.out.printf("%-10s%-20s%-20s%-15s\n",
                "++Item++", "++Fruit Name++", "++Origin++", "++Price++");
        for (Fruit fruit : listFruit) {
            fruit.display();
        }
    }

    private boolean checkOrderNow() {
        String message = Ultility.getString("Do you want to order now (Y/N) ? : ",
                Ultility.REGEX_YN, "Input must be [Y or N]");
        if (message.equalsIgnoreCase("Y")) {
            return true;
        } else {
            return false;
        }
    }

    private void displayInvoiceList(Order order) {
        double total = 0;
        System.out.printf("%-20s%-20s%-20s%s$\n", "Product", "Quantity", "Price", "Amount");
        for (Fruit fruit : order.getInvoiceList()) {
            fruit.displayFruitOrder();
            total += fruit.getAmout();
        }
        System.out.println("Total: "+ total+"$");
        
    }

    void viewOrder(List<Order> listOrder) {
        if(listOrder.isEmpty()){
            System.out.println("List order now is empty");
            return ;
        }
        for (Order order : listOrder) {
            System.out.println("Customer: " + order.getCustomer());
            displayInvoiceList(order);
        }
        
    }

}
