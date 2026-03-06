import java.util.Arrays; 
import java.util.Objects; 
import java.util.UUID; 
final class PetSpecies { 
    private final String speciesName; 
    private final String[] evolutionStages; 
    private final int maxLifespan; 
    private final String habitat; 
    public PetSpecies(String speciesName, String[] evolutionStages, int maxLifespan, String habitat) { 
        if (speciesName == null || speciesName.isBlank()) { 
            throw new IllegalArgumentException("Species name cannot be null/blank"); 
        } 
        if (evolutionStages == null || evolutionStages.length == 0) { 
            throw new IllegalArgumentException("Evolution stages must not be empty"); 
        } 
        if (maxLifespan <= 0) { 
            throw new IllegalArgumentException("Max lifespan must be positive"); 
        } 
        if (habitat == null || habitat.isBlank()) { 
            throw new IllegalArgumentException("Habitat cannot be null/blank"); 
        }
        this.speciesName = speciesName; 
        this.evolutionStages = Arrays.copyOf(evolutionStages, evolutionStages.length); 
        this.maxLifespan = maxLifespan; 
        this.habitat = habitat; 
    } 
    public String getSpeciesName() { return speciesName; } 
    public String[] getEvolutionStages() {  return Arrays.copyOf(evolutionStages, evolutionStages.length);} 
    public int getMaxLifespan() {return maxLifespan;} 
    public String getHabitat() { return habitat;} 
    @Override 
    public boolean equals(Object o) { 
        if (this == o) return true; 
        if (!(o instanceof PetSpecies)) return false; 
        PetSpecies that = (PetSpecies) o; 
        return maxLifespan == that.maxLifespan && 
                Objects.equals(speciesName, that.speciesName) && 
                Arrays.equals(evolutionStages, that.evolutionStages) && 
                Objects.equals(habitat, that.habitat); 
    } 
 
    @Override 
    public int hashCode() { 
        int result = Objects.hash(speciesName, maxLifespan, habitat); 
        result = 31 * result + Arrays.hashCode(evolutionStages); 
        return result; 
    } 
 
    @Override 
    public String toString() { 
        return "PetSpecies{" + 
                "speciesName='" + speciesName + '\'' + 
                ", evolutionStages=" + Arrays.toString(evolutionStages) + 
                ", maxLifespan=" + maxLifespan + 
                ", habitat='" + habitat + '\'' + 
                '}'; 
    } 
} 
class VirtualPet { 
    private final String petId; 
    private final PetSpecies species; 
    private final long birthTimestamp; 
    private String petName; 
    private int age; 
    private int happiness; 
    private int health; 
    protected static final String[] DEFAULT_EVOLUTION_STAGES = {"Baby", "Teen", "Adult"}; 
    static final int MAX_HAPPINESS = 100; 
    static final int MAX_HEALTH = 100; 
    public static final String PET_SYSTEM_VERSION = "2.0"; 

    public VirtualPet() { 
        this("Pet-" + UUID.randomUUID().toString().substring(0, 5), 
                new PetSpecies("Default", DEFAULT_EVOLUTION_STAGES, 1000, "VirtualWorld"), 
                0, 50, 50); 
    } 
 
    public VirtualPet(String petName) { 
        this(petName, new PetSpecies("Default", DEFAULT_EVOLUTION_STAGES, 
1000, "VirtualWorld"), 0, 60, 60); 
    } 
 
    public VirtualPet(String petName, PetSpecies species) { 
        this(petName, species, 0, 70, 70); 
    } 
 
    public VirtualPet(String petName, PetSpecies species, int age, int 
happiness, int health) { 
        this.petId = generatePetId(); 
        this.birthTimestamp = System.currentTimeMillis(); 
        this.petName = petName; 
        this.species = species; 
        setAge(age); 
        setHappiness(happiness); 
        setHealth(health); 
    } 
 
    public String getPetId() { return petId; } 
    public PetSpecies getSpecies() { return species; } 
    public long getBirthTimestamp() { return birthTimestamp; } 
    public String getPetName() { return petName; } 
 
    public void setPetName(String petName) { 
        if (petName == null || petName.isBlank()) { 
            throw new IllegalArgumentException("Pet name cannot be null/blank"); 
        } 
        this.petName = petName; 
    } 
 
    public int getAge() { return age; } 
    public void setAge(int age) { 
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative"); 
        this.age = age; 
    } 
    public int getHappiness() { return happiness; } 
    public void setHappiness(int happiness) { 
        this.happiness = validateStat(happiness, MAX_HAPPINESS); 
    }  
    public int getHealth() { return health; } 
    public void setHealth(int health) { 
        this.health = validateStat(health, MAX_HEALTH); 
    }  
    public void feedPet(String foodType) { 
        int bonus = calculateFoodBonus(foodType); 
        modifyHealth(bonus); 
    } 
    public void playWithPet(String gameType) { 
        int effect = calculateGameEffect(gameType); 
        modifyHappiness(effect); 
    } 
   protected int calculateFoodBonus(String foodType) { 
        return switch (foodType.toLowerCase()) { 
            case "fruit" -> 10; 
            case "meat" -> 15; 
            default -> 5; 
        }; 
    } 
    protected int calculateGameEffect(String gameType) { 
        return switch (gameType.toLowerCase()) { 
            case "fetch" -> 15; 
            case "dance" -> 20; 
            default -> 5; 
        }; 
    } 
    private void modifyHappiness(int value) { 
        this.happiness = Math.min(MAX_HAPPINESS, happiness + value); 
        updateEvolutionStage(); 
    } 
    private void modifyHealth(int value) { 
        this.health = Math.min(MAX_HEALTH, health + value); 
    }
    private void updateEvolutionStage() { 
        checkEvolution(); 
    } 
    private void checkEvolution() { 
        if (age > 5 && happiness > 70) { 
            System.out.println(petName + " is evolving!"); 
        } 
    } 
    private int validateStat(int value, int max) { 
        if (value < 0 || value > max) { 
            throw new IllegalArgumentException("Stat must be between 0 and " + max); 
        } 
        return value; 
    } 
    private String generatePetId() { 
        return "PET-" + UUID.randomUUID().toString().substring(0, 8); 
    } 
    @Override 
    public String toString() { 
        return "VirtualPet{" + 
                "petId='" + petId + '\'' + 
                ", petName='" + petName + '\'' + 
                ", species=" + species + 
                ", age=" + age + 
                ", happiness=" + happiness + 
                ", health=" + health + 
                '}'; 
    } 
    @Override 
    public boolean equals(Object o) { 
        if (this == o) return true; 
        if (!(o instanceof VirtualPet)) return false; 
        VirtualPet that = (VirtualPet) o; 
        return Objects.equals(petId, that.petId); 
    } 
    @Override 
    public int hashCode() { 
        return Objects.hash(petId); 
    } 
}
class DragonPet { 
    private final String dragonType; 
    private final String breathWeapon; 
    private final VirtualPet basePet;
    public DragonPet(String dragonType, String breathWeapon, VirtualPet basePet) { 
        if (dragonType == null || dragonType.isBlank()) 
            throw new IllegalArgumentException("Dragon type cannot be null/blank"); 
        if (breathWeapon == null || breathWeapon.isBlank()) 
            throw new IllegalArgumentException("Breath weapon cannot be null/blank"); 
 
        this.dragonType = dragonType; 
        this.breathWeapon = breathWeapon; 
        this.basePet = basePet; 
    } 

    public String getDragonType() { return dragonType; } 
    public String getBreathWeapon() { return breathWeapon; } 
    public VirtualPet getBasePet() { return basePet; } 
    @Override 
    public String toString() { 
        return "DragonPet{" + 
                "dragonType='" + dragonType + '\'' + 
                ", breathWeapon='" + breathWeapon + '\'' + 
                ", basePet=" + basePet + 
                '}'; 
    } 
}
class RobotPet { 
    private boolean needsCharging; 
    private int batteryLevel; 
    private final VirtualPet basePet; 
    public RobotPet(VirtualPet basePet) { 
        this.basePet = basePet; 
        this.batteryLevel = 100; 
        this.needsCharging = false; 
    } 
    public boolean isNeedsCharging() { return needsCharging; } 
    public int getBatteryLevel() { return batteryLevel; } 
    public void drainBattery(int amount) { 
        batteryLevel = Math.max(0, batteryLevel - amount); 
        needsCharging = batteryLevel <= 20; 
    } 
    public void recharge() { 
        batteryLevel = 100; 
        needsCharging = false; 
    } 
    public VirtualPet getBasePet() { return basePet; } 
    @Override 
    public String toString() { 
        return "RobotPet{" + 
                "needsCharging=" + needsCharging + 
                ", batteryLevel=" + batteryLevel + 
                ", basePet=" + basePet + 
                '}'; 
    } 
}
public class VirtualPetEvolution { 
    public static void main(String[] args) { 
        PetSpecies dragonSpecies = new PetSpecies( 
                "Dragon", 
                new String[]{"Egg", "Hatchling", "Wyrmling", "Adult"}, 
                5000, 
                "Volcanic Mountains" 
        ); 
        VirtualPet pet1 = new VirtualPet("Drako", dragonSpecies); 
        VirtualPet pet2 = new VirtualPet("Robo"); 
        DragonPet dragonPet = new DragonPet("Fire Dragon", "Flame Breath", pet1); 
        RobotPet robotPet = new RobotPet(pet2);
        pet1.feedPet("meat"); 
        pet1.playWithPet("fetch"); 
        pet1.setAge(6); 
        pet2.playWithPet("dance"); 
        robotPet.drainBattery(85); 
        System.out.println(dragonPet); 
        System.out.println(robotPet); 
        System.out.println("Robot needs charging? " + 
        robotPet.isNeedsCharging()); 
    } 
} 