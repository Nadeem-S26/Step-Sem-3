package Week_4.Lab;
import java.util.Random;
import java.util.UUID;
public class VirtualPet {
    private static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder"};
    private static final String[] SPECIES_POOL = {"Dragon", "Unicorn", "Phoenix", "Wolf", "Alien"};
    private static int totalPetsCreated = 0;
    private final String petId;
    private String petName;
    private String species;
    private int age;
    private int happiness;
    private int health;
    private int stageIndex;
    private boolean isGhost;
    public VirtualPet() {
        this("Mystery", getRandomSpecies(), 0, 50, 100, 0);
    }
    public VirtualPet(String petName) {
        this(petName, getRandomSpecies(), 1, 60, 100, 1);
    }
    public VirtualPet(String petName, String species) {
        this(petName, species, 2, 70, 100, 2);
    }
    public VirtualPet(String petName, String species, int age, int happiness, int health, int stageIndex) {
        this.petId = generatePetId();
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.stageIndex = stageIndex;
        this.isGhost = false;
        totalPetsCreated++;
    }
    public static String generatePetId() {
        return "PET-" + UUID.randomUUID().toString().substring(0, 8);
    }
    private static String getRandomSpecies() {
        Random rand = new Random();
        return SPECIES_POOL[rand.nextInt(SPECIES_POOL.length)];
    }
    public void feedPet() {
        if (!isGhost) {
            health = Math.min(health + 10, 100);
            System.out.println(petName + " has been fed. Health: " + health);
        }
    }
    public void playWithPet() {
        if (!isGhost) {
            happiness = Math.min(happiness + 15, 100);
            System.out.println(petName + " played happily! Happiness: " + happiness);
        }
    }
    public void healPet() {
        if (!isGhost) {
            health = Math.min(health + 20, 100);
            System.out.println(petName + " is healed. Health: " + health);
        }
    }
    public void simulateDay() {
        if (!isGhost) {
            age++;
            happiness -= new Random().nextInt(10);
            health -= new Random().nextInt(15);

            if (health <= 0) {
                isGhost = true;
                species = "Ghost";
                System.out.println(petName + " has died and become a Ghost!");
            } else {
                evolvePet();
            }
        } else {
            System.out.println(petName + " haunts the daycare");
        }
    }
    public void evolvePet() {
        if (stageIndex < EVOLUTION_STAGES.length - 1 && age > stageIndex * 2 && happiness > 50 && health > 50) {
            stageIndex++;
            System.out.println(petName + " has evolved into " + EVOLUTION_STAGES[stageIndex] + " stage!");
        }
    }
    public String getPetStatus() {
        return isGhost ? "Ghost" : EVOLUTION_STAGES[stageIndex];
    }
    public void displayPetInfo() {
        System.out.println("Pet ID: " + petId);
        System.out.println("Name: " + petName);
        System.out.println("Species: " + species);
        System.out.println("Age: " + age);
        System.out.println("Happiness: " + happiness);
        System.out.println("Health: " + health);
        System.out.println("Status: " + getPetStatus());
        System.out.println();
    }
    public static int getTotalPetsCreated() {
        return totalPetsCreated;
    }
    public static void main(String[] args) {
        VirtualPet pet1 = new VirtualPet(); 
        VirtualPet pet2 = new VirtualPet("Fluffy");
        VirtualPet pet3 = new VirtualPet("Blaze", "Dragon"); 
        System.out.println("=== VIRTUAL PET DAYCARE ===\n");
        for (int day = 1; day <= 5; day++) {
                pet1.feedPet();
                pet2.playWithPet();
                pet3.simulateDay();
                pet3.displayPetInfo();
        }
        System.out.println("Total Pets Created: " + VirtualPet.getTotalPetsCreated());
    }
}