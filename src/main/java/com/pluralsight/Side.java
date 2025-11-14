package com.pluralsight;

// Side class that inherits name and price fields from items
public class Side extends Item {
    public Side(String name) {
        super(name, 0.0);
        setPrice();
    }

    // set price to all sides to $1.50
    public void setPrice() {
        price = 1.50;
    }

    // returns a formatted summary of the side to display in the order summary and receipt
    @Override
    public String getSummary() {
        return name + " PRICE: $" + price;
    }
}
