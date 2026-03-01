package Week_4.Lab;
import java.util.*;
abstract class MagicalStructure {
    String structureName;
    int magicPower;
    String location;
    boolean isActive;
    public MagicalStructure() {
        this("Unknown", 0, "Nowhere", false);
    }
    public MagicalStructure(String structureName) {
        this(structureName, 10, "Unknown", true);
    }
    public MagicalStructure(String structureName, int magicPower, String location, boolean isActive) {
        this.structureName = structureName;
        this.magicPower = magicPower;
        this.location = location;
        this.isActive = isActive;
    }
    abstract void castMagicSpell();
}
class WizardTower extends MagicalStructure {
    int spellCapacity;
    String[] knownSpells;
    public WizardTower() {
        this("Basic Tower", 20, "Hilltop", true, 5, new String[]{"Fireball"});
    }
    public WizardTower(String structureName, int spellCapacity, String[] knownSpells) {
        this(structureName, 30, "Mountain", true, spellCapacity, knownSpells);
    }
    public WizardTower(String structureName, int magicPower, String location, boolean isActive, int spellCapacity, String[] knownSpells) {
        super(structureName, magicPower, location, isActive);
        this.spellCapacity = spellCapacity;
        this.knownSpells = knownSpells;
    }
    @Override
    void castMagicSpell() {
        System.out.println(structureName + " casts " + Arrays.toString(knownSpells));
    }
}
class EnchantedCastle extends MagicalStructure {
    int defenseRating;
    boolean hasDrawbridge;
    public EnchantedCastle() {
        this("Simple Fort", 15, "Valley", true, 50, false);
    }
    public EnchantedCastle(String structureName, int defenseRating, boolean hasDrawbridge) {
        this(structureName, 25, "Plains", true, defenseRating, hasDrawbridge);
    }
    public EnchantedCastle(String structureName, int magicPower, String location, boolean isActive, int defenseRating, boolean hasDrawbridge) {
        super(structureName, magicPower, location, isActive);
        this.defenseRating = defenseRating;
        this.hasDrawbridge = hasDrawbridge;
    }
    @Override
    void castMagicSpell() {
        System.out.println(structureName + " activates magical shield!");
    }
}
class MysticLibrary extends MagicalStructure {
    int bookCount;
    String ancientLanguage;
    public MysticLibrary() {
        this("Tiny Library", 10, "Village", true, 100, "Old Elvish");
    }
    public MysticLibrary(String structureName, int bookCount, String ancientLanguage) {
        this(structureName, 20, "City", true, bookCount, ancientLanguage);
    }
    public MysticLibrary(String structureName, int magicPower, String location, boolean isActive, int bookCount, String ancientLanguage) {
        super(structureName, magicPower, location, isActive);
        this.bookCount = bookCount;
        this.ancientLanguage = ancientLanguage;
    }
    @Override
    void castMagicSpell() {
        System.out.println(structureName + " reads spell from " + ancientLanguage + " tome.");
    }
}
class DragonLair extends MagicalStructure {
    String dragonType;
    int treasureValue;
    public DragonLair() {
        this("Cave of Ember", 40, "Volcano", true, "Fire Drake", 1000);
    }
    public DragonLair(String structureName, String dragonType, int treasureValue) {
        this(structureName, 50, "Mountain", true, dragonType, treasureValue);
    }
    public DragonLair(String structureName, int magicPower, String location, boolean isActive, String dragonType, int treasureValue) {
        super(structureName, magicPower, location, isActive);
        this.dragonType = dragonType;
        this.treasureValue = treasureValue;
    }
    @Override
    void castMagicSpell() {
        System.out.println(structureName + " unleashes dragon fury of " + dragonType);
    }
}
class MagicInteraction {
    public static boolean canStructuresInteract(MagicalStructure s1, MagicalStructure s2) {
        return s1.isActive && s2.isActive;
    }
    public static String performMagicBattle(MagicalStructure attacker, MagicalStructure defender) {
        if (attacker.magicPower > defender.magicPower) {
            return attacker.structureName + " wins the battle!";
        } else if (attacker.magicPower < defender.magicPower) {
            return defender.structureName + " defends successfully!";
        } else {
            return "It's a magical draw!";
        }
    }
    public static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int total = 0;
        for (MagicalStructure s : structures) {
            total += s.magicPower;
        }
        return total;
    }
}
class KingdomManager {
    public static void categorizeStructures(MagicalStructure[] structures) {
        for (MagicalStructure s : structures) {
            if (s instanceof WizardTower) {
                System.out.println(s.structureName + " is a Wizard Tower.");
            } else if (s instanceof EnchantedCastle) {
                System.out.println(s.structureName + " is an Enchanted Castle.");
            } else if (s instanceof MysticLibrary) {
                System.out.println(s.structureName + " is a Mystic Library.");
            } else if (s instanceof DragonLair) {
                System.out.println(s.structureName + " is a Dragon Lair.");
            }
        }
    }
    public static double calculateTax(MagicalStructure s) {
        if (s instanceof WizardTower) return 0.1;
        if (s instanceof EnchantedCastle) return 0.2;
        if (s instanceof MysticLibrary) return 0.05;
        if (s instanceof DragonLair) return 0.3;
        return 0.15;
    }
    public static String determineSpecialization(MagicalStructure[] structures) {
        int magic = 0, defense = 0;
        for (MagicalStructure s : structures) {
            if (s instanceof WizardTower || s instanceof MysticLibrary) magic++;
            if (s instanceof EnchantedCastle || s instanceof DragonLair) defense++;
        }
        if (magic > defense) return "Magic-focused Kingdom";
        else if (defense > magic) return "Defense-focused Kingdom";
        else return "Balanced Kingdom";
    }
    public static void applySpecialEffects(MagicalStructure[] structures) {
        boolean hasTower = false, hasLibrary = false, hasCastle = false, hasLair = false;
        int towerCount = 0;
        for (MagicalStructure s : structures) {
            if (s instanceof WizardTower) {
                hasTower = true;
                towerCount++;
            }
            if (s instanceof MysticLibrary) hasLibrary = true;
            if (s instanceof EnchantedCastle) hasCastle = true;
            if (s instanceof DragonLair) hasLair = true;
        }
        if (hasTower && hasLibrary) {
            for (MagicalStructure s : structures) {
                if (s instanceof WizardTower) {
                    ((WizardTower) s).spellCapacity *= 2;
                    System.out.println("📚 Knowledge boost applied to " + s.structureName);
                }
            }
        }
        if (hasCastle && hasLair) {
            for (MagicalStructure s : structures) {
                if (s instanceof EnchantedCastle) {
                    ((EnchantedCastle) s).defenseRating *= 3;
                    System.out.println("Dragon guard applied to " + s.structureName);
                }
            }
        }

        if (towerCount > 1) {
            System.out.println("✨ Magic network activated among Wizard Towers!");
        }
    }
}
public class MedievalKingdomBuilder {
    public static void main(String[] args) {
        MagicalStructure[] kingdom = {
            new WizardTower("Arcane Spire", 10, new String[]{"Lightning", "Teleport"}),
            new MysticLibrary("Grand Archive", 500, "Ancient Runes"),
            new EnchantedCastle("Royal Keep", 100, true),
            new DragonLair("Inferno Nest", "Fire Dragon", 2000),
            new WizardTower("Crystal Tower", 8, new String[]{"Shield", "Heal"})
        };

        KingdomManager.categorizeStructures(kingdom);
        KingdomManager.applySpecialEffects(kingdom);

        System.out.println("\nTotal Magic Power: " + MagicInteraction.calculateKingdomMagicPower(kingdom));
        System.out.println(" Kingdom Type: " + KingdomManager.determineSpecialization(kingdom));

        System.out.println("\n Battle Result: " +
            MagicInteraction.performMagicBattle(kingdom[0], kingdom[2]));
        System.out.println("\nTax Rates:");
        for (MagicalStructure s : kingdom) {
            System.out.printf("%s: %.2f%%\n", s.structureName, KingdomManager.calculateTax(s) * 100);
        }
    }
}