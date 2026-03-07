package Week_8.Lab;
abstract class Fruit {
    protected String color;
    protected String taste;
    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }
    public abstract void showDetails();
}
interface Edible {
    void nutrientsInfo();
}
class Apple extends Fruit implements Edible {
    private String variety;
    public Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }
    @Override
    public void showDetails() {
        System.out.println("Apple Variety: " + variety);
        System.out.println("Color: " + color);
        System.out.println("Taste: " + taste);
    }
    @Override
    public void nutrientsInfo() {
        System.out.println("Rich in fiber, vitamin C, and antioxidants.");
    }
}
public class FruitDemo {
    public static void main(String[] args) {
        Apple myApple = new Apple("Red", "Sweet", "Fuji");
        myApple.showDetails();
        myApple.nutrientsInfo();
    }
}