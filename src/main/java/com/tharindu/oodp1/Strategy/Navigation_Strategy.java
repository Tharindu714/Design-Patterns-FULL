package com.tharindu.oodp1.Strategy;

interface NavigationStrategy {
    void route(double distance);
}

class Fastest_route implements NavigationStrategy {
    public void route(double fast_distance) {
        System.out.println("Fastest route: " + fast_distance + " to reach");
    }
}

class Shortest_route implements NavigationStrategy {
    public void route(double Short_distance) {
        System.out.println("Shortest route: " + Short_distance + " to reach");
    }
}

class AvoidTolls_route implements NavigationStrategy {
    public void route(double distance) {
        System.out.println("Avoid tolls route: " + distance + " to reach");
    }
}

class NavigationSystem {
    private NavigationStrategy strategy;

    public void setStrategy(NavigationStrategy strategy) {
        this.strategy = strategy;
    }

    public void go(double distance) {
        strategy.route(distance);
    }
}

public class Navigation_Strategy {
    public static void main(String[] args) {
        NavigationSystem navigationSystem = new NavigationSystem();

        navigationSystem.setStrategy(new Fastest_route());
        navigationSystem.go(241.45);

        navigationSystem.setStrategy(new Shortest_route());
        navigationSystem.go(100.40);

        navigationSystem.setStrategy(new AvoidTolls_route());
        navigationSystem.go(140.34);
    }
}
