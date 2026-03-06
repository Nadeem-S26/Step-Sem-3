package Week_7.Lab;
class SmartDevice {
    void activate() {
        System.out.println("Activating generic smart device...");
    }
}
class SmartClassroom extends SmartDevice {
    void controlClassroom() {
        System.out.println("Controlling lighting, AC, and projector.");
    }
}
class SmartLab extends SmartDevice {
    void manageLab() {
        System.out.println("Managing lab equipment and safety systems.");
    }
}
class SmartLibrary extends SmartDevice {
    void trackLibrary() {
        System.out.println("Tracking occupancy and book availability.");
    }
}
public class CampusSystem {
    public static void main(String[] args) {
        SmartDevice[] devices = {new SmartClassroom(),new SmartLab(),new SmartLibrary(),new SmartLab(),new SmartClassroom()};
        for (SmartDevice device : devices) {
            device.activate();
            if (device instanceof SmartClassroom)
                ((SmartClassroom) device).controlClassroom();
            else if (device instanceof SmartLab)
                ((SmartLab) device).manageLab();
            else if (device instanceof SmartLibrary)
                ((SmartLibrary) device).trackLibrary();
            System.out.println();
        }
    }
}