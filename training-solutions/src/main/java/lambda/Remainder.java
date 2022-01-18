package lambda;

import java.util.ArrayList;
import java.util.List;

public class Remainder {
    public List<Integer> changeNumbersToRemainders(List<Integer> numbers, int divisor) {
        List<Integer> result = new ArrayList<>(numbers);
        result.replaceAll(n -> n % divisor);
        return result;
    }
}
