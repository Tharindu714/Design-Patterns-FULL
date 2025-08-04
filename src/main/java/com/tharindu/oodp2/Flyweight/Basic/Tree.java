package com.tharindu.oodp2.Flyweight.Basic;

public class Tree {
    private final String name, color, texture;
    private final int x, y;

    public Tree(String name, String color, String texture, int x, int y) {
        this.name = name;
        this.color = color;
        this.texture = texture;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getTexture() {
        return texture;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void render() {
        System.out.println("Rendering " + getName() + " at (" + getX() + ", " + getY() + ") with color " + getColor() + " and texture " + getTexture());
    }
}
