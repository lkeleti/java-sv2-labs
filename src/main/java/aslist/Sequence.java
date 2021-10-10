package aslist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sequence {
    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>(Arrays.asList(1, 2));
        System.out.println(elements);

        for (int i = 0; i < 5; i++) {
            int defElement = elements.size();
            elements.add(elements.get(defElement-2)*elements.get(defElement-1));
        }

        System.out.println(elements);
        System.out.println(elements.size());
    }
}
