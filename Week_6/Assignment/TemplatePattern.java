package Week_6.Assignment;
abstract class Food {
    public final void prepare() {
        wash();
        cook();
        serve();
    }
    protected abstract void wash();
    protected abstract void cook();
    protected abstract void serve();
}
class Pizza extends Food {
    @Override
    protected void wash() {
        System.out.println("Washing vegetables and preparing dough for Pizza.");
    }
    @Override
    protected void cook() {
        System.out.println("Baking Pizza in oven at 220°C for 15 minutes.");
    }
    @Override
    protected void serve() {
        System.out.println("Serving hot Pizza with extra cheese.");
    }
}
class Soup extends Food {
    @Override
    protected void wash() {
        System.out.println("Washing vegetables and herbs for Soup.");
    }
    @Override
    protected void cook() {
        System.out.println("Boiling Soup ingredients for 30 minutes.");
    }
    @Override
    protected void serve() {
        System.out.println("Serving Soup in a bowl with breadsticks.");
    }
}
public class TemplatePattern{
    public static void main(String[] args) {
        Food myPizza = new Pizza();
        System.out.println("Preparing Pizza:");
        myPizza.prepare();
        System.out.println("\nPreparing Soup:");
        Food mySoup = new Soup();
        mySoup.prepare();
    }
}