package com.pluralsight;

import java.util.Scanner;

public class OrderScreen {
    static Scanner scanner = new Scanner(System.in);
    static void main() {
        displayOrderScreen();
    }

    public static void displayOrderScreen() {
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
                    // Drinks.addDrink();
                    break;
                case "3":
                    // checkout
                    break;
                case "4":
                    // Sides.addSide()
                    break;
                case "0":
                    System.out.println("Your order has been successfully cancelled.");
                    return;
                default:
                    System.out.println("Invalid Option");

            }
        }
    }
}
