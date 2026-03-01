package Week_4.Practice;
public class Book {
    String title;
    String author;
    double price;
    public Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0.0;
    }
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
        System.out.println();
    }
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book("The Pragmatic Programmer", "Andrew Hunt", 599.0);
        System.out.println("Book 1 Details:");
        book1.displayBookInfo();
        System.out.println("Book 2 Details:");
        book2.displayBookInfo();
    }
}