package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {
    public static void saveReceipt(Order order) {
        DateTimeFormatter timeStamp = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        DateTimeFormatter displayTime = DateTimeFormatter.ofPattern("'Date: ' yyyy-MM-dd | 'Time: ' HH:mm:ss");
        String time = LocalDateTime.now().format(timeStamp);
        String fileName = "src/main/java/com/pluralsight/Receipts/" + time + ".txt";

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write("HOT DOG RECEIPT\n");
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
