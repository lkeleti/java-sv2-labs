package compositionlist;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<String> titles = new ArrayList<>();

    public void addBook(String title) {
        titles.add(title);
    }

    public List<String> getTitles() {
        return titles;
    }

    public void findBookAndSetAuthor(String title, String author) {
        int idx = -1;
        for (int i = 0; i < titles.size(); i++) {
            if (titles.get(i).equals(title)) {
                idx = i;
                break;
            }
        }

        if (idx != -1) {
            titles.set(idx,author + ": " + title);
        }
    }
}
