package Week_9.Lab;
class Book {
    private String title;
    private String author;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // same reference
        if (obj == null || getClass() != obj.getClass()) return false;

        Book other = (Book) obj;
        return title.equals(other.title) && author.equals(other.author);
    }
    @Override
    public String toString() {
        return "\"" + title + "\" by " + author;
    }
}

public class Books {
    public static void main(String[] args) {
        Book book1 = new Book("The Alchemist", "Paulo Coelho");
        Book book2 = new Book("The Alchemist", "Paulo Coelho");
        Book book3 = book1; 
        System.out.println("book1 == book2: " + (book1 == book2));
        System.out.println("book1 == book3: " + (book1 == book3));
        System.out.println("book1.equals(book2): " + book1.equals(book2));
        System.out.println("book1.equals(book3): " + book1.equals(book3)); 
    }
}