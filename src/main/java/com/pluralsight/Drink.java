package com.pluralsight;

public class Drink extends Item {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        super("Drink", 0.0);
        this.size = size;
        this.flavor = flavor;
        setPrice();
    }

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

    @Override
    public String getSummary() {
        return size + " " + flavor + " PRICE: $" + price;
    }
}
