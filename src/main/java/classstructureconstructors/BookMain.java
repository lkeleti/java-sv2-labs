package classstructureconstructors;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book("Ernest Hemingway","Öreg halász és a tenger");
        System.out.println(book.getAuthor());
        System.out.println(book.getTitle());
        book.register("12345678");
        System.out.println(book.getRegNumber());
    }


}
