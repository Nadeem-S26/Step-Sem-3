package Week_3.Lab;
class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    private static int totalBooks = 0;
    private static int availableBooks = 0;
    private static int bookCounter = 0;
    public Book(String title, String author) {
        this.bookId = generateBookId();
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        totalBooks++;
        availableBooks++;
    }
    public static String generateBookId() {
        bookCounter++;
        return "BOOK" + String.format("%03d", bookCounter);
    }
    public boolean issueBook() {
        if (isAvailable) {
            isAvailable = false;
            availableBooks--;
            return true;
        }
        return false;
    }
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            availableBooks++;
        }
    }
    public void displayBookInfo() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + isAvailable);
        System.out.println();
    }
    public String getBookId() {
        return bookId;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public static void displayStats() {
        System.out.println("Total Books: " + totalBooks);
        System.out.println("Available Books: " + availableBooks);
    }
}
class Member {
    private String memberId;
    private String memberName;
    private String[] booksIssued;
    private int bookCount;
    private static int memberCounter = 0;
    public Member(String memberName) {
        this.memberId = generateMemberId();
        this.memberName = memberName;
        this.booksIssued = new String[5]; 
        this.bookCount = 0;
    }
    public static String generateMemberId() {
        memberCounter++;
        return "MEM" + String.format("%03d", memberCounter);
    }
    public void borrowBook(Book book) {
        if (book.isAvailable() && bookCount < booksIssued.length) {
            if (book.issueBook()) {
                booksIssued[bookCount++] = book.getBookId();
                System.out.println(memberName + " borrowed " + book.getBookId());
            }
        } else {
            System.out.println("Cannot borrow book: either unavailable or limit reached.");
        }
    }
    public void returnBook(String bookId, Book[] books) {
        for (int i = 0; i < bookCount; i++) {
            if (booksIssued[i].equals(bookId)) {
                for (Book book : books) {
                    if (book.getBookId().equals(bookId)) {
                        book.returnBook();
                        System.out.println(memberName + " returned " + bookId);
                        booksIssued[i] = null;
                        shiftBooksLeft(i);
                        bookCount--;
                        return;
                    }
                }
            }
        }
        System.out.println("Book ID not found in member's issued list.");
    }
    private void shiftBooksLeft(int index) {
        for (int i = index; i < bookCount - 1; i++) {
            booksIssued[i] = booksIssued[i + 1];
        }
        booksIssued[bookCount - 1] = null;
    }
    public void displayMemberInfo() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Member Name: " + memberName);
        System.out.print("Books Issued: ");
        for (int i = 0; i < bookCount; i++) {
            System.out.print(booksIssued[i] + " ");
        }
        System.out.println("\n");
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book[] books = new Book[3];
        books[0] = new Book("The Alchemist", "Paulo Coelho");
        books[1] = new Book("Clean Code", "Robert C. Martin");
        books[2] = new Book("Java: The Complete Reference", "Herbert Schildt");
        Member[] members = new Member[2];
        members[0] = new Member("Nadeem");
        members[1] = new Member("Aarav");
        Book.displayStats();
        members[0].borrowBook(books[0]);
        members[0].borrowBook(books[1]);
        members[1].borrowBook(books[2]);
        Book.displayStats();
        members[0].displayMemberInfo();
        members[1].displayMemberInfo();
        members[0].returnBook("BOOK001", books);
        members[1].returnBook("BOOK003", books);
        Book.displayStats();
        members[0].displayMemberInfo();
        members[1].displayMemberInfo();
        for (Book book : books) {
            book.displayBookInfo();
        }
    }
}