package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class HotDog extends Item {
    private String hotDogType;
    private String hotDogSize;
    private boolean toastedBun;
    private List<String> toppings;
    private List<String> premiumToppings;
    private List<String> condiments;
    private List<String> extraToppings;

    public HotDog(String hotDogSize, String hotDogType, boolean toastedBun) {
        super("HotDog", 0.0);
        this.hotDogType = hotDogType;
        this.hotDogSize = hotDogSize;
        this.toastedBun = toastedBun;
        this.toppings = new ArrayList<>();
        this.premiumToppings = new ArrayList<>();
        this.condiments = new ArrayList<>();
        this.extraToppings = new ArrayList<>();
        setBasePrice();
    }

    private void setBasePrice() {
        switch(hotDogSize) {
            case "small":
                price = 4.00;
                break;
            case "medium":
                price = 5.50;
                break;
            case "large":
                price = 7.00;
                break;
            default:
                price = 5.50;
                break;
        }
        if(toastedBun) {
            price += 0.25;
        }
    }

    public void addRegularTopping(String topping) {
        toppings.add(topping);
    }

    public void addPremiumTopping(String premTopping) {
        premiumToppings.add(premTopping);
        switch(hotDogSize) {
            case "small":
                price += 0.75;
                break;
            case "medium":
                price += 1.00;
                break;
            case "large":
                price += 1.50;
                break;
            default:
                price = 1.00;
                break;
        }
    }

    public void addExtraTopping(String extraTopping) {
        extraToppings.add(extraTopping);
        switch(hotDogSize) {
            case "small":
                price += 0.30;
                break;
            case "medium":
                price += 0.60;
                break;
            case "large":
                price += 0.90;
                break;
            default:
                price = 0.60;
                break;
        }

    }

    public void addCondiments(String sauce) {
        condiments.add(sauce);
    }

    @Override
    public String getSummary() {
        return String.format("""
                %s %s hot dog%s
                Regular Toppings: %s
                Premium Toppings: %s
                Extra Toppings: %s
                Condiments: %s
                \nhot dog PRICE: $%s""", hotDogSize, hotDogType, toastedBun ? " with toasted bun " : "", toppings, premiumToppings, extraToppings, condiments, price);
    }
}
