package com.pluralsight;

import java.util.Scanner;

public class OrderScreen {
    static Scanner scanner = new Scanner(System.in);

    public static void displayOrderScreen() {
        Order order = new Order();
        boolean isRunning = true;
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
                case "1":
                    order.addItem(addHotDog());
                    break;
                case "2":
                    order.addItem(addDrink());
                    break;
                case "3":
                    order.addItem(addSide());
                    break;
                case "4":
                    checkOut(order);
                    System.out.println("Thank you come again!");
                    isRunning = false;
                    break;
                case "0":
                    System.out.println("Your order has been successfully cancelled.");
                    return;
                default:
                    System.out.println("Invalid Option");

            }
        }
    }

    private static boolean isValid(String input, String[] validList) {
        for (String valid : validList) {
            if (valid.equalsIgnoreCase(input.trim())) return true;
        }
        return false;
    }

    public static HotDog addHotDog() {
        System.out.println("Enter hot dog size (small, medium, large):");
        String size = scanner.nextLine();

        System.out.println("Enter type of hot dog (regular, spicy, cheesy, veggie):");
        String type = scanner.nextLine();

        // Special option
        System.out.println("Would you like the bun toasted for $0.25? (yes/no):");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        HotDog hotdog = new HotDog(size, type, toasted);

        // Regular toppings
        System.out.println("Add regular toppings (" + String.join(", ", MenuItems.regularToppings) + "):");
        String[] toppingInput = scanner.nextLine().split(",");
        for (String t : toppingInput) {
            if (isValid(t, MenuItems.regularToppings)) {
                hotdog.addRegularTopping(t.trim());
            } else if (!t.isBlank()) {
                System.out.println("Invalid topping: " + t.trim());
            }
        }

        // Premium toppings
        System.out.println("Add premium toppings (" + String.join(", ", MenuItems.premiumtoppings) + "):");
        String[] premiumInput = scanner.nextLine().split(",");
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

    public static Drink addDrink() {
        System.out.println("Enter drink size (small, medium, large):");
        String size = scanner.nextLine().trim().toLowerCase();

        System.out.println("Enter drink flavor (" + String.join(", ", MenuItems.drinks) + "):");
        String flavor = scanner.nextLine().trim().toLowerCase();

        if (!isValid(flavor, MenuItems.drinks)) {
            System.out.println("Invalid drink selection.");
            return null;
        }
        System.out.println("Your drink has been added.");
        return new Drink(size, flavor);
    }

    public static Side addSide() {
        System.out.println("Enter side (" + String.join(", ", MenuItems.sides) + "):");
        String type = scanner.nextLine().trim().toLowerCase();

        if (!isValid(type, MenuItems.sides)) {
            System.out.println("Invalid side selection.");
            return null;
        }
        System.out.println("Your side has been added.");
        return new Side(type);
    }

    public static void checkOut(Order order) {
        if(order == null || order.getItems().isEmpty()) {
            System.out.println("You haven't ordered anything yet! Check out when you add items to your order.");
            return;
        }

        System.out.println(order.displayOrder());
        System.out.printf("Total: $%.2f\n", order.getTotal());

        System.out.print("Confirm order? (yes/no): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            ReceiptManager.saveReceipt(order);
        } else {
            System.out.println("Order not saved.\n");
        }
    }
}
