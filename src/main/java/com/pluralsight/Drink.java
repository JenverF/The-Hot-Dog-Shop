package com.pluralsight;

public class Drink extends Item {
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

    public static void addDrink() {
        Drink drink = new Drink();

    }

    @Override
    public double getCost() {
        return 0;
    }
}
