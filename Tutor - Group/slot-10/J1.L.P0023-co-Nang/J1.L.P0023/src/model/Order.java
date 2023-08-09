/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Order {

    private String customerName;
    private ArrayList<Fruit> listFruitOrder = new ArrayList<>();

    /**
     * constructor with no parameter
     */
    public Order() {
    }

    /**
     *
     * @param customerName
     * @param listFruit
     */
    public Order(String customerName, ArrayList<Fruit> listFruit) {
        this.customerName = customerName;
        this.listFruitOrder = listFruit;
    }

    /**
     *
     * @return customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * set customer name
     *
     * @param customerName
     */
    public void setCustomerName(String customerName) {
        if (customerName != null) {
            this.customerName = customerName;
        }
    }
    /**
     * 
     * @return list ordered fruit 
     */
    public ArrayList<Fruit> getListFruit() {
        return listFruitOrder;
    }
    /**
     * set fruit in an order
     * @param listFruit 
     */
    public void setListFruit(ArrayList<Fruit> listFruit) {
        this.listFruitOrder = listFruit;
    }

    /**
     *
     * @return total price of an order
     */
    public double getTotal() {
        double total = 0;
        double temp;
        //loop from the fist fruit to the last fruit in the order list
        for (int i = 0; i < listFruitOrder.size(); i++) {
            //total bill = fruit * quantity
            temp = listFruitOrder.get(i).getPrice() * listFruitOrder.get(i).getQuantity();
            total += temp;
        }
        return total;
    }
    /**
     * 
     * @param id
     * @return fruit by id
     */
    public Fruit getFruitByID(String id) {
        for (Fruit fruit : listFruitOrder) {
            if (fruit.getId().equalsIgnoreCase(id)) {
                return fruit;
            }
        }
        return null;
    }
    /**
     * 
     * @param orderedFruit
     * @throws Exception 
     */
    public void addFruitToOrder(Fruit orderedFruit) throws Exception {
        //check if the fruit have been order before or not
        Fruit existedFruit = getFruitByID(orderedFruit.getId());
        //if the fruit haven't been order before, add a new fruit in the order list
        //if it's existed in the order, stack the quantity
        if (existedFruit == null) {
          listFruitOrder.add(orderedFruit);
        } else {
            existedFruit.setQuantity(orderedFruit.getQuantity() + existedFruit.getQuantity());
        }
    }
    
    
}
