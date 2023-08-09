/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Order {
    String customer;
    List<Fruit> invoiceList = new ArrayList<>();

    public Order() {
    }

    public Order(String customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<Fruit> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Fruit> invoiceList) {
        this.invoiceList = invoiceList;
    }
    
    
    
}
