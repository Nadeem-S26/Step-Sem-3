package Week_8.Assignment;
interface Animal {
    void eat();
}
interface Pet extends Animal {
    void play();
}
class Dog implements Pet {
    private String name;
    public Dog(String name) {
        this.name = name;
    }
    @Override
    public void eat() {
        System.out.println(name + " is eating dog food.");
    }
    @Override
    public void play() {
        System.out.println(name + " is playing fetch.");
    }
    public void showDetails() {
        System.out.println("Dog Name: " + name);
    }
}
public class PetDemo {
    public static void main(String[] args) {
        Dog myDog = new Dog("Bruno");
        myDog.showDetails();
        myDog.eat();
        myDog.play();
    }
}