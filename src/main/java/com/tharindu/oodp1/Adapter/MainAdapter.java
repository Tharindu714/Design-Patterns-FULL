package com.tharindu.oodp1.Adapter;

interface EuropeanSocket { // Target Interface
    void providePower();
}

class USCharger { // Adaptee - Incompatible Interface
    public void givePower() {
        System.out.println("Power supplied using US standard plug.");
    }
}

class PlugAdapter implements EuropeanSocket { // Adapter Class

    private final USCharger usCharger;

    public PlugAdapter(USCharger usCharger) {
        this.usCharger = usCharger;
    }

    @Override
    public void providePower() {
        System.out.println("Adapting plug...");
        usCharger.givePower();  // Delegates to USCharger
    }
}

class Phone { // Client Class
    private final EuropeanSocket socket;

    public Phone(EuropeanSocket socket) {
        this.socket = socket;
    }

    public void charge() {
        System.out.println("Phone starts charging...");
        socket.providePower();
    }
}


public class MainAdapter {
    public static void main(String[] args) {
        USCharger usCharger = new USCharger();
        EuropeanSocket adapter = new PlugAdapter(usCharger);

        Phone phone = new Phone(adapter);
        phone.charge();
    }
}
