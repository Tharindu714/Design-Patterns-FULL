package com.tharindu.oodp2.Decorator;

interface CoffeeInterface {
    double cost();

    String description();
}

class SimpleCoffee implements CoffeeInterface {
    @Override
    public double cost() {
        return 200;
    }

    @Override
    public String description() {
        return "Simple Coffee";
    }
}

abstract class CoffeeDecorator implements CoffeeInterface {
    protected CoffeeInterface coffee;

    public CoffeeDecorator(CoffeeInterface coffee) {
        this.coffee = coffee;
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(CoffeeInterface coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return coffee.cost() + 100;
    }

    @Override
    public String description() {
        return coffee.description() + " with Milk";
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(CoffeeInterface coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return coffee.cost() + 50;
    }

    @Override
    public String description() {
        return coffee.description() + " Extra Sugar Added";
    }
}

class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(CoffeeInterface coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return coffee.cost() + 325.50;
    }

    @Override
    public String description() {
        return coffee.description() + " With Whipped cream";
    }
}

public class ApplyDecorator {
    public static void main(String[] args) {
        CoffeeInterface coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        CoffeeInterface coffee2 = new SimpleCoffee();
        coffee2 = new WhippedCreamDecorator(coffee2);

        System.out.println("Coffee: " + coffee.description() + " for Rs." + coffee.cost());
        System.out.println("Coffee: " + coffee2.description() + " for Rs." + coffee2.cost());
    }
}
