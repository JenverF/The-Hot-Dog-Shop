package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

// Order class that represents the customer's entire order, stores a list of item objects
public class Order {
    private List<Item> items; // a list holding all items in the customers order

    public Order() { // constructor that initializes an empty order with no items
        this.items = new ArrayList<>();
    }

    // returns the list of items in the order
    public List<Item> getItems() {
        return items;
    }

    // adds an item to the order as long as it is not null
    public void addItem(Item item) {
        if(item != null) {
            items.add(item);
        } else {
            System.out.println("Not added to order");
        }
    }

    // calculates and returns the total price of all items in the order
    public double getTotal() {
        double total = 0;
        for(Item i : items) {
            total += i.getPrice();
        }
        return total;
    }

    // generates a formatted summary of all items so the user can see when they check out and saves to the receipt file
    public String displayOrder() {
        String summary = "========== ORDER SUMMARY ==========\n";

        for (Item i : items) {
            summary += i.getSummary() + "\n";
        }
        return summary;
    }
}
