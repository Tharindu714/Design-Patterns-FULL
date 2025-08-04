package com.tharindu.oodp2.Flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface DrawableTree {
    void draw(int x, int y);
}

class TreeType implements DrawableTree {
    private final String name;
    private final String color;
    private final String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing " + name + " at (" + x + ", " + y + ") with color " + color + " and texture " + texture);
    }
}

class TreeFactory {
    private static final Map<String, DrawableTree> treeTypes = new HashMap<>();

    public static DrawableTree getTreeType(String name, String color, String texture) {
        String key = name + " " + color + " " + texture;
        if (!treeTypes.containsKey(key)) {
            treeTypes.put(key, new TreeType(name, color, texture));
        }
        return treeTypes.get(key);
    }

    public static int getTotalUniqueTreeTypes() {
        return treeTypes.size();
    }
}

class Tree {
    private final DrawableTree treeType;
    private final int x;
    private final int y;

    public Tree(DrawableTree treeType, int x, int y) {
        this.treeType = treeType;
        this.x = x;
        this.y = y;
    }

    public void draw() {
        treeType.draw(x, y);
    }
}

class Forest {
    final List<Tree> trees = new ArrayList<>();

    public void plantTree(String name, String color, String texture, int x, int y) {
        DrawableTree tree = TreeFactory.getTreeType(name, color, texture);
        Tree newTree = new Tree(tree, x, y);
        trees.add(newTree);
        System.out.println("Planted a " + name + " tree at (" + x + ", " + y + ")");
        System.out.println("Total unique tree types: " + TreeFactory.getTotalUniqueTreeTypes());
    }

    public void drawForest() {
        for (Tree tree : trees) {
            tree.draw();
        }
    }

    public int getTotalUniqueTreeTypes() {
        return TreeFactory.getTotalUniqueTreeTypes();
    }
}

public class Flyweight_main {
    public static void main(String[] args) {
        Forest forest = new Forest();
        for(int i = 0; i < 100; i++) {
            String treeName = "Oak";
            String treeColor = "Green";
            String treeTexture = "Rough";
            int x = getRandomX();
            int y = getRandomY();
            forest.plantTree(treeName, treeColor, treeTexture, x, y);
        }
        for(int i = 0; i < 78; i++) {
            String treeName = "Pine";
            String treeColor = "Dark Green";
            String treeTexture = "Smooth";
            int x = getRandomX();
            int y = getRandomY();
            forest.plantTree(treeName, treeColor, treeTexture, x, y);
        }
        for(int i = 0; i < 20; i++) {
            String treeName = "Birch";
            String treeColor = "White";
            String treeTexture = "Bark";
            int x = getRandomX();
            int y = getRandomY();
            forest.plantTree(treeName, treeColor, treeTexture, x, y);
        }
        System.out.println("Drawing the forest:");
        forest.drawForest();
        System.out.println("Total unique tree types in the forest: " + forest.getTotalUniqueTreeTypes());
    }



    public static int getRandomX() {
        return (int) (Math.random() * 100);
    }

    public static int getRandomY() {
        return (int) (Math.random() * 100);
    }
}
