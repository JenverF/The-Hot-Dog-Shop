package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

// HotDog class that represents a customizable hot dog. It extends the item class
// Includes options for toppings, premium toppings, condiments, extras, hot dog type, size and bun toasted or not
public class HotDog extends Item {
    private String hotDogType; // hot dog type, spicy , regular, veggie, cheesy
    private String hotDogSize; // size of hot dog, small medium large
    private boolean toastedBun; // indicates whether the bun is toasted
    // lists to store different kinds of toppings and condiments
    private List<String> toppings; // regular (free)
    private List<String> premiumToppings; // premium (extra cost)
    private List<String> condiments; // condiments (free)
    private List<String> extraToppings;  // extra toppings (additional charge)

    // constructor for creating hot dog object
    public HotDog(String hotDogSize, String hotDogType, boolean toastedBun) {
        super("HotDog", 0.0);
        this.hotDogType = hotDogType;
        this.hotDogSize = hotDogSize;
        this.toastedBun = toastedBun;
        this.toppings = new ArrayList<>();
        this.premiumToppings = new ArrayList<>();
        this.condiments = new ArrayList<>();
        this.extraToppings = new ArrayList<>();
        setBasePrice(); // set the starting price based on size and if its toasted
    }

    // sets the base price of the hot dog depending on size and applies extra cost if the bun is toasted
    // if size doesn't match a valid option, defaults to small hot dog price
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
                price = 4.00;
                break;
        }
        if(toastedBun) {
            price += 0.25;
        }
    }

    // adds a regular topping for free
    public void addRegularTopping(String topping) {
        toppings.add(topping);
    }

    // adds a premium topping for an extra cost, cost increases based on the size of the hot dog
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

    // adds an extra topping and increases price based on size
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
                System.out.println("Not a valid input.");;
                break;
        }

    }

    // adds condiments for free
    public void addCondiments(String sauce) {
        condiments.add(sauce);
    }

    // returns a formatted string of this hot dog and includes all toppings, condiments, and final price to display in the customer's order summary and receipt
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
