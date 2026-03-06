package Week_5.Practice;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public class SmartDevice {
    private final String deviceId;
    private final LocalDateTime manufacturingDate;
    private final String serialNumber;
    private int hashedEncryptionKey;
    private int hashedAdminPassword;
    private String deviceName;
    private boolean isEnabled;
    private final LocalDateTime startupTime;
    public SmartDevice(String deviceName) {
        this.deviceId = UUID.randomUUID().toString();
        this.manufacturingDate = LocalDateTime.now();
        this.serialNumber = UUID.randomUUID().toString();
        this.startupTime = LocalDateTime.now();
        this.deviceName = deviceName;
        this.isEnabled = true;
    }
    public String getDeviceId() { return deviceId; }
    public LocalDateTime getManufacturingDate() { return manufacturingDate; }
    public String getSerialNumber() { return serialNumber; }
    public long getUptime() { return Duration.between(startupTime, LocalDateTime.now()).toSeconds(); }
    public long getDeviceAge() {
        return Duration.between(manufacturingDate, LocalDateTime.now()).toDays();
    }

    public void setEncryptionKey(String key) {
        if (key.length() >= 8) {
            hashedEncryptionKey = key.hashCode();
        } else {
            throw new IllegalArgumentException("Encryption key too weak");
        }
    }
    public void setAdminPassword(String password) {
        if (password.length() >= 8) {
            hashedAdminPassword = password.hashCode();
        } else {
            throw new IllegalArgumentException("Password too weak");
        }
    }
    public boolean validateEncryptionKey(String key) {
        return key.hashCode() == hashedEncryptionKey;
    }
    public boolean validateAdminPassword(String password) {
        return password.hashCode() == hashedAdminPassword;
    }
    public String getDeviceName() {
        return deviceName;
    }
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    public boolean isEnabled() {
        return isEnabled;
    }
    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
    public void resetDevice() {
        hashedEncryptionKey = 0;
        hashedAdminPassword = 0;
    }
    public static void main(String[] args) throws InterruptedException {
        SmartDevice device = new SmartDevice("SmartSensor");
        System.out.println("Device ID: " + device.getDeviceId());
        System.out.println("Serial Number: " + device.getSerialNumber());
        System.out.println("Manufacturing Date: " + device.getManufacturingDate());
        System.out.println("Initial Uptime (sec): " + device.getUptime());
        Thread.sleep(2000);
        System.out.println("Updated Uptime (sec): " + device.getUptime());
        System.out.println("Device Age (days): " + device.getDeviceAge());
        device.setEncryptionKey("strongKey123");
        device.setAdminPassword("adminPass456");
        System.out.println("Encryption key valid? " + device.validateEncryptionKey("strongKey123"));
        System.out.println("Admin password valid? " + device.validateAdminPassword("adminPass456"));
        device.setDeviceName("SuperSmartSensor");
        device.setEnabled(false);
        System.out.println("Device Name: " + device.getDeviceName());
        System.out.println("Is Enabled: " + device.isEnabled());
        device.resetDevice();
        System.out.println("After reset, Encryption Key Valid? " + device.validateEncryptionKey("strongKey123"));
    }
}