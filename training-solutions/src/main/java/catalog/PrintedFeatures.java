package catalog;

import java.util.ArrayList;
import java.util.List;

public class PrintedFeatures implements Feature{
    private String title;
    private int numberOfPages;
    private List<String> authors = new ArrayList<>();

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        if (Validators.isEmpty(authors)) {
            throw new IllegalArgumentException("The author list is empty!");
        }
        if (numberOfPages <= 0) {
            throw new IllegalArgumentException("The number of pages must be greater than zero!");
        }
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.authors = authors;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public List<String> getContributors() {
        return new ArrayList<>(authors);
    }
}
