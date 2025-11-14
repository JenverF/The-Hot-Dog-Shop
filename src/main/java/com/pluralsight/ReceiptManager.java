package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {
    // save receipt to a new file in the Receipts folder
    public static void saveReceipt(Order order) {
        DateTimeFormatter timeStamp = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss"); // format the file name to the local date and time
        DateTimeFormatter displayTime = DateTimeFormatter.ofPattern("'Date: ' yyyy-MM-dd | 'Time: ' HH:mm:ss"); // shows the current date and time in customer's receipt
        String time = LocalDateTime.now().format(timeStamp); // gets the current local date and time
        String fileName = "src/main/java/com/pluralsight/Receipts/" + time + ".txt"; // saves the receipt in Receipts folder

        // formats the receipt and returns the customer's order and total
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write("========= HOT DOG RECEIPT =========\n");
            bw.write(LocalDateTime.now().format(displayTime) + "\n");
            bw.write("===================================\n");
            bw.write(order.displayOrder());
            bw.write("\nTOTAL: $" + String.format("%.2f", order.getTotal()) + "\n");
            bw.write("===================================\n");
            bw.close();

        } catch (IOException e) {
            System.out.println("Could not save receipt. " + e.getMessage());
        }
    }
}
