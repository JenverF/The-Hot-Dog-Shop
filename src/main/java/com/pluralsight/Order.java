package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private double orderTotal;
    private List<Item> inventory = new ArrayList<>();

    public List<Item> getItems() {
        return inventory;
    }

    public void addItem(Item items) {
        inventory.add(items);
    }

    public double calculateTotal() {
        orderTotal = 0;
        for(Item items : inventory) {
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
