package com.tharindu.oodp2.Decorator;

class Coffee {
    public double cost() {
        return 100;
    }

    public String description() {
        return "Simple Coffee";
    }
}

class MilkCoffee extends Coffee {
    @Override
    public double cost() {
        return super.cost() + 220;
    }

    @Override
    public String description() {
        return super.description() + " with Milk";
    }
}

class AddSugar extends MilkCoffee {
    @Override
    public double cost() {
        return super.cost() + 50;
    }

    @Override
    public String description() {
        return super.description() + " Sugar Added";
    }
}

class ChocolateCoffee extends Coffee {
    @Override
    public double cost() {
        return super.cost() + 350;
    }

    @Override
    public String description() {
        return super.description() + " with Chocolate";
    }
}

public class Coffee_shop {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        System.out.println("Rs." + coffee.cost() + " For " + coffee.description());

        MilkCoffee milk = new MilkCoffee();
        System.out.println("Rs." + milk.cost() + " For " + milk.description());

        AddSugar addSugar = new AddSugar();
        System.out.println("Rs." + addSugar.cost() + " For " + addSugar.description());

        ChocolateCoffee chocolate = new ChocolateCoffee();
        System.out.println("Rs." + chocolate.cost() + " For " + chocolate.description());
    }
}
