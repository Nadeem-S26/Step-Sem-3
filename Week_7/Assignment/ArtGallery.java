package Week_7.Assignment;
class Artwork {
    void display() {
        System.out.println("Displaying generic artwork...");
    }
}
class Painting extends Artwork {
    void showPaintingDetails() {
        System.out.println("Brush Technique, Color Palette, Frame Specs.");
    }
}
class Sculpture extends Artwork {
    void showSculptureDetails() {
        System.out.println("Material Composition, Dimensions, Lighting Requirements.");
    }
}
class DigitalArt extends Artwork {
    void showDigitalDetails() {
        System.out.println("Resolution, File Formats, Interactive Elements.");
    }
}
class Photography extends Artwork {
    void showPhotoDetails() {
        System.out.println("Camera Settings, Editing Details, Print Specifications.");
    }
}
public class ArtGallery {
    public static void main(String[] args) {
        Artwork[] collection = {new Painting(),new Sculpture(),new DigitalArt(),new Photography(),new Painting()};
        for (Artwork art : collection) {
            art.display();
            if (art instanceof Painting)
                ((Painting) art).showPaintingDetails();
            else if (art instanceof Sculpture)
                ((Sculpture) art).showSculptureDetails();
            else if (art instanceof DigitalArt)
                ((DigitalArt) art).showDigitalDetails();
            else if (art instanceof Photography)
                ((Photography) art).showPhotoDetails();
            System.out.println();
        }
    }
}