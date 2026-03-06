package Week_6.Lab;
class Color {
    protected String name;
    public Color(String name) {
        this.name = name;
        System.out.println("Color constructor called");
    }
    public void displayColor() {
        System.out.println("Color Name: " + name);
    }
}
class PrimaryColor extends Color {
    protected int intensity;
    public PrimaryColor(String name, int intensity) {
        super(name);
        this.intensity = intensity;
        System.out.println("PrimaryColor constructor called");
    }
    public void displayPrimaryColor() {
        displayColor();
        System.out.println("Intensity: " + intensity);
    }
}
class RedColor extends PrimaryColor {
    private String shade;
    public RedColor(String name, int intensity, String shade) {
        super(name, intensity); 
        this.shade = shade;
        System.out.println("RedColor constructor called");
    }
     public void displayRedColor() {
        displayPrimaryColor();
        System.out.println("Shade: " + shade);
    }
}
public class MultilevelInheritanceDemo {
    public static void main(String[] args) {
        System.out.println("Creating RedColor object...");
        RedColor red = new RedColor("Red", 85, "Crimson");
        red.displayRedColor();
    }
}