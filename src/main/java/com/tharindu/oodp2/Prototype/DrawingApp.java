package com.tharindu.oodp2.Prototype;

interface Shape{
    Shape clone();
    void draw();
}

class Circle implements Shape {
    private final String color;

    public Circle(String color) {
        this.color = color;
        System.out.println("Circle created with color: " + color);
    }

    @Override
    public Shape clone() {
        return new Circle(color);
    }

    @Override
    public void draw() {
        System.out.println("Draw Circle with color: " + color);
    }
}

class ShapeClient{
    private final Shape prototype;

    public ShapeClient(Shape prototype) {
        this.prototype = prototype;
    }

    public Shape createShape() {
        return prototype.clone();
    }

}

public class DrawingApp {
    public static void main(String[] args) {
        Shape circlePrototype1 = new Circle("Red");
        ShapeClient shapeClient1 = new ShapeClient(circlePrototype1);

        Shape circlePrototype2 = new Circle("Blue");
        ShapeClient shapeClient2 = new ShapeClient(circlePrototype2);

        Shape circlePrototype3 = new Circle("Green");
        ShapeClient shapeClient3 = new ShapeClient(circlePrototype3);

        // Separating the output for clarity
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Creating shapes using prototype pattern...");
        Shape circle1 = shapeClient1.createShape();
        Shape circle2 = shapeClient2.createShape();
        Shape circle3 = shapeClient3.createShape();

        circle1.draw();
        circle2.draw();
        circle3.draw();
    }
}
