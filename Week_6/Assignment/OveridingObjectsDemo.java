package Week_6.Assignment;
class Game {
    protected String title;
    protected int players;
    public Game(String title, int players) {
        this.title = title;
        this.players = players;
    }
    @Override
    public String toString() {
        return "Game: " + title + ", Players: " + players;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Game)) return false;
        Game other = (Game) obj;
        return this.title.equals(other.title) && this.players == other.players;
    }
    @Override
    public int hashCode() {
        return title.hashCode() + players;
    }
}
class CardGame extends Game {
    private String deckType;
    public CardGame(String title, int players, String deckType) {
        super(title, players);
        this.deckType = deckType;
    }
    @Override
    public String toString() {
        return super.toString() + ", Deck Type: " + deckType;
    }
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof CardGame)) return false;
        CardGame other = (CardGame) obj;
        return this.deckType.equals(other.deckType);
    }
    @Override
    public int hashCode() {
        return super.hashCode() + deckType.hashCode();
    }
}
public class OveridingObjectsDemo {
    public static void main(String[] args) {
        CardGame cg1 = new CardGame("Poker", 4, "Standard");
        CardGame cg2 = new CardGame("Poker", 4, "Standard");
        CardGame cg3 = new CardGame("Bridge", 4, "Standard");
        System.out.println(cg1.toString()); 
        System.out.println("cg1 equals cg2? " + cg1.equals(cg2)); 
        System.out.println("cg1 equals cg3? " + cg1.equals(cg3));
    }
}