package com.pluralsight;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    // main method
    static void main() {
        homeScreen();
    }

    // Controls the homescreen
    public static void homeScreen() {
        boolean isRunning = true; //checks if the function is running


        while(isRunning) {
            String options = """
                    ====================================================================================
                         _                     _      _  _     _     ___               ___          _  \s
                      _ | |___ _ ___ _____ _ _( )___ | || |___| |_  |   \\ ___  __ _   / __|__ _ _ _| |_\s
                     | || / -_) ' \\ V / -_) '_|/(_-< | __ / _ \\  _| | |) / _ \\/ _` | | (__/ _` | '_|  _|
                      \\__/\\___|_||_\\_/\\___|_|   /__/ |_||_\\___/\\__| |___/\\___/\\__, |  \\___\\__,_|_|  \\__|
                                                                              |___/                    \s
                                   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⡴⠶⠚⠛⠛⡿⠿⣿⠛⢶⠛⠓⠶⢦⣄⠀
                                   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⠶⠛⠉⠀⣀⣀⣴⡶⠾⢤⣚⠉⢣⡈⠳⡀⠀⠀⠹⡆
                                   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⠶⠛⠉⠀⠀⠀⡏⠉⢁⡤⢟⠀⡖⢦⡈⠓⠤⠵⠀⡇⠀⠀⠀⣿
                                   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⡴⠶⠛⠋⠉⠀⠀⣀⠤⠴⡽⠋⠁⠚⣅⠀⠸⡀⢳⠀⠉⠒⠤⠔⡞⠉⠒⠉⢱⣏
                                   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⡴⠶⠚⠋⢉⣀⠀⠀⣀⣠⣎⣁⠚⣁⡤⠖⡁⢸⠉⢦⡈⠳⠤⠃⡸⠀⢀⡴⠒⠴⡥⠒⠒⢦⢀⡿
                                   ⠀⠀⠀⠀⠀⠀⢀⣠⣤⠶⠛⠋⠉⠀⠀⣀⣀⣰⠋⠀⠉⠉⢠⠏⢁⣀⠙⢧⡀⠀⡇⠈⡇⠀⠙⠒⠤⢲⠗⠒⠚⢀⠖⠋⠀⠀⠀⢸⡟⠀
                                   ⠀⠀⠀⠀⣴⠞⠋⠁⠀⡰⠓⢦⠤⠒⠚⠀⡸⠋⡉⠓⣖⠉⠹⡀⢸⠀⠱⢄⡈⠉⣡⠜⠓⠤⡤⠒⣒⣋⣀⠞⠁⠀⠀⠀⠀⠀⠀⣾⠃⠀
                                   ⠀⠀⢀⣼⣧⣀⡞⣉⣉⣡⠞⢉⡉⠳⡊⠉⡇⢸⠉⢦⠈⢦⣀⡇⢸⠄⠀⠀⠉⣹⠃⢀⡠⠤⠤⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡾⠃⠀⠀
                                   ⠀⢀⣼⠷⢧⡀⠹⡄⠀⢸⠀⡎⠹⡄⠱⡄⡇⢸⣇⡀⠓⢤⣀⣠⣞⠀⡰⢋⣀⣁⡠⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⠟⠀⠀⠀⠀
                                   ⢰⠟⠁⠀⠀⠙⡄⠘⣄⡸⠀⡇⠀⠙⢤⣈⣠⡾⠉⠈⠉⠒⠊⢀⣀⣉⠜⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⡶⠋⠁⠀⠀⠀⠀⠀
                                   ⣿⠀⣆⡀⠀⠀⠘⠦⣀⣀⣴⠥⠤⠄⠠⠔⠚⠁⡰⠚⠒⠤⠜⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠶⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀
                                   ⢿⡀⡜⠃⠀⢠⠖⠲⠤⠞⡡⠤⣀⣀⡴⠊⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⡴⠞⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                   ⠈⢳⣌⡀⠀⠈⢆⣠⠒⠊⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⡴⠞⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                   ⠀⠀⠈⠙⠛⢲⣏⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⠴⠞⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                   ⠀⠀⠀⠀⠀⠀⠈⠙⣷⣤⣀⣀⣀⣀⣀⣀⣀⣠⣤⠴⠶⠚⠋⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                    ====================================================================================
                    Welcome to Jenver's Hot Dog Cart Online, home of the best hot dogs in Seattle!
                        1) New Order
                        0) Exit
                    Select an option:
                    ====================================================================================""";
            System.out.println(options);
            // user input for the choices
            String choice = scanner.nextLine();
            // if user enters 1 display home screen, if user enters 0 stop running program
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
                    break;
            }
        }
    }
}
