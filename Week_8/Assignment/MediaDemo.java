package Week_8.Assignment;
interface Playable {
    void play();
    void pause();
}
class MusicPlayer implements Playable {
    @Override
    public void play() {
        System.out.println("Playing music...");
    }
    @Override
    public void pause() {
        System.out.println("Music paused.");
    }
}
class VideoPlayer implements Playable {
    @Override
    public void play() {
        System.out.println("Playing video...");
    }
    @Override
    public void pause() {
        System.out.println("Video paused.");
    }
}
public class MediaDemo {
    public static void main(String[] args) {
        Playable ref = new MusicPlayer();
        ref.play();
        ref.pause();
        System.out.println();
        ref = new VideoPlayer();
        ref.play();
        ref.pause();
    }
}