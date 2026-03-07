package Week_8.Practice;

interface Camera {
    void takePhoto();
}
interface MusicPlayer {
    void playMusic();
}
class SmartPhone implements Camera, MusicPlayer {
    @Override
    public void takePhoto() {
        System.out.println("Taking photo with smartphone");
    }
    @Override
    public void playMusic() {
        System.out.println("Playing music on smartphone");
    }
}
public class DeviceDemo {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone();
        myPhone.takePhoto();
        myPhone.playMusic();
    }
}