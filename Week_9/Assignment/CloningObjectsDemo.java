package Week_9.Assignment;
import java.util.ArrayList;
import java.util.List;
class Book implements Cloneable {
    String title;
    public Book(String title) {
        this.title = title;
    }
    @Override
    protected Book clone() throws CloneNotSupportedException {
        return (Book) super.clone(); 
    }
    @Override
    public String toString() {
        return title;
    }
}
class Library implements Cloneable {
    List<Book> books;
    public Library(List<Book> books) {
        this.books = books;
    }
    public Library shallowClone() throws CloneNotSupportedException {
        return (Library) super.clone();
    }
    public Library deepClone() throws CloneNotSupportedException {
        Library cloned = (Library) super.clone();
        List<Book> clonedBooks = new ArrayList<>();
        for (Book b : this.books) {
            clonedBooks.add(b.clone());
        }
        cloned.books = clonedBooks;
        return cloned;
    }
    @Override
    public String toString() {
        return books.toString();
    }
}
public class CloningObjectsDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Book> originalBooks = new ArrayList<>();
        originalBooks.add(new Book("Java Basics"));
        originalBooks.add(new Book("Data Structures"));
        Library originalLibrary = new Library(originalBooks);
        Library shallowCopy = originalLibrary.shallowClone();
        Library deepCopy = originalLibrary.deepClone();
        shallowCopy.books.get(0).title = "Advanced Java"; 
        System.out.println("Original Library: " + originalLibrary);
        System.out.println("Shallow Copy:     " + shallowCopy);
        System.out.println("Deep Copy:        " + deepCopy);
    }
}