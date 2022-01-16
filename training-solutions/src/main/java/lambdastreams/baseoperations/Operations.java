package lambdastreams.baseoperations;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Operations {
    private List<Integer> numbers;

    public Operations(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public Optional<Integer> min() {
        return numbers.stream().min(
                Comparator.comparingInt(n -> n)
        );
    }

    public Integer sum() {
        BinaryOperator<Integer> bOAdd = (a, b) -> a + b;
        return numbers.stream().reduce(0, bOAdd, bOAdd);
    }
    public boolean isAllPositive() {
        Predicate<Integer> gz = n -> n > 0;
        return numbers.stream().allMatch(gz);
    }

    public Set<Integer> getDistinctElements() {
        return numbers.stream().collect(Collectors.toSet());
    }
}
