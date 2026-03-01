package Week_3.Practice;
public class Student {
    private String studentId;
    private String name;
    private double grade;
    private String course;
    public Student() {
        this.studentId = "";
        this.name = "";
        this.grade = 0.0;
        this.course = "";
    }
    public Student(String studentId, String name, double grade, String course) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.course = course;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getStudentId() {
        return studentId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public void setGrade(double grade) {
        this.grade = grade;
    }
    public double getGrade() {
        return grade;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public String getCourse() {
        return course;
    }
    public String calculateLetterGrade() {
        if (grade >= 90) return "A";
        else if (grade >= 80) return "B";
        else if (grade >= 70) return "C";
        else if (grade >= 60) return "D";
        else return "F";
    }
    public void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name      : " + name);
        System.out.println("Course    : " + course);
        System.out.println("Grade     : " + grade);
        System.out.println("Letter Grade: " + calculateLetterGrade());
        System.out.println();
    }
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setStudentId("S101");
        s1.setName("Nadeem");
        s1.setGrade(85.5);
        s1.setCourse("Java Programming");
        Student s2 = new Student("S102", "Sora", 72.0, "Data Structures");
        System.out.println("Student 1 Name (via getter): " + s1.getName());
        s2.setGrade(78.0);
        System.out.println("\nStudent Details:");
        s1.displayStudent();
        s2.displayStudent();
    }
}