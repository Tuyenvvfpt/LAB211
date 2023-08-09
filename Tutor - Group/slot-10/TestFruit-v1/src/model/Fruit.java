/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Fruit {
    private String name,origin,id;
    private double price;
    private int quantity;

    public Fruit() {
    }

    public Fruit(String name, String origin, String id, double price, int quantity) {
        this.name = name;
        this.origin = origin;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getAmout(){
        return quantity * price;
    }

    public void display() {
        System.out.printf("%-10s%-20s%-20s%s$\n",id,name,origin,price);        
    }
    
    public void displayFruitOrder() {
        System.out.printf("%-20s%-20s%-20s%s$\n",name,quantity,price,getAmout());        
    }
    
    
}
