/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author PC
 */
public class Fruit {

    private String id, name, origin;
    private int quantity;
    private double price;

    /**
     * constructor with no parameters
     */
    public Fruit() {
    }

    /**
     *
     * @param id
     * @param name
     * @param origin
     * @param quantity
     * @param price
     */
    public Fruit(String id, String name, String origin, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.quantity = quantity;
        this.price = price;
    }
    /**
     * 
     * @return amount
     */
    public double getAmount() {
        return price * quantity;
    }
    /**
     *
     * @return fruit id
     */
    public String getId() {
        return id;
    }

    /**
     * set fruit id
     *
     * @param id
     */
    public void setId(String id) {
        if (id != null) {
            this.id = id;
        }
    }

    /**
     *
     * @return fruit name
     */
    public String getName() {
        return name;
    }

    /**
     * set fruit name
     *
     * @param name
     */
    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    /**
     *
     * @return fruit name
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * set fruit name
     *
     * @param orgin
     */
    public void setOrigin(String origin) {
        if (origin != null) {
            this.origin = origin;
        }
    }

    /**
     *
     * @return fruit quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * set fruit quantity
     *
     * @param quantity
     */
    public void setQuantity(int quantity) throws Exception {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            throw new Exception("Quantity must be greater than zero!");
        }
    }

    /**
     *
     * @return fruit price
     */
    public double getPrice() {
        return price;
    }

    /**
     * set fruit price
     *
     * @param price
     */
    public void setPrice(double price) throws Exception {
        if (price > 0) {
            this.price = price;
        } else {
            throw new Exception("Price must be greater than zero!");
        }
    }
    /**
     * 
     * @return fruit information 
     */
    @Override
    public String toString() {
        return String.format("    %-10s%-16s%-15s%-14s%-15s", id, name, origin, quantity, price);
    }

}
