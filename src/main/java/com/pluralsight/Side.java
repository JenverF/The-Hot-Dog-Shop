package com.pluralsight;

public class Side extends Item {
    public Side(String name, double price) {
        super(name, price);
        setPrice();
    }

    public void setPrice() {
        price = 1.50;
    }

    @Override
    public String getSummary() {
        return name + "Price: " + price;
    }
}
