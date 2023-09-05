package se.fabricioflores.labtwo;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Shape circle1 = Shape.createShape(25);
        Shape circle2 = Shape.createShape(12);
        Shape rectangle1= Shape.createShape(5, 2.2);
        Shape rectangle2 = Shape.createShape(10, 3.2);
        Shape rectangle3 = Shape.createShape(10, 3.2);

        List<Shape> shapes = new ArrayList<>();

        shapes.add(circle1);
        shapes.add(circle2);
        shapes.add(rectangle1);
        shapes.add(rectangle2);

        shapes.sort(null); // Listan sorteras baserad på våran comparable

        System.out.println("\n📐 Shape list sorted by area\n");
        for (Shape shape: shapes) {
            System.out.println(shapes.indexOf(shape) + ") " + shape.getArea());
        }

        Set<Shape> shapeSet = new HashSet<>();
        shapeSet.add(circle1);
        shapeSet.add(rectangle2);
        shapeSet.add(rectangle3); // Kommer inte läggas till för det är en kopia av rectangle2

        System.out.println("\n📐 Shape list with unique shapes\n");

        for(Shape shape : shapeSet) {
            System.out.println("- " + shape.getArea());
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

    //    Metoden compareTo returnerar en int
    //    Negativt tal om det aktuella objektets area är mindre än otherShape.
    //    Positivt tal om det aktuella objektets area är större än otherShape.
    //    Noll om båda objekts area är lika.
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

    // Equals & Hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(width, rectangle.width) == 0 && Double.compare(height, rectangle.height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
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

    // Equals & Hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(radius, circle.radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}