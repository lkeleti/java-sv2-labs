package collectionsset;

import java.util.*;

public class QuestionGame {
    private List<RightAnswer> rightAnswers = new ArrayList<>();

    public QuestionGame(List<RightAnswer> rightAnswers) {
        this.rightAnswers = rightAnswers;
    }

    public Set<String> drawWinners() {
        if (rightAnswers.size() < 5) {
            throw new IllegalArgumentException("Not enough right answers!");
        }
        Random random = new Random();
        Set<String> result = new HashSet<>();
        while (result.size() < 5) {
            int winner = random.nextInt(rightAnswers.size());
            result.add(rightAnswers.get(winner).getName());
        }
        return result;
    }
}
