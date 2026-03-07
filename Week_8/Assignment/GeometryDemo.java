package Week_8.Assignment;
abstract class Shape {
    public abstract double area();
    public abstract double perimeter();
    public void displayInfo() {
        System.out.println("Area: " + area());
        System.out.println("Perimeter: " + perimeter());
    }
}
class Circle extends Shape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
class Rectangle extends Shape {
    private double length;
    private double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    @Override
    public double area() {
        return length * width;
    }
    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}
public class GeometryDemo {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        System.out.println("Circle:");
        circle.displayInfo();
        Shape rectangle = new Rectangle(4.0, 6.0);
        System.out.println("\nRectangle:");
        rectangle.displayInfo();
    }
}