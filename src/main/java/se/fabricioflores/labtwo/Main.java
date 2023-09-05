package se.fabricioflores.labtwo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shape circle1 = Shape.createShape(25);
        Shape circle2 = Shape.createShape(12);
        Shape rectangle1= Shape.createShape(5, 2.2);
        Shape rectangle2 = Shape.createShape(10, 3.2);

        List<Shape> shapes = new ArrayList<>();

        shapes.add(circle1);
        shapes.add(circle2);
        shapes.add(rectangle1);
        shapes.add(rectangle2);

        shapes.sort(null);

        System.out.println("\n📐 Shape list sorted by area\n");
        for (Shape shape: shapes) {
            System.out.println(shapes.indexOf(shape) + ") " + shape.getArea());
        }
    }
}

abstract class Shape implements Comparable<Shape> {
    public abstract double getArea();

    public abstract double getPerimeter();

    public static Rectangle createShape(double width, double height) {
        return new Rectangle(width, height);
    }

    public static Circle createShape(double radius) {
        return new Circle(radius);
    }

    @Override
    public int compareTo(Shape otherShape) {
        return Double.compare(this.getArea(), otherShape.getArea());
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * (radius * radius);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}