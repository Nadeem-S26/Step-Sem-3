package Week_9.Lab;
class Address {
    String city;
    public Address(String city) {
        this.city = city;
    }
    @Override
    public String toString() {
        return city;
    }
}
class Person implements Cloneable {
    String name;
    Address address;
    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    public Person shallowClone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
    public Person deepClone() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        cloned.address = new Address(this.address.city);
        return cloned;
    }

    @Override
    public String toString() {
        return name + " from " + address;
    }
}
public class PersonDetails {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address addr = new Address("Chennai");
        Person original = new Person("Nadeem", addr); 
        Person shallow = original.shallowClone();
        Person deep = original.deepClone();
        original.address.city = "Mumbai";
        System.out.println("Original: " + original);
        System.out.println("Shallow Clone: " + shallow);
        System.out.println("Deep Clone: " + deep);
    }
}