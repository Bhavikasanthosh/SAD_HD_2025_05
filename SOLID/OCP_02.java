package SOLID;

// Step 1: Make Shape abstract with an area method
public abstract class Shape {
    public abstract double getArea();
}

// Step 2: Implement concrete shapes
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

// Step 3: Calculator now works for any shape without modification
public class AreaCalculator {
    public double getArea(Shape shape) {
        return shape.getArea();
    }
}
