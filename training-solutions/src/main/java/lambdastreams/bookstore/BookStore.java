package lambdastreams.bookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookStore {
    private List<Book> books;

    public BookStore(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public Integer getNumberOfBooks() {
        return books.stream().reduce(0,(n, b2) -> n + b2.getPieces(), (n1, n2) -> n1+n2);
    }

    public Optional<Book> findNewestBook() {
        return books.stream().max((b1,b2) -> b1.getYearOfPublish() - b2.getYearOfPublish());
    }

    public Integer getTotalValue() {
        return books.stream().reduce(
                0,
                (n,b) -> n+ (b.getPrice()*b.getPieces()),
                (n1, n2) -> n1 + n2
        );
    }

    public List<Book> getByYearOfPublish(int year) {
        return books.stream().collect(Collectors.groupingBy(Book::getYearOfPublish)).get(year);
    }
}
