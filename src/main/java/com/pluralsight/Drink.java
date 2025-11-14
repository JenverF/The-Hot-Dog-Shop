package com.pluralsight;

// Drink class that inherits name and price fields from items and has its own size and flavor
public class Drink extends Item {
    private String size;
    private String flavor;

    // constructor that initializes a drink with a size and flavor and calls setPrice() to get the drink's price based on size
    public Drink(String size, String flavor) {
        super("Drink", 0.0);
        this.size = size;
        this.flavor = flavor;
        setPrice();
    }

    // calculates the price of the drink based on the size, if size doesn't match any valid option, it defaults to medium drink price
    public void setPrice() {
        switch(size.toLowerCase()) {
            case "small":
                price = 2.00;
                break;
            case "medium":
                price = 2.50;
                break;
            case "large":
                price = 3.00;
                break;
            default:
                price = 2.50;
                break;
        }
    }

    // Returns a formatted summary of the drink to display in the order receipt and summary
    @Override
    public String getSummary() {
        return size + " " + flavor + " PRICE: $" + price;
    }
}
