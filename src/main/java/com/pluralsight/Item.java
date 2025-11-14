package com.pluralsight;

// abstract class that drink, hot dog, and side extend into because they share a name, price, and summary
public abstract class Item {
    public String name;
    public double price;

    // set the initial values
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // abstract method for each item that overrides this to provide its own summary for the user's receipt
    public abstract String getSummary();
}
