package com.pluralsight;

public abstract class Items {
    public double basePrice;
    public String name;
    public String size;

    public Items(double basePrice, String name, String size) {
        this.basePrice = basePrice;
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public abstract double getCost();
}
