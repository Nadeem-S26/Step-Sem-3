package Week_5.Practice;
public class AccessModifierDemo {
    private int privateField;
    String defaultField;
    protected double protectedField;
    public boolean publicField;
    private void privateMethod() {
        System.out.println("Private method called");
    }
    void defaultMethod() {
        System.out.println("Default method called");
    }
    protected void protectedMethod() {
        System.out.println("Protected method called");
    }
    public void publicMethod() {
        System.out.println("Public method called");
    }
    AccessModifierDemo() {
        privateField = 0;
        defaultField = " ";
        protectedField = 0.0;
        publicField = true;
    }
    public void testInternalAccess() {
        System.out.println("privateField: " + privateField);
        System.out.println("defaultField: " + defaultField);
        System.out.println("protectedField: " + protectedField);
        System.out.println("publicField: " + publicField);
        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
        System.out.println("All members accessible within the same class.");
    }
    public static void main(String[] args) {
        AccessModifierDemo amd = new AccessModifierDemo();
        amd.defaultField = "default";  
        amd.protectedField = 1.23;
        amd.publicField = false;
        amd.defaultMethod();
        amd.protectedMethod();
        amd.publicMethod();
        amd.testInternalAccess();
    }
}
class SamePackageTest {
    public static void testAccess() {
        AccessModifierDemo amd = new AccessModifierDemo();
        amd.defaultField = "default access";
        amd.protectedField = 3.14;
        amd.publicField = true;
        amd.defaultMethod();
        amd.protectedMethod();
        amd.publicMethod();            
        System.out.println("Access from SamePackageTest (same package):");
        System.out.println("defaultField: " + amd.defaultField);
        System.out.println("protectedField: " + amd.protectedField);
        System.out.println("publicField: " + amd.publicField);
        amd.defaultMethod();
        amd.protectedMethod();
        amd.publicMethod();
    }
}