package Week_7.Lab;
class LibraryUser {
    void entryLog() {
        System.out.println("User entered the library.");
    }
    void accessServices() {
        System.out.println("General library access.");
    }
}
class Student extends LibraryUser {
    void accessServices() {
        System.out.println("Student borrows books and uses computers.");
    }
}
class Faculty extends LibraryUser {
    void accessServices() {
        System.out.println("Faculty reserves books and accesses research databases.");
    }
}
class Guest extends LibraryUser {
    void accessServices() {
        System.out.println("Guest browses books only.");
    }
}
public class UniversityLibrarySystem {
    public static void main(String[] args) {
        LibraryUser[] users = {
            new Student(),
            new Faculty(),
            new Guest(),
            new Student(),
            new Faculty()
        };
        for (LibraryUser user : users) {
            user.entryLog();
            user.accessServices();
            System.out.println();
        }
    }
}