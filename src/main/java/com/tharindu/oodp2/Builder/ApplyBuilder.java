package com.tharindu.oodp2.Builder;

class Meal {
    private final String burger;
    private final String drink;
    private final String fries;
    private final String dessert;

    public Meal(ApplyBuilder builder) {
        this.burger = builder.burger;
        this.drink = builder.drink;
        this.fries = builder.fries;
        this.dessert = builder.dessert;
    }

    public void display() {
        System.out.println("Meal Order Summary:");
        System.out.println("\uD83C\uDF54: " + burger);
        System.out.println("\uD83E\uDD64: " + drink);
        if (fries != null) {
            System.out.println("\uD83C\uDF5F: " + fries);
        }
        if (dessert != null) {
            System.out.println("\uD83E\uDD57: " + dessert);
        }
    }

}

@SuppressWarnings("ClassEscapesDefinedScope")
public class ApplyBuilder {
    String burger;
    String drink;
    String fries;
    String dessert;

    public ApplyBuilder setBurger(String burger) {
        this.burger = burger;
        return this;
    }

    public ApplyBuilder setDrink(String drink) {
        this.drink = drink;
        return this;
    }

    public ApplyBuilder setFries(String fries) {
        this.fries = fries;
        return this;
    }

    public ApplyBuilder setDessert(String dessert) {
        this.dessert = dessert;
        return this;
    }

    public Meal build() {
        return new Meal(this);
    }

    public static void main(String[] args) {
        Meal meal = new ApplyBuilder()
                .setBurger("Cheeseburger")
                .setDrink("Coke")
                .setFries("French Fries")
                .setDessert("Fruit Salad")
                .build();

        meal.display();
    }
}

// Output:
// Meal Order Summary:
// 🍔: Cheeseburger
// 🥤: Coke
// 🍟: French Fries
// 🍨: Fruit Salad