package com.tharindu.oodp1.Adapter;

interface SDCard {
    void readSDCard();
}

interface MicroSDCard {
    void readMicroSDCard();
}

class SonySD implements SDCard {
    @Override
    public void readSDCard() {
        System.out.println("Reading data from Sony SD Card \uD83D\uDCBE");
    }
}

class SamsungMicroSD implements MicroSDCard {
    @Override
    public void readMicroSDCard() {
        System.out.println("Reading data from Samsung Micro SD Card \uD83D\uDDC3️");
    }
}

class Adapter implements SDCard {
    private final MicroSDCard microSDCard;

    public Adapter(MicroSDCard microSDCard) {
        this.microSDCard = microSDCard;
    }

    @Override
    public void readSDCard() {
        System.out.println("\uD83D\uDCBD Converting Micro SD Card to SD Card format...");
        this.microSDCard.readMicroSDCard();
    }
}

class Laptop {
    private SDCard sdCard;

    public void setSdCard(SDCard sdCard) {
        this.sdCard = sdCard;
    }

    public void ViewFile() {
        this.sdCard.readSDCard();
    }
}

public class LaptopAdapter {
    public static void main(String[] args) {

        Laptop laptop = new Laptop();
        SonySD sonySD = new SonySD();
        laptop.setSdCard(sonySD);
        laptop.ViewFile(); // Reading data from Sony SD Card 📾

        SamsungMicroSD microSD = new SamsungMicroSD();
        laptop.setSdCard(new Adapter(microSD));

        Adapter adapter = new Adapter(microSD);
        laptop.setSdCard(adapter);
        laptop.ViewFile(); // Reading data from Samsung Micro SD Card 📃
    }
}
