package Week_7.Assignment;
class MedicalStaff {
    void shiftSchedule() {
        System.out.println("Shift scheduled for medical staff.");
    }
    void accessIDCard() {
        System.out.println("ID card access granted.");
    }
    void processPayroll() {
        System.out.println("Payroll processed for medical staff.");
    }
    void performDuties() {
        System.out.println("General medical duties.");
    }
}
class Doctor extends MedicalStaff {
    void performDuties() {
        System.out.println("Doctor diagnoses, prescribes medicine, and performs surgeries.");
    }
}
class Nurse extends MedicalStaff {
    void performDuties() {
        System.out.println("Nurse administers medicine, monitors patients, and assists procedures.");
    }
}
class Technician extends MedicalStaff {
    void performDuties() {
        System.out.println("Technician operates equipment, runs tests, and maintains instruments.");
    }
}
class Administrator extends MedicalStaff {
    void performDuties() {
        System.out.println("Administrator schedules appointments and manages records.");
    }
}
public class HospitalSystem {
    public static void main(String[] args) {
        MedicalStaff[] staffList = {new Doctor(),new Nurse(),new Technician(),new Administrator(),new Nurse()};
        for (MedicalStaff staff : staffList) {
            staff.shiftSchedule();
            staff.accessIDCard();
            staff.processPayroll();
            staff.performDuties();
            System.out.println();
        }
    }
}