package Week_6.Lab;
class Box {
    public void pack() {
        System.out.println("Packing the box with standard materials.");
    }
    public void unpack() {
        System.out.println("Unpacking the box carefully.");
    }
}
class GiftBox extends Box {
    @Override
    public void pack() {
        super.pack();
        System.out.println("Adding ribbons and wrapping paper for the gift.");
    }
    @Override
    public void unpack() {
        super.unpack(); 
        System.out.println("Removing decorative elements before opening the gift.");
    }
}
public class SuperInOverriddenMethod {
    public static void main(String[] args) {
        System.out.println("Creating GiftBox object...");
        GiftBox myGift = new GiftBox();
        System.out.println("\nPacking process:");
        myGift.pack();
        System.out.println("\nUnpacking process:");
        myGift.unpack();
    }
}