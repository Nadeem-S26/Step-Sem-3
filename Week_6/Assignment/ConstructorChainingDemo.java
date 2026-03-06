package Week_6.Assignment;
class Light {
    private String type;
    private int brightness;
    public Light() {
        this("Incandescent");
        System.out.println("Light(): Default constructor called");
    }
    public Light(String type) {
        this(type, 100);
        System.out.println("Light(String): Constructor with type called");
    }
    public Light(String type, int brightness) {
        this.type = type;
        this.brightness = brightness;
        System.out.println("Light(String, int): Constructor with type and brightness called");
    }
}
class LED extends Light {
    private String color;
    public LED() {
        this("White");
        System.out.println("LED(): Default constructor called");
    }
    public LED(String color) {
        super("LED", 200);
        this.color = color;
        System.out.println("LED(String): Constructor with color called");
    }
    public LED(String color, int brightness) {
        super("LED", brightness);
        this.color = color;
        System.out.println("LED(String, int): Constructor with color and brightness called");
    }
}
@SuppressWarnings("all")
public class ConstructorChainingDemo {
    public static void main(String[] args) {
        System.out.println("Creating Light object:");
        Light light = new Light();
        System.out.println("\nCreating LED object:");
        LED led = new LED();
        System.out.println("\nCreating LED object with color and brightness:");
        LED customLed = new LED("Blue", 300);
    }
}