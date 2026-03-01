package Week_4.Assignment;
class Book {
    String title;
    String author;
    String isbn;
    boolean isAvailable;
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.isbn = "N/A";
        this.isAvailable = true;
    }
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isbn = "N/A";
        this.isAvailable = true;
    }
    public Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have borrowed \"" + title + "\".");
        } else {
            System.out.println("Sorry, \"" + title + "\" is already borrowed.");
        }
    }
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("You have returned \"" + title + "\".");
        } else {
            System.out.println("\"" + title + "\" was not borrowed.");
        }
    }
    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("---------------------------");
    }
}
public class LibraryManagement {
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("The Alchemist", "Paulo Coelho");
        Book b3 = new Book("Clean Code", "Robert C. Martin", "978-0132350884", true);
        b1.displayBookInfo();
        b2.displayBookInfo();
        b3.displayBookInfo();
        b2.borrowBook();
        b2.displayBookInfo();
        b2.borrowBook(); 
        b2.returnBook();
        b2.displayBookInfo();
        b3.borrowBook();
        b3.displayBookInfo();
    }
}