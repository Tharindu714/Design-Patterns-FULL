package com.tharindu.oodp2.Bridge;

interface Device {
    void on();

    void off();

    boolean isEnabled();
}

class Tv implements Device {
    private boolean on = false;

    @Override
    public void on() {
        on = true;
        System.out.println("Tv on");
    }

    @Override
    public void off() {
        on = false;
        System.out.println("Tv off");
    }

    @Override
    public boolean isEnabled() {
        return on;
    }
}

class Player implements Device {
    private boolean on = false;

    @Override
    public void on() {
        on = true;
        System.out.println("Player on");
    }

    @Override
    public void off() {
        on = false;
        System.out.println("Player off");
    }

    @Override
    public boolean isEnabled() {
        return on;
    }
}

//abstraction
abstract class Remote {
    protected Device device;

    public Remote(Device device) {
        this.device = device;
    }

    public abstract void switchPower();
}

class BasicRemote extends Remote {

    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    public void switchPower() {
        if (device.isEnabled()) {
            device.off();
        } else {
            device.on();
        }
    }
}

public class BridgeMain {
    public static void main(String[] args) {
        Device tv = new Tv();
        Remote tvRemote = new BasicRemote(tv);
        tvRemote.switchPower();
        tvRemote.switchPower();

        Device player = new Player();
        Remote playerRemote = new BasicRemote(player);
        playerRemote.switchPower();
        playerRemote.switchPower();

    }
}