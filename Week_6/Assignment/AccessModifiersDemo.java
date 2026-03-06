package Week_6.Assignment;
class Tool {
    private String name = "Generic Tool"; 
    protected String material = "Steel";       
    public int weight = 5;
    public String getName() {
        return name;
    }
}
class Hammer extends Tool {
    public void displayInfo() {
        System.out.println("Name (via getter): " + getName());
        System.out.println("Material: " + material);
        System.out.println("Weight: " + weight); 
    }
}
public class AccessModifiersDemo {
    public static void main(String[] args) {
        Hammer hammer = new Hammer();
        hammer.displayInfo();
    }
}