package SOLID;

// Step 1: Make Shape abstract and responsible for its own area
public abstract class Shape {
    public abstract double getArea();
}

// Step 2: Implement shapes with their own area logic
public class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }
}

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// Step 3: AreaCalculator is closed for modification, open for extension
public class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.getArea();
    }
}
