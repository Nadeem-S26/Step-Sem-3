package Week_7.Lab;
class Character {
    void attack() {
        System.out.println("Character attacks.");
    }
}
class Warrior extends Character {
    void attack() {
        System.out.println("Warrior strikes with weapon and defends strongly.");
    }
}
class Mage extends Character {
    void attack() {
        System.out.println("Mage casts a spell using mana.");
    }
}
class Archer extends Character {
    void attack() {
        System.out.println("Archer shoots arrows from long range.");
    }
}
public class GamingCharacterSystem {
    public static void main(String[] args) {
        Character[] army = {
            new Warrior(),
            new Mage(),
            new Archer(),
            new Warrior(),
            new Mage()
        };
        for (Character c : army)
            c.attack();
    }
}