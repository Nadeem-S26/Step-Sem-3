package Week_6.Lab;
class Instrument {
    protected String name;
    protected String material;
    public Instrument(String name, String material) {
        this.name = name;
        this.material = material;
        System.out.println("Instrument constructor called");
    }
    public void play() {
        System.out.println(name + " made of " + material + " is playing.");
    }
}
class Piano extends Instrument {
    private int keys;
    public Piano(String name, String material, int keys) {
        super(name, material);
        this.keys = keys;
        System.out.println("Piano constructor called");
    }
    @Override
    public void play() {
        System.out.println(name + " with " + keys + " keys is playing a melody.");
    }
}
class Guitar extends Instrument {
    private int strings;
    public Guitar(String name, String material, int strings) {
        super(name, material);
        this.strings = strings;
        System.out.println("Guitar constructor called");
    }
    @Override
    public void play() {
        System.out.println(name + " with " + strings + " strings is strumming chords.");
    }
}
class Drum extends Instrument {
    private String type;
    public Drum(String name, String material, String type) {
        super(name, material);
        this.type = type;
        System.out.println("Drum constructor called");
    }
    @Override
    public void play() {
        System.out.println(name + " (" + type + ") is beating rhythmically.");
    }
}
public class HierarchicalInheritance {
    public static void main(String[] args) {
        Instrument[] instruments = {
            new Piano("Grand Piano", "Wood", 88),
            new Guitar("Acoustic Guitar", "Maple", 6),
            new Drum("Bass Drum", "Metal", "Percussion")
        };
        System.out.println("\nTesting polymorphic play behavior:");
        for (Instrument inst : instruments) {
            inst.play();
        }
    }
}