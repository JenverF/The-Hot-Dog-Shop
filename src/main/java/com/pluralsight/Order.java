package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Item> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double getTotal() {
        double total = 0;
        for(Item i : items) {
            total += i.getPrice();
        }
        return total;
    }

    public String displayOrder() {
        String summary = "===== ORDER SUMMARY =====\n";

        for (Item i : items) {
            summary += i.getSummary() + "\n";
        }
        summary += String.format("Total: $%.2f\n", getTotal());
        return summary;
    }
}
