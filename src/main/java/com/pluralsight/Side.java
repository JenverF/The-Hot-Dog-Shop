package com.pluralsight;

public class Side extends Item {
    public Side(String name) {
        super(name, 0.0);
        setPrice();
    }

    public void setPrice() {
        price = 1.50;
    }

    @Override
    public String getSummary() {
        return name + " PRICE: $" + price;
    }
}
