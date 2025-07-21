package com.tharindu.oodp1.Singleton;

class PrinterSpooler {

    // Step 1: Create a private static instance
    private static PrinterSpooler instance;

    // Step 2: Make the constructor private so no one can instantiate from outside
    private PrinterSpooler() {
        System.out.println("Printer Spooler Initialized");
    }

    // Step 3: Provide a public method to get the instance
    public static PrinterSpooler getInstance() {
        if (instance == null) {
            instance = new PrinterSpooler();
        }
        return instance;
    }

    // Print job simulation
    public void print(String document) {
        System.out.println("Printing: " + document);
    }
}

public class OfficeSingleton {
    public static void main(String[] args) {
        PrinterSpooler spooler1 = PrinterSpooler.getInstance();
        spooler1.print("Employee Report.pdf");

        PrinterSpooler spooler2 = PrinterSpooler.getInstance();
        spooler2.print("Annual Budget.xlsx");

        System.out.println(spooler1 == spooler2); // true, both are the same instance
    }
}
