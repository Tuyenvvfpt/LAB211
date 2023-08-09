/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import model.Fruit;
import model.Order;

/**
 *
 * @author PC
 */
public class FruitController {

    //create a list that contain all fruit
    ArrayList<Fruit> listFruit = new ArrayList<>();

    //create a list that contain all order
    ArrayList<Order> listOrder = new ArrayList<>();
    
    //return fruit list
    public ArrayList<Fruit> getListFruit() {
        return listFruit;
    }
    
    //return order list
    public ArrayList<Order> getListOrder() {
        return listOrder;
    }

    //add a new fruit to the list
    public void addFruit(Fruit fruit) {
        listFruit.add(fruit);
    }

    //check to see if fruit id exist or not
    public boolean checkDuplicated(String id) {
        //loop from the first fruit to the last fruit
        for (Fruit fruit : listFruit) {
            //if user input id existed, return duplicated
            if (fruit.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        //if not, return not duplicated
        return false;
    }

    public Fruit getFruitByID(String id) {
        for (Fruit fruit : listFruit) {
            if (fruit.getId().equalsIgnoreCase(id)) {
                return fruit;
            }
        }
        return null;
    }

    //remove a fruit when it's quantity = 0
    public void removeFruit(Fruit pickedFruit) {
        listFruit.remove(pickedFruit);
    }

    //add an order to the list order
    public void addOrder(Order order) {
        listOrder.add(order);
    }

}
