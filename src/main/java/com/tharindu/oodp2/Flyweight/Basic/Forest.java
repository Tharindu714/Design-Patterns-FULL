package com.tharindu.oodp2.Flyweight.Basic;

import java.util.ArrayList;
import java.util.List;

public class Forest {
    private final List<Tree> trees = new ArrayList<>();

    public void plantTree(String name, String color, String texture, int x, int y) {
        Tree tree = new Tree(name, color, texture, x, y);
        trees.add(tree);
    }

    public void drawForest() {
        for (Tree tree : trees) {
            tree.render();
        }
        System.out.println("Drawing forest with " + trees.size() + " trees:");
    }
}
