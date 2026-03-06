package Week_7.Assignment;
class SmartDevice {
    void activate() {
        System.out.println("Activating generic smart device...");
    }
}
class SmartTV extends SmartDevice {
    void controlTV() {
        System.out.println("Managing channels, volume, and streaming apps.");
    }
}
class SmartThermostat extends SmartDevice {
    void controlThermostat() {
        System.out.println("Controlling temperature, humidity, and energy saving modes.");
    }
}
class SmartSecuritySystem extends SmartDevice {
    void controlSecurity() {
        System.out.println("Handling cameras, alarms, and access controls.");
    }
}
class SmartKitchenAppliance extends SmartDevice {
    void controlKitchen() {
        System.out.println("Managing cooking times, temperatures, and recipes.");
    }
}
public class HomeAutomation {
    public static void main(String[] args) {
        SmartDevice[] devices = {new SmartTV(),new SmartThermostat(),new SmartSecuritySystem(),new SmartKitchenAppliance(),new SmartTV()};
        for (SmartDevice device : devices) {
            device.activate();
            if (device instanceof SmartTV)
                ((SmartTV) device).controlTV();
            else if (device instanceof SmartThermostat)
                ((SmartThermostat) device).controlThermostat();
            else if (device instanceof SmartSecuritySystem)
                ((SmartSecuritySystem) device).controlSecurity();
            else if (device instanceof SmartKitchenAppliance)
                ((SmartKitchenAppliance) device).controlKitchen();
            System.out.println();
        }
    }
}