package Week_9.Assignment;
import java.util.HashSet;
import java.util.Objects;
class Student {
    private int rollNo;
    private String name;
    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // same reference
        if (obj == null || getClass() != obj.getClass()) return false;

        Student other = (Student) obj;
        return this.rollNo == other.rollNo;
    }
    @Override
    public int hashCode() {
        return Objects.hash(rollNo); 
    }
    @Override
    public String toString() {
        return "Student{rollNo=" + rollNo + ", name='" + name + "'}";
    }
}

public class StudentSet {
    public static void main(String[] args) {
        HashSet<Student> studentSet = new HashSet<>();
        Student s1 = new Student(1, "Nadeem");
        Student s2 = new Student(2, "Aisha");
        Student s3 = new Student(1, "Ravi"); 
        studentSet.add(s1);
        studentSet.add(s2);
        studentSet.add(s3); 
        for (Student s : studentSet) {
            System.out.println(s);
        }
    }
}