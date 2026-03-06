package Week_7.Lab;
import java.util.*;
class SocialMediaPost {
    protected String author;
    protected String content;
    protected String time;
    public SocialMediaPost(String author, String content, String time) {
        this.author = author;
        this.content = content;
        this.time = time;
    }
    public void display() {
        System.out.println("Author: " + author);
        System.out.println("Content: " + content);
        System.out.println("Time: " + time);
    }
}
class InstagramPost extends SocialMediaPost {
    private List<String> hashtags;
    private int likes;
    public InstagramPost(String author, String content, String time, List<String> hashtags, int likes) {
        super(author, content, time);
        this.hashtags = hashtags;
        this.likes = likes;
    }
    @Override
    public void display() {
        super.display();
        System.out.print("Hashtags: ");
        for (String tag : hashtags) {
            System.out.print("#" + tag + " ");
        }
        System.out.println();
        System.out.println("Likes: " + likes);
        System.out.println();
    }
}
class TwitterPost extends SocialMediaPost {
    private int retweets;
    public TwitterPost(String author, String content, String time, int retweets) {
        super(author, content, time);
        this.retweets = retweets;
    }
    @Override
    public void display() {
        super.display();
        System.out.println("Character Count: " + content.length());
        System.out.println("Retweets: " + retweets);
        System.out.println();
    }
}
class LinkedInPost extends SocialMediaPost {
    private int connections;
    public LinkedInPost(String author, String content, String time, int connections) {
        super(author, content, time);
        this.connections = connections;
    }
    @Override
    public void display() {
        System.out.println("LinkedIn Professional Post");
        super.display();
        System.out.println("Connections: " + connections);
        System.out.println();
    }
}
public class SocialMediaFeed {
    public static void main(String[] args) {
        InstagramPost insta = new InstagramPost(
            "Alice", "Enjoying the sunset!", "2025-09-24",
            Arrays.asList("sunset", "nature", "beautiful"), 120
        );

        TwitterPost tweet = new TwitterPost(
            "Bob", "Java is awesome! #coding", "2025-09-24", 45
        );

        LinkedInPost linkedin = new LinkedInPost(
            "Carol", "Excited to join the new team!", "2025-09-24", 500
        );
        insta.display();
        tweet.display();
        linkedin.display();
    }
}
