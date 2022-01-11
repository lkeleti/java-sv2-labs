package searching;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BookSearch {
    private List<Book> books = new ArrayList<>();

    public BookSearch(List<Book> books) {
        this.books = books;
    }

    public Book findBookByAuthorTitle(String author, String title) {
        if (isNull(author) || isNull(title)) {
            throw new IllegalArgumentException("Author or title must not be empty!");
        }
        Book key = new Book(author, title);
        Collections.sort(books);
        int index = Collections.binarySearch(books, key);
        if (index < 0) {
            throw new IllegalArgumentException("No book found by " + author + " with title " + title);
        }
        return books.get(index);

    }

    private boolean isNull(String text) {
        return text == null || text.isEmpty() || text.isBlank();
    }
}
