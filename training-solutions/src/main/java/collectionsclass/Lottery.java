package collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottery {
    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (lotteryType >= ballCount) {
            throw new IllegalArgumentException("There must be more balls than the winning numbers!");
        }
        initBalls(ballCount);
        Collections.shuffle(numbers);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < lotteryType; i++) {
            result.add(numbers.get(i)+1);
        }
        return result;
    }

    private void initBalls(int ballCount) {
        numbers.clear();
        for (int i = 0; i < ballCount ; i++) {
            numbers.add(i);
        }
    }
}
