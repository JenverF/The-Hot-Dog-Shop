package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Item> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        if(item != null) {
            items.add(item);
        } else {
            System.out.println("Invalid item, not added to order");
        }
    }

    public double getTotal() {
        double total = 0;
        for(Item i : items) {
            total += i.getPrice();
        }
        return total;
    }

    public String displayOrder() {
        String summary = "========== ORDER SUMMARY ==========\n";

        for (Item i : items) {
            summary += i.getSummary() + "\n";
        }
        return summary;
    }
}
