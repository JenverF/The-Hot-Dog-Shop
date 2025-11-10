package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private double orderTotal;
    private List<Items> inventory = new ArrayList<>();

    public List<Items> getItems() {
        return inventory;
    }

    public void addItem(Items items) {
        inventory.add(items);
    }

    public double calculateTotal() {
        orderTotal = 0;
        for(Items items : inventory) {
            orderTotal += items.getCost();
        }
        return orderTotal;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderTotal=" + orderTotal +
                ", inventory=" + inventory +
                '}';
    }
}
