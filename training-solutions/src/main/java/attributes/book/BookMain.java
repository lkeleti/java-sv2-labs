package attributes.book;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book("Gyűrűk úra");

        System.out.println(book.getTitle());
        book.setTitle("Harry Potter");
        System.out.println(book.getTitle());
    }
}
