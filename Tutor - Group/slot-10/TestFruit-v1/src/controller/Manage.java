/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Fruit;
import model.Order;

/**
 *
 * @author Admin
 */
public class Manage {

    public boolean checkDuplicate(String id, List<Fruit> listFruit) {
        for (Fruit fruit : listFruit) {
            if (fruit.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public Fruit getFruitById(String item, List<Fruit> listFruit) {
        for (Fruit fruit : listFruit) {
            if (fruit.getId().equalsIgnoreCase(item)) {
                return fruit;
            }
        }
        return null;
    }

    public void addFruitToOrder(Fruit fruitOrder, Order order) {
        // lay ve hoa qua co ben trong danh sach dua tren id cua fruitOrder
        //neu chua tung ton tai thi fruitInList = null. them hoa qua moi vao trong danh sach
        //neu ton tai thi se cong don so luon cua fruitInList nay voi so luong cua fruitOrder
        Fruit fruitInList = getFruitById(fruitOrder.getId(), order.getInvoiceList());
        if (fruitInList == null) {
            order.getInvoiceList().add(fruitOrder);
        } else {
            fruitInList.setQuantity(fruitInList.getQuantity() + fruitOrder.getQuantity());
        }

    }

}
