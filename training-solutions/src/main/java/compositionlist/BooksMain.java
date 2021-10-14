package compositionlist;

import attributes.book.Book;

import java.sql.SQLOutput;
import java.util.Scanner;

public class BooksMain {
    public static void main(String[] args) {
        Books books = new Books();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Hány darab könyv címet szeretne eltárolni? ");
        int pieces = scanner.nextInt();

        scanner.nextLine();

        for ( int i = 0; i < pieces; i++) {
            System.out.print("Írja be az " + (i + 1) + ". könyv címét: ");
            books.addBook(scanner.nextLine());
        }

        System.out.println(books.getTitles());

        System.out.println("Szerző felvétele.");
        System.out.print("Kérem a könyv címét: ");
        String title = scanner.nextLine();
        System.out.print("Kérem a szerzőt: ");
        String author = scanner.nextLine();
        books.findBookAndSetAuthor(title, author);

        System.out.println(books.getTitles());
    }
}
