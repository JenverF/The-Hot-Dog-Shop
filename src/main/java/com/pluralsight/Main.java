package com.pluralsight;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static void main() {
        homeScreen();
    }

    public static void homeScreen() {
        boolean isRunning = true;

        while(isRunning) {
            String options = """
                    -------------------------------------------------------------
                    Welcome to Franks House, home of the best hot dogs in Seattle!
                        1) New Order
                        0) Exit
                    Select an option:
                    -------------------------------------------------------------""";
            System.out.println(options);
            String choice = scanner.nextLine();
            switch(choice) {
                case "1":
                    OrderScreen.displayOrderScreen();
                    break;
                case "0":
                    System.out.println("Bye.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                    return;
            }
        }
    }
}
