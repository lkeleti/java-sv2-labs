package algorithmsfilter.prefix;

import java.util.ArrayList;
import java.util.List;

public class Prefix {
    public List<String> getWordsStartWith(List<String> words, String prefix) {
        List<String> filteredList = new ArrayList<>();
        for (String item: words) {
            if (item.startsWith(prefix)) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }
}
