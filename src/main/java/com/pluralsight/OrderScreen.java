package com.pluralsight;

import java.util.Scanner;

public class OrderScreen {
    static Scanner scanner = new Scanner(System.in);

    public static void displayOrderScreen() {
        Order order = new Order();
        boolean isRunning = true;
        while(isRunning) {
            String options = """
                    --------------------------
                    What would you like to do?
                        1) Add Hot Dog
                        2) Add Drink
                        3) Add Side
                        4) Checkout
                        0) Cancel Order
                    Please select an option:
                    --------------------------""";
            System.out.println(options);
            String choice = scanner.nextLine();
            switch(choice) {
                case "1":
                    // HotDog.addHotDog()
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

//    public static HotDog addHotDog() {
//        System.out.println("Enter Hot Dog size (small, medium, large");
//        String size = scanner.nextLine();
//        System.out.println("Enter Hot Dog type (regular, spicy, vegan, cheesy):");
//        String type = scanner.nextLine();
//        System.out.println("Would you like the bun toasted? (yes/no)");
//        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");
//
//        HotDog hotdog = new HotDog(size, type, toasted);
//    }

    public static Drink addDrink() {
        System.out.println("Enter drink size (small, medium, large): ");
        String size = scanner.nextLine();
        System.out.println("Enter flavor (Water, Coke, Dr. Pepper, etc): ");
        String flavor = scanner.nextLine();
        return new Drink(size, flavor);
    }

    public static Side addSide() {
        System.out.println("Enter side (chips, fries, onion rings): ");
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
