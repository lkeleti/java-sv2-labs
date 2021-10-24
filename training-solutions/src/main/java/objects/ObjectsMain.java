package objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectsMain {
    public static void main(String[] args) {
        class Book {
        }

        new Book();
        // Tudom példányosítani, de később nem tudok hozzáférni.
        System.out.println(new Book());

        Book emptyBook;
        /* System.out.println(emptyBook);
        értékadás nélkül nem lehet kiiratni
         */
        
        emptyBook = null;
        System.out.println(emptyBook);
        System.out.println(emptyBook == null);

        Book book = new Book();
        System.out.println(book);
        book = null;
        System.out.println(book);
        book = new Book();
        System.out.println(book);

        Book anotherBook = new Book();
        System.out.println(anotherBook);
        System.out.println(book == anotherBook);

        anotherBook = book;
        System.out.println(book == anotherBook);

        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = book1;
        Book book5 = book1;
        Book book6 = book3;
        Book book7 = null;
        book4 = book6;
        new Book();
        book5 = new Book();
        book6 = null;
        book5 = book4;
        // öt objektum kerül létrehozásra, de csak háromhoz lehet a végén hozzáférni: book1, book2 és book3

        Book[] books = {book1, book2, book3};
        List<Book> bookList = Arrays.asList(book1, book2, book3);
        List<Book> newBookList = new ArrayList<>();
        newBookList.add(book1);
        newBookList.add(book2);
        newBookList.add(book3);

        System.out.println(Arrays.toString(books));
        System.out.println(bookList);
        System.out.println(newBookList);
    }
}
