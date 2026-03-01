package Week_4.Assignment;
class MovieTicket {
    String movieName;
    String theatreName;
    int seatNumber;
    double price;
    public MovieTicket() {
        this.movieName = "Unknown";
        this.theatreName = "Not Assigned";
        this.seatNumber = -1;
        this.price = 0.0;
    }
    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.theatreName = "Not Assigned";
        this.seatNumber = -1;
        this.price = 200.0;
    }
    public MovieTicket(String movieName, int seatNumber) {
        this.movieName = movieName;
        this.theatreName = "PVR";
        this.seatNumber = seatNumber;
        this.price = 200.0;
    }
    public MovieTicket(String movieName, String theatreName, int seatNumber, double price) {
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.seatNumber = seatNumber;
        this.price = price;
    }
    public void printTicket() {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Theatre Name: " + theatreName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: Rs. " + price);
        System.out.println("---------------------------");
    }
}
public class MovieTicketBooking {
    public static void main(String[] args) {
        MovieTicket ticket1 = new MovieTicket();
        MovieTicket ticket2 = new MovieTicket("Inception");
        MovieTicket ticket3 = new MovieTicket("Interstellar", 15);
        MovieTicket ticket4 = new MovieTicket("The Dark Knight", "IMAX", 42, 350.0);
        ticket1.printTicket();
        ticket2.printTicket();
        ticket3.printTicket();
        ticket4.printTicket();
    }
}