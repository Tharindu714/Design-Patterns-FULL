package com.tharindu.oodp2.Flyweight.Basic;

class ForestSim {
    public static void main(String[] args) {
        Forest forest = new Forest();
        for (int i = 0; i < 10; i++) {
            forest.plantTree("Oak", "Green", "Rough", getRandomX(), getRandomY());
        }
        for (int i = 0; i < 5; i++) {
            forest.plantTree("Pine", "Dark Green", "Needle-like", getRandomX(), getRandomY());
        }
        for (int i = 0; i < 3; i++) {
            forest.plantTree("Birch", "White", "Smooth", getRandomX(), getRandomY());
        }
        forest.drawForest();
    }
    private static int getRandomX() {
        return (int) (Math.random() * 10);
    }

    private static int getRandomY() {
        return (int) (Math.random() * 10);
    }
}
/*
Rendering Oak at (10, 20) with color Green and texture Rough
Rendering Oak at (10, 20) with color Green and texture Rough
Rendering Oak at (10, 20) with color Green and texture Rough
Rendering Oak at (10, 20) with color Green and texture Rough
Rendering Oak at (10, 20) with color Green and texture Rough
Rendering Oak at (10, 20) with color Green and texture Rough
Rendering Oak at (10, 20) with color Green and texture Rough
Rendering Oak at (10, 20) with color Green and texture Rough
Rendering Oak at (10, 20) with color Green and texture Rough
Rendering Oak at (10, 20) with color Green and texture Rough
Rendering Pine at (30, 40) with color Dark Green and texture Needle-like
Rendering Pine at (30, 40) with color Dark Green and texture Needle-like
Rendering Pine at (30, 40) with color Dark Green and texture Needle-like
Rendering Pine at (30, 40) with color Dark Green and texture Needle-like
Rendering Pine at (30, 40) with color Dark Green and texture Needle-like
Rendering Birch at (50, 60) with color White and texture Smooth
Rendering Birch at (50, 60) with color White and texture Smooth
Rendering Birch at (50, 60) with color White and texture Smooth
Drawing forest with 18 trees:
/*
 * This code simulates a forest with different types of trees using the Flyweight pattern.
 * It creates multiple instances of trees with shared properties to save memory.
 * The `Forest` class manages the collection of trees and provides methods to plant and render them.
 */
