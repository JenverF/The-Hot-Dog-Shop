package com.pluralsight;

import java.util.Scanner;

public class OrderScreen {
    static Scanner scanner = new Scanner(System.in);

    public static void displayOrderScreen() {
        Order order = new Order();
        while(true) {
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
                    // order.addItem(addSide());
                    break;
                case "4":
                    checkOut(order);
                    return;
                case "0":
                    System.out.println("Your order has been successfully cancelled.");
                    return;
                default:
                    System.out.println("Invalid Option");

            }
        }
    }

    public static Drink addDrink() {
        System.out.println("Enter drink size (small, medium, large): ");
        String size = scanner.nextLine();

        System.out.println("Enter flavor (Water, Coke, Dr. Pepper, etc): ");
        String flavor = scanner.nextLine();
        return new Drink(size, flavor);
    }

    public static void checkOut(Order order) {
        System.out.println(order.displayOrder());
        System.out.printf("Total: $%.2f\n", order.getTotal());

        System.out.print("Confirm order? (yes/no): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            ReceiptManager.saveReceipt(order);
            System.out.println("Receipt saved!\n");
        } else {
            System.out.println("Order discarded.\n");
        }
    }
}
