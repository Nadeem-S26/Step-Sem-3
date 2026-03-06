package Week_7.Assignment;
class Course {
    String title, instructor;
    String enrollmentDate;
    Course(String title, String instructor, String enrollmentDate) {
        this.title = title;
        this.instructor = instructor;
        this.enrollmentDate = enrollmentDate;
    }
    void showProgress() {
        System.out.println("Generic course progress.");
    }
    void showBasicInfo() {
        System.out.println("Title: " + title);
        System.out.println("Instructor: " + instructor);
        System.out.println("Enrolled on: " + enrollmentDate);
    }
}
class VideoCourse extends Course {
    int completionPercent;
    int watchTime;
    VideoCourse(String t, String i, String d, int cp, int wt) {
        super(t, i, d);
        completionPercent = cp;
        watchTime = wt;
    }
    void showProgress() {
        System.out.println("Completion: " + completionPercent + "%");
        System.out.println("Watch Time: " + watchTime + " minutes");
    }
}
class InteractiveCourse extends Course {
    int quizScore;
    int projectsDone;
    InteractiveCourse(String t, String i, String d, int qs, int pd) {
        super(t, i, d);
        quizScore = qs;
        projectsDone = pd;
    }
    void showProgress() {
        System.out.println("Quiz Score: " + quizScore + "/100");
        System.out.println("Projects Completed: " + projectsDone);
    }
}
class ReadingCourse extends Course {
    int pagesRead;
    int notesTaken;
    ReadingCourse(String t, String i, String d, int pr, int nt) {
        super(t, i, d);
        pagesRead = pr;
        notesTaken = nt;
    }
    void showProgress() {
        System.out.println("Pages Read: " + pagesRead);
        System.out.println("Notes Taken: " + notesTaken);
    }
}
class CertificationCourse extends Course {
    int examAttempts;
    boolean certified;
    CertificationCourse(String t, String i, String d, int ea, boolean c) {
        super(t, i, d);
        examAttempts = ea;
        certified = c;
    }
    void showProgress() {
        System.out.println("Exam Attempts: " + examAttempts);
        System.out.println("Certification Status: " + (certified ? "Certified" : "Not Yet Certified"));
    }
}
public class LearningPlatform {
    public static void main(String[] args) {
        Course[] courses = {
            new VideoCourse("Java Basics", "Dr. Rao", "2025-09-01", 80, 120),
            new InteractiveCourse("Data Structures", "Prof. Meena", "2025-08-20", 85, 3),
            new ReadingCourse("OS Concepts", "Dr. Arul", "2025-09-10", 150, 20),
            new CertificationCourse("Cybersecurity", "Mr. Kiran", "2025-07-15", 2, true)
        };
        for (Course c : courses) {
            c.showBasicInfo();
            c.showProgress();
            System.out.println();
        }
    }
}