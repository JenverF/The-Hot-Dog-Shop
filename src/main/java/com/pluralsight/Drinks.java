package com.pluralsight;

public class Drinks extends Items {
    private double price;
    private String size;
    private String name;

    public Drinks(double basePrice, String name, String size) {
        super(basePrice, name, size);
    }

    public double getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getCost() {
        return basePrice;
    }
}
