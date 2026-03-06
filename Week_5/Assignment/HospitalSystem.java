package Week_5.Assignment;
import java.time.LocalDate; 
import java.util.*; 
 
final class MedicalRecord { 
    private final String recordId; 
    private final String patientDNA; 
    private final String[] allergies; 
    private final String[] medicalHistory; 
    private final LocalDate birthDate; 
    private final String bloodType; 
 
    public MedicalRecord(String recordId, String patientDNA, String[] 
allergies, 
                         String[] medicalHistory, LocalDate birthDate, 
String bloodType) { 
        if (recordId == null || patientDNA == null || birthDate == null || 
bloodType == null) { 
            throw new IllegalArgumentException("Medical record fields cannot be null"); 
        } 
        this.recordId = recordId; 
        this.patientDNA = patientDNA; 
        this.allergies = allergies != null ? Arrays.copyOf(allergies, 
allergies.length) : new String[0]; 
        this.medicalHistory = medicalHistory != null ? 
Arrays.copyOf(medicalHistory, medicalHistory.length) : new String[0]; 
        this.birthDate = birthDate; 
        this.bloodType = bloodType; 
    } 
    public String getRecordId() { return recordId; } 
    public String getPatientDNA() { return patientDNA; } 
    public String[] getAllergies() { return Arrays.copyOf(allergies, 
allergies.length); } 
    public String[] getMedicalHistory() { return 
Arrays.copyOf(medicalHistory, medicalHistory.length); } 
    public LocalDate getBirthDate() { return birthDate; } 
    public String getBloodType() { return bloodType; } 
    public final boolean isAllergicTo(String substance) { 
        for (String allergy : allergies) { 
            if (allergy.equalsIgnoreCase(substance)) return true; 
        } 
        return false; 
    } 
 
    @Override 
    public String toString() { 
        return "MedicalRecord{recordId='" + recordId + "', birthDate=" + birthDate + ", bloodType='" + bloodType + "', allergies=" + Arrays.toString(allergies) + "}"; 
    } 
} 
 
class Patient { 
    private final String patientId; 
    private final MedicalRecord medicalRecord; 
    private String currentName; 
    private String emergencyContact; 
    private String insuranceInfo; 
    private int roomNumber; 
    private String attendingPhysician; 
 
    // Emergency admission (minimal) 
    public Patient(String patientId, String currentName) { 
        this(patientId, currentName, null, null, 0, null, null); 
    } 
 
    // Standard admission 
    public Patient(String patientId, String currentName, String 
emergencyContact, 
                   String insuranceInfo, int roomNumber, String 
attendingPhysician, 
                   MedicalRecord record) { 
        if (patientId == null || currentName == null) { 
            throw new IllegalArgumentException("Patient ID and Name cannot be null"); 
        } 
        this.patientId = patientId; 
        this.currentName = currentName; 
        this.emergencyContact = emergencyContact; 
        this.insuranceInfo = insuranceInfo; 
        this.roomNumber = roomNumber; 
        this.attendingPhysician = attendingPhysician; 
        this.medicalRecord = record; 
    } 
 
    // Transfer admission 
    public Patient(String patientId, MedicalRecord record) { 
        this(patientId, "Unknown", null, null, 0, null, record); 
    } 
 
    // Getters / Setters 
    public String getPatientId() { return patientId; } 
    public MedicalRecord getMedicalRecord() { return medicalRecord; } 
    public String getCurrentName() { return currentName; } 
    public void setCurrentName(String currentName) { this.currentName = 
currentName; } 
    public String getEmergencyContact() { return emergencyContact; } 
    public void setEmergencyContact(String emergencyContact) { 
this.emergencyContact = emergencyContact; } 
    public String getInsuranceInfo() { return insuranceInfo; } 
    public void setInsuranceInfo(String insuranceInfo) { 
this.insuranceInfo = insuranceInfo; } 
    public int getRoomNumber() { return roomNumber; } 
    public void setRoomNumber(int roomNumber) { this.roomNumber = 
roomNumber; } 
    public String getAttendingPhysician() { return attendingPhysician; } 
    public void setAttendingPhysician(String attendingPhysician) { 
this.attendingPhysician = attendingPhysician; } 
 
    // Restricted info 
    String getBasicInfo() { 
        return "PatientID: " + patientId + ", Name: " + currentName; 
    } 
 
    public String getPublicInfo() { 
        return "Name: " + currentName + ", Room: " + roomNumber; 
    } 
 
    @Override 
    public String toString() { 
        return "Patient{" + "id='" + patientId + "', name='" + currentName 
+ "', room=" + roomNumber + 
                ", physician='" + attendingPhysician + "'}"; 
    } 
} 
 
class Doctor { 
    private final String licenseNumber; 
    private final String specialty; 
    private final Set<String> certifications; 
 
    public Doctor(String licenseNumber, String specialty, Set<String> 
certifications) { 
        this.licenseNumber = licenseNumber; 
        this.specialty = specialty; 
        this.certifications = certifications != null ? new 
HashSet<>(certifications) : new HashSet<>(); 
    } 
 
    public String getLicenseNumber() { return licenseNumber; } 
    public String getSpecialty() { return specialty; } 
    public Set<String> getCertifications() { return new 
HashSet<>(certifications); } 
} 
 
class Nurse { 
    private final String nurseId; 
    private final String shift; 
    private final List<String> qualifications; 
 
    public Nurse(String nurseId, String shift, List<String> 
qualifications) { 
        this.nurseId = nurseId; 
        this.shift = shift; 
        this.qualifications = qualifications != null ? new 
ArrayList<>(qualifications) : new ArrayList<>(); 
    } 
 
    public String getNurseId() { return nurseId; } 
    public String getShift() { return shift; } 
    public List<String> getQualifications() { return new 
ArrayList<>(qualifications); } 
} 
 
class Administrator { 
    private final String adminId; 
    private final List<String> accessPermissions; 
 
    public Administrator(String adminId, List<String> accessPermissions) { 
        this.adminId = adminId; 
        this.accessPermissions = accessPermissions != null ? new 
ArrayList<>(accessPermissions) : new ArrayList<>(); 
    } 
 
    public String getAdminId() { return adminId; } 
    public List<String> getAccessPermissions() { return new 
ArrayList<>(accessPermissions); } 
} 
 
public class HospitalSystem { 
    private final Map<String, Object> patientRegistry = new HashMap<>(); 
    public static final String PRIVACY_RULE = "HIPAA-COMPLIANT"; 
 
    public boolean admitPatient(Object patient, Object staff) { 
        if (patient instanceof Patient && validateStaffAccess(staff, 
patient)) { 
            patientRegistry.put(((Patient) patient).getPatientId(), 
patient); 
            return true; 
        } 
        return false; 
    } 
 
    private boolean validateStaffAccess(Object staff, Object patient) { 
        if (staff instanceof Doctor) return true; 
        if (staff instanceof Nurse) return true; 
        if (staff instanceof Administrator) return true; 
        return false; 
    } 
 
    void printAllPatients() { 
        for (Object p : patientRegistry.values()) { 
            System.out.println(p); 
        } 
    } 
    @SuppressWarnings("all")
    public static void main(String[] args) { 
        MedicalRecord record = new MedicalRecord( 
                "R001", "DNA123", new String[]{"Peanuts"}, new 
String[]{"Asthma"}, 
                LocalDate.of(1990, 5, 12), "O+" 
        ); 
        Patient p1 = new Patient("P001", "John Doe", "123-456", 
"InsureCo", 101, "Dr. Smith", record); 
        Doctor doc = new Doctor("LIC123", "Cardiology", Set.of("Board Certified")); 
        Nurse nurse = new Nurse("N001", "Night", List.of("ICU", 
"Emergency")); 
        Administrator admin = new Administrator("A001", 
List.of("PatientRegistry")); 
        HospitalSystem system = new HospitalSystem(); 
        system.admitPatient(p1, doc); 
        System.out.println(p1.getPublicInfo()); 
        System.out.println("Is allergic to peanuts? " + 
p1.getMedicalRecord().isAllergicTo("Peanuts")); 
        system.printAllPatients(); 
    } 
} 