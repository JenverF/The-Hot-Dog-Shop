package com.pluralsight;

import java.util.Scanner;

public class OrderScreen {
    static Scanner scanner = new Scanner(System.in);

    //displays the order screen
    public static void displayOrderScreen() {
        Order order = new Order(); //creates a new order
        boolean isRunning = true;
        //while program is running, show order menu
        while(isRunning) {
            String options = """
                    ==========================
                    What would you like to do?
                        1) Add Hot Dog
                        2) Add Drink
                        3) Add Side
                        4) Checkout
                        0) Cancel Order
                    Please select an option:
                    ==========================""";
            System.out.println(options);
            String choice = scanner.nextLine();

            switch(choice) {
                // if user inputs 1, adds hotdog
                case "1":
                    order.addItem(addHotDog());
                    break;
                // if user inputs 2, adds a drink
                case "2":
                    order.addItem(addDrink());
                    break;
                // if user inputs 3, adds a side
                case "3":
                    order.addItem(addSide());
                    break;
                // if user inputs 4, goes to checkout screen
                case "4":
                    checkOut(order);
                    System.out.println("Thank you come again!");
                    isRunning = false;
                    break;
                // if user inputs 0, cancels order
                case "0":
                    System.out.println("Your order has been successfully cancelled.");
                    return;
                // if user enters something that's not the options, print that the option is invalid
                default:
                    System.out.println("Invalid Option");

            }
        }
    }

    // check if input is in the menu items
    private static boolean isValid(String input, String[] validList) {
        //traverses the list of the menu items to check if item is in menu items
        for (String valid : validList) {
            //equalsIgnoreCase compares two strings ignoring difference in string
            if (valid.equalsIgnoreCase(input.trim())) return true; //if item is in the list, return true
        } //trim removes spaces before and after the words
        return false; //if item is not in the menu items list, it is invalid
    }
    // adding stuff to each hot dog with a foreach loop that checks if that topping is in the list
    // adds hotdog to the order
    public static HotDog addHotDog() {
        System.out.println("Enter hot dog size (small, medium, large):");//ask user for hot dog size
        String size = scanner.nextLine(); // input for hot dog size

        System.out.println("Enter type of hot dog (regular, spicy, cheesy, veggie):");
        String type = scanner.nextLine();

        // Special option
        System.out.println("Would you like the bun toasted for $0.25? (yes/no):");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        // creates a hot dog object with size, type, and toasted
        HotDog hotdog = new HotDog(size, type, toasted);

        // Regular toppings
        System.out.println("Add regular toppings (" + String.join(", ", MenuItems.regularToppings) + "):");
        String[] toppingInput = scanner.nextLine().split(","); // array for toppings ordered separating each topping with commas
        // traverses through the toppings input
        for (String t : toppingInput) {
            // if the toppings input are in toppings list, adds them to the order
            if (isValid(t, MenuItems.regularToppings)) {
                hotdog.addRegularTopping(t.trim());
            // if toppings input is not in toppings list, toppings are invalid
            } else if (!t.isBlank()) {
                System.out.println("Invalid topping: " + t.trim());
            }
        }

        // Premium toppings
        System.out.println("Add premium toppings (" + String.join(", ", MenuItems.premiumtoppings) + "):");
        String[] premiumInput = scanner.nextLine().split(","); //array for premium toppings ordered
        //traverses through premium input, and checks if they are valid
        for (String p : premiumInput) {
            if (isValid(p, MenuItems.premiumtoppings)) {
                hotdog.addPremiumTopping(p.trim());
            } else if (!p.isBlank()) {
                System.out.println("Invalid premium topping: " + p.trim());
            }
        }

        // Extra toppings
        System.out.println("Would you like to add extra toppings for $0.50 each? (yes/no)");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Add extra toppings (" + String.join(", ", MenuItems.regularToppings) + "):");
            String[] extraInput = scanner.nextLine().split(",");
            for (String e : extraInput) {
                if (isValid(e, MenuItems.regularToppings)) {
                    hotdog.addExtraTopping(e.trim());
                } else if (!e.isBlank()) {
                    System.out.println("Invalid extra topping: " + e.trim());
                }
            }
        }

        // Condiments
        System.out.println("Add condiments (" + String.join(", ", MenuItems.condiments) + "):");
        String[] condInput = scanner.nextLine().split(",");
        for (String c : condInput) {
            if (isValid(c, MenuItems.condiments)) {
                hotdog.addCondiments(c.trim());
            } else if (!c.isBlank()) {
                System.out.println("Invalid condiment: " + c.trim());
            }
        }
        System.out.println("Your hot dog has been added.");
        return hotdog;
    }

    // add drink to order from an array list
    public static Drink addDrink() {
        System.out.println("Enter drink size (small, medium, large):");
        String size = scanner.nextLine().trim().toLowerCase();

        System.out.println("Enter drink flavor (" + String.join(", ", MenuItems.drinks) + "):");
        String flavor = scanner.nextLine().trim().toLowerCase();
        // if inputted drink is not in the list, it's invalid
        if (!isValid(flavor, MenuItems.drinks)) {
            System.out.println("Invalid drink selection.");
            return null;
        }
        System.out.println("Your drink has been added.");
        return new Drink(size, flavor);
    }

    // add side to order from an array list
    public static Side addSide() {
        System.out.println("Enter side (" + String.join(", ", MenuItems.sides) + "):");
        String type = scanner.nextLine().trim().toLowerCase();
        // if the inputted side is not in the list, it's invalid
        if (!isValid(type, MenuItems.sides)) {
            System.out.println("Invalid side selection.");
            return null;
        }
        System.out.println("Your side has been added.");
        return new Side(type);
    }

    // checkout order method
    public static void checkOut(Order order) {
        // If you try to check our before ordering anything, it won't let you
        if(order == null || order.getItems().isEmpty()) {
            System.out.println("You haven't ordered anything yet! Check out when you add items to your order.");
            return;
        }

        System.out.println(order.displayOrder());
        System.out.printf("Total: $%.2f\n", order.getTotal());
        // confirmation of order, yes to proceed with the order, no to cancel and go back to home page
        System.out.print("Confirm order? (yes/no): ");
        String confirm = scanner.nextLine();
        // saves order to receipts folder
        if (confirm.equalsIgnoreCase("yes")) {
            ReceiptManager.saveReceipt(order);
        } else {
            System.out.println("Order not saved.\n");
        }
    }
}
