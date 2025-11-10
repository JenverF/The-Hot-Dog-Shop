package com.pluralsight;

public class Drink extends Item {
    private double price;
    private String size;
    private String name;
    static String [] drinks = {"Dr. Pepper", "Coke", "Pepsi", "Water", "Lemonade", "Sprite"};

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
        double price = 0;

        System.out.println("What drink would you like?");
        //for(String drink1 : drinks)
    }

    @Override
    public double getCost() {
        return 0;
    }
}
