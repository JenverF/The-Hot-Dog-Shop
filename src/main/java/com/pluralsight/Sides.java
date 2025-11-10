package com.pluralsight;

public class Sides extends Items {
    private String type;

    public Sides(double basePrice, String name, String size) {
        super(basePrice, name, size);
    }

    @Override
    public double getCost() {
        return basePrice;
    }

    public String getType() {
        return type;
    }
}
