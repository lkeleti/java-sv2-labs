package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Read {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<String> listBookTitlesShorterThanGiven(int maxNumberOfPages) {
        return books.stream().
                filter(b->b.getPages() < maxNumberOfPages).
                map(b->b.getTitle()).
                collect(Collectors.toList());
    }

    public List<String> listBookTitlesWithGivenAuthor(String author) {
        return books.stream().
                filter(b->b.getAuthor().equals(author)).
                map(b->b.getTitle()).
                sorted().
                collect(Collectors.toList());

    }

    public List<String> listAuthors() {
        return books.stream().
                map(b->b.getAuthor()).
                distinct().
                collect(Collectors.toList());
    }
}
