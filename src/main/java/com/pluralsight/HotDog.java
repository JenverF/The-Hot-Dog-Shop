package com.pluralsight;

import java.util.ArrayList;

public class HotDog extends Item {
    private String hotDogType;
    private String hotDogSize;
    private boolean toastedBun;
    private ArrayList<String> toppings;
    private ArrayList<String> premiumToppings;
    private ArrayList<String> condiments;

    public String getHotDogType() {
        return hotDogType;
    }

    public String getHotDogSize() {
        return hotDogSize;
    }

    public boolean isToastedBun() {
        return toastedBun;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public ArrayList<String> getPremiumToppings() {
        return premiumToppings;
    }

    public ArrayList<String> getCondiments() {
        return condiments;
    }

    @Override
    public double getCost() {
        return 0;
    }
}
