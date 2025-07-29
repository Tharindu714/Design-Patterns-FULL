package com.tharindu.oodp2.Builder;

public class WithoutBuilder {
    private final String burger;
    private final String drink;
    private String fries;
    private String dessert;

    public WithoutBuilder(String burger, String drink) {
        this.burger = burger;
        this.drink = drink;
    }

    public WithoutBuilder(String burger, String drink, String fries) {
        this.burger = burger;
        this.drink = drink;
        this.fries = fries;
    }

    public WithoutBuilder(String burger, String drink, String fries, String dessert) {
        this.burger = burger;
        this.drink = drink;
        this.fries = fries;
        this.dessert = dessert;
    }

    public void displayOrder() {
        System.out.println("Order Summary:");
        System.out.println("Burger: " + burger);
        System.out.println("Drink: " + drink);
        if (fries != null) {
            System.out.println("Fries: " + fries);
        }
        if (dessert != null) {
            System.out.println("Dessert: " + dessert);
        }
    }

    public static void main(String[] args) {
        WithoutBuilder meal = new WithoutBuilder("Cheeseburger", "Coke");
        meal.displayOrder();

        WithoutBuilder mealWithFries = new WithoutBuilder("Veggie Burger", "Lemonade", "Curly Fries");
        mealWithFries.displayOrder();

        WithoutBuilder fullMeal = new WithoutBuilder("Double Cheeseburger", "Iced Tea", "Sweet Potato Fries", "Chocolate Cake");
        fullMeal.displayOrder();
    }
}
