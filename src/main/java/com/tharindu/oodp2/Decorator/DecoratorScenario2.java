package com.tharindu.oodp2.Decorator;

import java.util.LinkedHashMap;
import java.util.Map;

// (Your existing interface and decorator classes go here unchanged)

interface Beverages {
    String getDescription();

    double getPrice();
}

class CoffeeBeverage implements Beverages {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getPrice() {
        return 350;
    }
}

class TeaBeverage implements Beverages {
    @Override
    public String getDescription() {
        return "Simple Tea";
    }

    @Override
    public double getPrice() {
        return 200;
    }
}

abstract class BeverageDecorator implements Beverages {
    protected Beverages beverage;

    public BeverageDecorator(Beverages beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }

    @Override
    public double getPrice() {
        return beverage.getPrice();
    }
}

class MilkBeverageDecorator extends BeverageDecorator {
    public MilkBeverageDecorator(Beverages beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Milk";
    }

    @Override
    public double getPrice() {
        return beverage.getPrice() + 150.75;
    }
}

class SugarBeverageDecorator extends BeverageDecorator {
    public SugarBeverageDecorator(Beverages beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Sugar";
    }

    @Override
    public double getPrice() {
        return beverage.getPrice() + 50.25;
    }
}

class ChocolateBeverageDecorator extends BeverageDecorator {
    public ChocolateBeverageDecorator(Beverages beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Chocolate";
    }

    @Override
    public double getPrice() {
        return beverage.getPrice() + 200.50;
    }
}

class WhipCreamBeverageDecorator extends BeverageDecorator {
    public WhipCreamBeverageDecorator(Beverages beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Whip Cream";
    }

    @Override
    public double getPrice() {
        return beverage.getPrice() + 100.00;
    }
}

// Updated main to print the visual menu
public class DecoratorScenario2 {
    public static void main(String[] args) {
        // Build signature combos
        Map<String, Beverages> combos = new LinkedHashMap<>();
        combos.put("1. Mocha Magic ☕+🥛+🍫",
                new ChocolateBeverageDecorator(
                        new MilkBeverageDecorator(
                                new CoffeeBeverage()
                        )
                )
        );
        combos.put("2. Sweet Latte ☕+🥛+🍬+🍦",
                new WhipCreamBeverageDecorator(
                        new SugarBeverageDecorator(
                                new MilkBeverageDecorator(
                                        new CoffeeBeverage()
                                )
                        )
                )
        );
        combos.put("3. Deluxe Coffee ☕+🥛+🍬+🍫+🍦",
                new WhipCreamBeverageDecorator(
                        new ChocolateBeverageDecorator(
                                new SugarBeverageDecorator(
                                        new MilkBeverageDecorator(
                                                new CoffeeBeverage()
                                        )
                                )
                        )
                )
        );
        combos.put("4. Choco‑Whip Delight ☕+🍫+🍦",
                new WhipCreamBeverageDecorator(
                        new ChocolateBeverageDecorator(
                                new CoffeeBeverage()
                        )
                )
        );

        Map<String, Beverages> teaTwists = new LinkedHashMap<>();
        teaTwists.put("1. Masala Tea 🍵+🥛+🍬",
                new SugarBeverageDecorator(
                        new MilkBeverageDecorator(
                                new TeaBeverage()
                        )
                )
        );
        teaTwists.put("2. Choco Tea 🍵+🍫",
                new ChocolateBeverageDecorator(
                        new TeaBeverage()
                )
        );
        teaTwists.put("3. Whipped Choco Tea 🍵+🍫+🍦",
                new WhipCreamBeverageDecorator(
                        new ChocolateBeverageDecorator(
                                new TeaBeverage()
                        )
                )
        );
        teaTwists.put("4. Deluxe Tea 🍵+🥛+🍬+🍫+🍦",
                new WhipCreamBeverageDecorator(
                        new ChocolateBeverageDecorator(
                                new SugarBeverageDecorator(
                                        new MilkBeverageDecorator(
                                                new TeaBeverage()
                                        )
                                )
                        )
                )
        );

        // Print the menu
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║               ☕  THE ULTIMATE BEVERAGE BAR  🍵       ║");
        System.out.println("╟────────────────────────────────────────────────────────╢");
        System.out.println("║  BASE BEVERAGES                                         ");
        System.out.printf("║  • Simple Coffee .......................... Rs.350  %n");
        System.out.printf("║  • Simple Tea ............................. Rs.200  %n");
        System.out.println("╟────────────────────────────────────────────────────────╢");
        System.out.println("║  ADD‑ONS (decorate your drink!)                          ");
        System.out.printf("║  • Milk ................................. +Rs.150.75 %n");
        System.out.printf("║  • Sugar ................................ +Rs.50.25  %n");
        System.out.printf("║  • Chocolate ............................ +Rs.200.50 %n");
        System.out.printf("║  • Whip Cream ............................+Rs.100.00 %n");
        System.out.println("╟────────────────────────────────────────────────────────╢");
        System.out.println("║  SIGNATURE COMBOS                                       ");
        // print coffee combos
        for (Map.Entry<String, Beverages> e : combos.entrySet()) {
            System.out.printf("║  %-38s Rs.%,7.2f %n", e.getKey(), e.getValue().getPrice());
        }
        System.out.println("╟────────────────────────────────────────────────────────╢");
        System.out.println("║  TEA TWISTS                                              ");
        // print tea combos
        for (Map.Entry<String, Beverages> e : teaTwists.entrySet()) {
            System.out.printf("║  %-38s Rs.%,7.2f %n", e.getKey(), e.getValue().getPrice());
        }
        System.out.println("╟────────────────────────────────────────────────────────╢");
        System.out.println("║  BUILD‑YOUR‑OWN DRINK!                                  ║");
        System.out.println("║  Pick any base + your choice of add‑ons.                ║");
        System.out.println("║  Total price = Base price + sum of add‑on prices.       ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}
