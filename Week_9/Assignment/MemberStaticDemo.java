package Week_9.Assignment;
class University {
    private String universityName = "SRM Institute";
    class Department {
        private String deptName;
        public Department(String deptName) {
            this.deptName = deptName;
        }
        public void showDetails() {
            System.out.println("Department: " + deptName + " at " + universityName);
        }
    }
    static class ExamCell {
        public static void conductExam() {
            System.out.println("ExamCell: Exams are being conducted across all departments.");
        }
    }
}
public class MemberStaticDemo  {
    public static void main(String[] args) {
        University uni = new University();
        University.Department dept = uni.new Department("Computer Science");
        dept.showDetails(); 
        University.ExamCell.conductExam();
    }
}