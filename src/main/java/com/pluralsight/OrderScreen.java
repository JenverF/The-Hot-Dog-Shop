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
        System.out.println("Add regular toppings (comma separated):");
        String[] regulars = scanner.nextLine().split(",");
        for (String r : regulars) {
            if (!r.isBlank()) hotdog.addRegularTopping(r.trim());
        }

        // Premium toppings
        System.out.println("Add premium toppings (comma separated, each adds extra cost):");
        String[] premiums = scanner.nextLine().split(",");
        for (String p : premiums) {
            if (!p.isBlank()) hotdog.addPremiumTopping(p.trim());
        }

        // Extra toppings
        System.out.println("Would you like to add extra toppings for $0.50 each? (yes/no)");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Enter extra toppings (comma separated):");
            String[] extras = scanner.nextLine().split(",");
            for (String e : extras) {
                if (!e.isBlank()) hotdog.addExtraTopping(e.trim());
            }
        }

        // Condiments
        System.out.println("Add condiments (comma separated):");
        String[] condiments = scanner.nextLine().split(",");
        for (String c : condiments) {
            if (!c.isBlank()) hotdog.addCondiments(c.trim());
        }
        return hotdog;
    }

    public static Drink addDrink() {
        System.out.println("Enter drink size (small $2.00, medium $2.50, large $3.00): ");
        String size = scanner.nextLine();
        System.out.println("Enter flavor (Water, Coke, Dr. Pepper, etc): ");
        String flavor = scanner.nextLine();
        return new Drink(size, flavor);
    }

    public static Side addSide() {
        System.out.println("Enter side (chips, fries, onion rings, $1.50 each): ");
        String type = scanner.nextLine();
        return new Side(type);
    }

    public static void checkOut(Order order) {
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
