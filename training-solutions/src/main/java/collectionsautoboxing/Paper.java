package collectionsautoboxing;

import java.util.HashMap;
import java.util.Map;

public class Paper {
    private Map<String, Integer> paper = new HashMap<>();

    public Map<String, Integer> getPaper() {
        return new HashMap<>(paper);
    }

    public void putFurtherPaper(String className, int kilogramms) {
        if (paper.containsKey(className)) {
            paper.put(className, paper.get(className) + kilogramms);
        } else {
            paper.put(className, kilogramms);
        }
    }

    public String getWinnerClass() {
        String winnerClass = "";
        int winnerKgs = Integer.MIN_VALUE;

        for (String className : paper.keySet()) {
            int actualKgs = paper.get(className);
            if (actualKgs > winnerKgs){
                winnerClass = className;
                winnerKgs = actualKgs;
            }
        }
        return winnerClass;
    }

    public int getTotalWeight() {
        int total = 0;
        for (int kgs: paper.values()){
            total += kgs;
        }
        return total;
    }
}

