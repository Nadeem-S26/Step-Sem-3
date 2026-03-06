package Week_7.Practice;
class Shape { 
    public String name; 
    public Shape(String name) { 
        this.name = name; 
        System.out.println("Shape constructor: " + name); 
    } 
    public void draw() { 
        System.out.println("Drawing a generic shape"); 
    } 
}  
class Circle extends Shape { 
    public double radius; 
    public Circle(double radius) { 
        super("Circle"); 
        this.radius = radius; 
        System.out.println("Circle constructor: radius = " + radius); 
    } 
    @Override 
    public void draw() { 
        System.out.println("Drawing a circle with radius " + radius); 
    } 
}
class Rectangle extends Shape { 
    public double width, height; 
    public Rectangle(double w, double h) { 
        super("Rectangle"); 
        this.width = w; 
        this.height = h; 
        System.out.println("Rectangle constructor: " + w + " x " + h); 
    } 
    @Override 
    public void draw() { 
        System.out.println("Drawing a rectangle " + width + "x" + height); 
    } 
} 
 
public class PolymorphismDemo { 
    public static void main(String[] args) {
        Shape s1 = new Circle(5.0); 
        Shape s2 = new Rectangle(3.0, 4.0); 
        Shape s3 = new Shape("Generic");
        s1.draw();
        s2.draw(); 
        s3.draw();
        Shape[] shapes = { s1, s2, s3 }; 
        for (Shape s : shapes) { 
            s.draw(); 
        } 
    } 
} 