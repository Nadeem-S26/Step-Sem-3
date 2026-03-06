package Week_6.Lab;
class Bird {
    public void fly() {
        System.out.println("Bird is flying...");
    }
}
class Penguin extends Bird {
    @Override
    public void fly() {
        System.out.println("Penguins can't fly, they swim!");
    }
}
class Eagle extends Bird {
    @Override
    public void fly() {
        System.out.println("Eagle soars high in the sky!");
    }
}
public class OverrideDemo {
    public static void main(String[] args) {
        Bird[] birds = { new Bird(), new Penguin(), new Eagle() };
        System.out.println("Testing polymorphic fly behavior:");
        for (Bird b : birds) {
            b.fly();
        }
    }
}