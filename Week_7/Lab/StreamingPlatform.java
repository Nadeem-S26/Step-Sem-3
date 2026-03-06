package Week_7.Lab;
class Content {
    void play() {
        System.out.println("Playing content...");
    }
}
class Movie extends Content {
    void showMovieDetails() {
        System.out.println("Movie: Rating, Duration, Subtitles available.");
    }
}
class TVSeries extends Content {
    void showSeriesDetails() {
        System.out.println("TV Series: Seasons, Episodes, Next episode suggestion.");
    }
}
class Documentary extends Content {
    void showDocumentaryDetails() {
        System.out.println("Documentary: Educational tags and related content.");
    }
}
public class StreamingPlatform {
    public static void main(String[] args) {
        Content[] watchlist = {new Movie(),new TVSeries(),new Documentary(),new Movie()};
        for (Content c : watchlist) {
            c.play();
            if (c instanceof Movie)
                ((Movie) c).showMovieDetails();
            else if (c instanceof TVSeries)
                ((TVSeries) c).showSeriesDetails();
            else if (c instanceof Documentary)
                ((Documentary) c).showDocumentaryDetails();
            System.out.println();
        }
    }
}