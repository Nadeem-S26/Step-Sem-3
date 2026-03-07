package Week_9.Practice;
class ContactInfo implements Cloneable {
    String email;
    String phone;
    public ContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Override
    public String toString() {
        return "Email: " + email + ", Phone: " + phone;
    }
}
class Student implements Cloneable {
    String id;
    String name;
    ContactInfo contact;
    public Student(String id, String name, ContactInfo contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }
    public Student shallowCopy() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
    public Student deepCopy() throws CloneNotSupportedException {
        Student cloned = (Student) super.clone();
        cloned.contact = (ContactInfo) contact.clone();
        return cloned;
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Contact: [" + contact + "]";
    }
}
public class Registration {
    public static void main(String[] args) throws CloneNotSupportedException {
        ContactInfo c1 = new ContactInfo("ritika@example.com", "9876543210");
        Student original = new Student("S101", "Ritika", c1);
        Student shallow = original.shallowCopy();
        Student deep = original.deepCopy();
        System.out.println("Original: " + original);
        System.out.println("Shallow: " + shallow);
        System.out.println("Deep: " + deep);
        original.contact.email = "updated@example.com";
        System.out.println("\nAfter modifying original contact:");
        System.out.println("Original: " + original);
        System.out.println("Shallow: " + shallow);
        System.out.println("Deep: " + deep);
    }
}