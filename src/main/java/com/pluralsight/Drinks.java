package com.pluralsight;

public class Drinks extends Items{
    private double price;
    private String size;
    private String name;

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
        return 0;
    }
}
