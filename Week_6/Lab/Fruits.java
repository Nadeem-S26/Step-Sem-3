package Week_6.Lab;
class Fruit {
    protected String color;
    protected String taste;
    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }
    public void displayFruitDetails() {
        System.out.println("Color: " + color);
        System.out.println("Taste: " + taste);
    }
}
class Apple extends Fruit {
    private String variety;
    public Apple(String color, String taste, String variety) {
        super(color, taste); // Call parent constructor
        this.variety = variety;
    }
    public void displayAppleDetails() {
        displayFruitDetails();
        System.out.println("Variety: " + variety);
    }
}
public class Fruits {
    public static void main(String[] args) {
        Apple myApple = new Apple("Red", "Sweet", "Fuji");
        myApple.displayAppleDetails();
    }
}